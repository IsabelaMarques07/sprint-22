package br.com.sprint.sprintproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String cnpj;
	
	public User() {
	
	}
	
	public User(int idUser, String name, String email, String password, String cnpj) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.email = email;
		this.password = password;
		this.cnpj = cnpj;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
