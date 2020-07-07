package man.fota.serviceImpl;

import java.io.FileNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import man.fota.entity.File;
import man.fota.repository.FileRepository;
import man.fota.request.dto.SaveOrUpdateFileRequest;
import man.fota.response.dto.FileResponse;
import man.fota.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileRepository repository;

	@Override
	public FileResponse saveOrUpdate(SaveOrUpdateFileRequest request) {
		File file = new File();
		Optional<File> optFile = repository.findByName(request.getName());
		
		if(optFile.isPresent()) {
			file = optFile.get();
		}
		
		file.setName(request.getName());
		file.setLastExecution(request.getLastExecution());
		
		file = repository.save(file);
		
		return FileResponse.transform(file);
	}

	@Override
	public FileResponse findByName(String name) throws FileNotFoundException {
		
		Optional<File> file = repository.findByName(name);
		
		if(!file.isPresent()) {
			throw new FileNotFoundException();
		}
		
		return FileResponse.transform(file.get());
	}

	@Override
	public Boolean exists(String name) {
		
		Optional<File> file = repository.findByName(name);
		return file.isPresent();
	}
}