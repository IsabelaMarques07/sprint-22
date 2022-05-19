package br.com.sprint.sprintproject.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.sprint.sprintproject.models.Part;

public class PartDTO {
	
	@NotBlank
	@NotNull
	private String name;
	@NotBlank
	@NotNull
	private String status;
	@NotBlank
	@NotNull
	private int idVehicle;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(int idVehicle) {
		this.idVehicle = idVehicle;
	}
	
	public void fromPart(Part part) {
		this.idVehicle = part.getIdVehicle();
		this.name = part.getName();
		this.status = part.getStatus();
	}
}
