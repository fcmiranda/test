package org.fiveware.service.user;

import java.util.ArrayList;
import java.util.List;

import org.fiveware.model.user.User;
import org.fiveware.model.user.UserDAO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDAO dao;
	
	//TODO: Refatorar loop para java 8 (Stream)
	public List<UserDTO> getUsers() {
		List<User> users = dao.getUsers();
		ModelMapper mapper = new ModelMapper();
		ArrayList<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for (User user : users) {
			UserDTO dto = mapper.map(user, UserDTO.class);
			usersDTO.add(dto);
		}
		return usersDTO;
	}

	public void save(User user) {
		dao.saveUser(user);
	}
}
