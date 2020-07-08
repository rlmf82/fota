package man.fota.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;

import man.fota.entity.ArtifactTypeEnum;
import man.fota.entity.PropertyKeyEnum;
import man.fota.request.dto.RegistryRequest;
import man.fota.request.dto.SaveOrUpdateFileRequest;
import man.fota.service.CSVReaderService;
import man.fota.service.FileService;
import man.fota.service.PropertyService;
import man.fota.util.Messages;

@Service
public class CSVReaderServiceImpl implements CSVReaderService {

	private PropertyService propertyService;
	
	private FileService fileService;
	
	private TruckServiceImpl truckService;
	
	 private static final Logger logger = LoggerFactory.getLogger(CSVReaderServiceImpl.class);
	
	public CSVReaderServiceImpl(FileService fileService, PropertyService propertyService, TruckServiceImpl truckService) {
		this.truckService = truckService;
		this.propertyService = propertyService;
		this.fileService = fileService;		
	}
	
	public void processFiles() throws Exception {
		List<Path> files = getFilesFromFolder();
		
		files.forEach(file -> process(file));
	}
	
	public void process(Path file) {
		Reader reader = null;
		try {
			logger.info("Starting process to file: " + file.getFileName().toString());
			String reprocess = this.propertyService.getProperty(PropertyKeyEnum.REPROCESS).getValue();
			
			Boolean alreadyProcessed = fileService.exists(file.getFileName().toString());
			
			if(alreadyProcessed && !Boolean.valueOf(reprocess)) {
				logger.info(file.getFileName().toString() + " was already processed");
				saveLogFile(file.getFileName().toString(), Messages.MESSAGE_NOT_PROCESSED);
				return;
			}
			
			reader = Files.newBufferedReader(file);
			List<RegistryRequest> registries = read(reader, file.getFileName().toString());
			
			truckService.saveRegistries(registries);
			
			SaveOrUpdateFileRequest request = new SaveOrUpdateFileRequest();
			request.setLastExecution(LocalDateTime.now());
			request.setName(file.getFileName().toString());
			
			fileService.saveOrUpdate(request);
			
			saveLogFile(file.getFileName().toString(), Messages.MESSAGE_SUCCESS);
			logger.info(file.getFileName().toString() + " processed sucessfully");
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	
	private void saveLogFile(String fileName, String message) throws IOException {
		String folderPath = this.propertyService.getProperty(PropertyKeyEnum.FOLDER_PATH).getValue();
		
		message = message +" "+ LocalDateTime.now();
		folderPath = folderPath + File.separator + fileName + ".log";
		
		Files.write(Paths.get(folderPath), message.getBytes());
	}

	public List<Path> getFilesFromFolder() throws IOException {
		String folderPath = this.propertyService.getProperty(PropertyKeyEnum.FOLDER_PATH).getValue();
		String extension = this.propertyService.getProperty(PropertyKeyEnum.EXTENSION).getValue();
		
		Stream<Path> path = Files.walk(Paths.get(folderPath));
		
		List<Path> paths = path
				.filter(Files::isRegularFile)
				.filter(file -> file.getFileName().toString().endsWith(extension))
				.collect(Collectors.toList());
		
		path.close();
		
		return paths;
	}
	
	private List<RegistryRequest> read(Reader reader, String filename) throws IOException {
		List<RegistryRequest> list = new ArrayList<>();
	    CSVReader csvReader = new CSVReader(reader);
	    String[] line;
	    
	    while ((line = csvReader.readNext()) != null) {

	    	ArtifactTypeEnum artifactType = null;

	    	if(filename.startsWith(ArtifactTypeEnum.SOFTWARE.getPrefix())){
	    		artifactType = ArtifactTypeEnum.SOFTWARE;
	    		
		    } else if(filename.startsWith(ArtifactTypeEnum.HARDWARE.getPrefix())){
		    	artifactType = ArtifactTypeEnum.HARDWARE;
		    }
	    	
	    	list.add(new RegistryRequest(line[0], line[1], artifactType));
	    }
	    
	    reader.close();
	    csvReader.close();
	    
	    return list;
	}
}