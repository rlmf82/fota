package man.fota.serviceImpl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;

import man.fota.entity.ArtifactTypeEnum;
import man.fota.entity.PropertyKeyEnum;
import man.fota.request.dto.RegistryRequest;
import man.fota.service.CSVReaderService;
import man.fota.service.PropertyService;

@Service
public class CSVReaderServiceImpl implements CSVReaderService {

	private PropertyService propertyService;
	
	private TruckServiceImpl truckService;
	
	private final String folderPath;
	private final String extension;
		
	public CSVReaderServiceImpl(PropertyService propertyService, TruckServiceImpl truckService) {
		this.truckService = truckService;
		this.propertyService = propertyService;
		
		this.folderPath = this.propertyService.getProperty(PropertyKeyEnum.FOLDER_PATH).getValue();
		this.extension = this.propertyService.getProperty(PropertyKeyEnum.EXTENSION).getValue();
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
	
	public void processFiles() throws Exception {
		List<Path> files = getFilesFromFolder();
		
		files.forEach(file -> process(file));
	}
	
	public void process(Path file) {
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(file);
			List<RegistryRequest> registries = read(reader, file.getFileName().toString());
			
			truckService.saveRegistries(registries);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Path> getFilesFromFolder() throws IOException {
		Stream<Path> path = Files.walk(Paths.get(folderPath));
		
		List<Path> paths = path
				.filter(Files::isRegularFile)
				.filter(file -> file.getFileName().toString().endsWith(extension))
				.collect(Collectors.toList());
		
		path.close();
		
		return paths;
	}
}