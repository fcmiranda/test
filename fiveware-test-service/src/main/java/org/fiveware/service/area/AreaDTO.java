package org.fiveware.service.area;

import java.util.List;

import org.fiveware.service.dto.LabelDTO;
import org.fiveware.service.skill.SkillDTO;

public class AreaDTO extends LabelDTO{
	
	private List<SkillDTO> skills;

	public List<SkillDTO> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillDTO> skills) {
		this.skills = skills;
	}

}
