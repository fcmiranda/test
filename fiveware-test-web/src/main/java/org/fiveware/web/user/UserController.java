package org.fiveware.web.user;

import java.util.List;

import javax.validation.Valid;

import org.fiveware.model.user.User;
import org.fiveware.service.user.UserDTO;
import org.fiveware.service.user.UserService;
import org.fiveware.web.validation.MessageDTO;
import org.fiveware.web.validation.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<UserDTO> getUsers() {
		return service.getUsers();
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<MessageDTO> createUser(@Valid @RequestBody User user, UriComponentsBuilder ucBuilder) {

		service.save(user);

		MessageDTO messageDTO = new MessageDTO(MessageType.SUCCESS, "Salvo com sucesso!");

		return new ResponseEntity<MessageDTO>(messageDTO, HttpStatus.CREATED);
	}
}
