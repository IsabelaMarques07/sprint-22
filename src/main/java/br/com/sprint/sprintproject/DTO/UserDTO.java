package br.com.sprint.sprintproject.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.sprint.sprintproject.models.User;

public class UserDTO {
	private String name;
	@NotBlank
	@NotNull
	private String email;
	@NotBlank
	@NotNull
	private String password;

	private String cnpj;

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
	
	public void fromUser(User user) {
		this.cnpj = user.getCnpj();
		this.email = user.getEmail();
		this.name = user.getName();
		this.password = user.getPassword();
	}
}
