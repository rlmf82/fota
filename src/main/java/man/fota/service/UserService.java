package man.fota.service;

import java.util.List;

import man.fota.request.dto.UserRequest;
import man.fota.response.dto.UserResponse;

public interface UserService {

    public List<UserResponse> list();

    public void save(UserRequest usuario);
	
    public boolean exist(String login);
}
