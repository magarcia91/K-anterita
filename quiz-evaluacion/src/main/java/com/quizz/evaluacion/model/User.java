package com.quizz.evaluacion.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name="tbl_user")
public class User implements UserDetails, Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;

	@NotEmpty
	@NotNull
	@Column(nullable = false, unique = true)
	private String username;

	@NotEmpty
	@NotNull
	@Column(nullable = false)
	private String password;

	@NotEmpty
	@NotNull
	@Column(nullable = false)
	private String name;
	@Column
	private boolean admin;
	@Column
	private boolean locked;
  
  
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantList = new ArrayList<>();
		if (Boolean.TRUE.equals(admin)) {
			GrantedAuthority adminAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
			GrantedAuthority userAuthority = new SimpleGrantedAuthority("ROLE_USER");
			grantList.add(adminAuthority);
			grantList.add(userAuthority);
		} else {
			GrantedAuthority userAuthority = new SimpleGrantedAuthority("ROLE_USER");
			grantList.add(userAuthority);
		}
		return grantList;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !locked;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !locked;
	}

	@Override
	public boolean isEnabled() {
		return !locked;
	}

	@Override
	public String getPassword() {		
		return password;
	}

}
