package org.fiveware.service.area;

import java.util.ArrayList;
import java.util.List;

import org.fiveware.model.area.Area;
import org.fiveware.model.area.AreaDAO;
import org.fiveware.model.skill.Skill;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AreaService {

	@Autowired
	private AreaDAO dao;
	
	//TODO: Refatorar loop para java 8 (Stream)
	public List<AreaDTO> getAreas() {
		List<Area> areas = dao.getAreas();
		ModelMapper mapper = new ModelMapper();
		ArrayList<AreaDTO> areasDTO = new ArrayList<AreaDTO>();
		for (Area area : areas) {
			AreaDTO dto = mapper.map(area, AreaDTO.class);
			areasDTO.add(dto);
		}
		return areasDTO;
	}
}
