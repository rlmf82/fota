package man.fota.service;

import java.io.FileNotFoundException;

import man.fota.request.dto.SaveOrUpdateFileRequest;
import man.fota.response.dto.FileResponse;

public interface FileService {

	public FileResponse saveOrUpdate(SaveOrUpdateFileRequest request);

	public FileResponse findByName(String name) throws FileNotFoundException;
	
	public Boolean exists(String name);
	
}