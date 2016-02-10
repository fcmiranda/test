package org.fiveware.web.area;

import java.util.List;

import org.fiveware.service.area.AreaDTO;
import org.fiveware.service.area.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/area/")
public class AreaController {

	@Autowired
	private AreaService service;

	@RequestMapping(value = "list", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<AreaDTO> getAreas() {
		return service.getAreas();
	}

}
