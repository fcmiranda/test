package org.fiveware.service.user;

import java.util.Date;
import java.util.List;

import org.fiveware.service.area.AreaDTO;
import org.fiveware.service.dto.LabelDTO;
import org.fiveware.service.skill.SkillDTO;

public class UserDTO extends LabelDTO{
	
	private String cpf;
	
	private String email;
	
	private Date birthDate;
	
	private Boolean active;
	
	private AreaDTO area;
	
	private List<SkillDTO> skills;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public AreaDTO getArea() {
		return area;
	}

	public void setArea(AreaDTO area) {
		this.area = area;
	}

	public List<SkillDTO> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillDTO> skills) {
		this.skills = skills;
	}
}
