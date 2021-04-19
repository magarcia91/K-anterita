package com.quizz.evaluacion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


/*@Entity
@Table(name="userdto")*/
public class UserDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUserDto;
	@NotEmpty
	private String name;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	private String confirmpassword;
  
  
	public Long getIdUserDto() {
		return idUserDto;
	}

	public void setIdUserDto(Long idUserDto) {
		this.idUserDto = idUserDto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	} 
  

}
