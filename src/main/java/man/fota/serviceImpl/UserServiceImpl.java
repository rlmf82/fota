package man.fota.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import man.fota.entity.User;
import man.fota.repository.UserRepository;
import man.fota.request.dto.UserRequestDTO;
import man.fota.response.dto.UserResponse;
import man.fota.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping
	public List<UserResponse> list() {
		List<User> users = userRepository.findAll();
		List<UserResponse> response = new ArrayList<>();
		
		if(users != null && !users.isEmpty()) {
			response = users.stream().map(UserResponse::tranform).collect(Collectors.toList());
		}
		
		return response;
	}

	@PostMapping
	public void save(UserRequestDTO request) {
		userRepository.saveAndFlush(User.transform(request, passwordEncoder));
	}

	@Override
	public boolean exist(String login) {
		return userRepository.exist(login).isPresent();
	}
}