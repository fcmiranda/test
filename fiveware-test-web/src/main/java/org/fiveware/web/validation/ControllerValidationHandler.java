package org.fiveware.web.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerValidationHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public List<MessageDTO> processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> errors = result.getFieldErrors();
		return processFieldError(errors);
	}

	private List<MessageDTO> processFieldError(List<FieldError> errors) {
		ArrayList<MessageDTO> list = new ArrayList<MessageDTO>();
		
		//TODO: Refatorar loop para java 8 (Stream)
		if (errors != null) {
			for (FieldError fieldError : errors) {
				MessageDTO messageDTO = new MessageDTO(MessageType.ERROR, fieldError.getDefaultMessage(),
						fieldError.getField());
				list.add(messageDTO);
			}

		}
		return list;
	}
}