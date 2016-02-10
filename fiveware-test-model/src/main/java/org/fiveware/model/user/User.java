package org.fiveware.model.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.fiveware.model.area.Area;
import org.fiveware.model.skill.Skill;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotBlank
	@CPF
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@NotBlank
	@Column(name = "email", nullable = false)
	private String email;
	
	@NotNull
	@Column(name = "birthdate", nullable = false)
	private Date birthDate;
	
	@NotNull
	@Column(name = "active", nullable = false)
	private Boolean active;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_area", nullable = false)
	private Area area;
		
	@NotNull
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_skill", joinColumns = {
	@JoinColumn(name = "id_user", nullable = false, updatable = false) }, inverseJoinColumns = {
	@JoinColumn(name = "id_skill", nullable = false, updatable = false) })
	private List<Skill> skills;

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birdDate) {
		this.birthDate = birdDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
