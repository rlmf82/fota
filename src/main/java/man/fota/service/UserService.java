package man.fota.service;

import java.util.List;

import man.fota.request.dto.UserRequestDTO;
import man.fota.response.dto.UserResponse;

public interface UserService {

    public List<UserResponse> list();

    public void save(UserRequestDTO usuario);
	
    public boolean exist(String login);
}
