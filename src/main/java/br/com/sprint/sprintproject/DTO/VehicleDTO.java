package br.com.sprint.sprintproject.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.sprint.sprintproject.models.Vehicle;

public class VehicleDTO {
	
	@NotNull
	@NotBlank
	private String licensePlate;
	@NotNull
	private int idModel;
	private int idUser;
	

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public int getIdModel() {
		return idModel;
	}

	public void setIdModel(int idModel) {
		this.idModel = idModel;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public void fromVehicle(Vehicle vehicle) {
		this.idUser = vehicle.getIdUser();
		this.licensePlate = vehicle.getLicensePlate();
		this.idModel = vehicle.getIdModel();
	}
}
