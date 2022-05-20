package br.com.sprint.sprintproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVehicle;
	@Column(nullable = false)
	private String licensePlate;
	@Column(nullable = false)
	private int idModel;
	@Column(nullable = false)
	private int idUser;
	
	public Vehicle() {

	}
	
	public Vehicle(int idVehicle, String licensePlate, int idModel, int idUser) {
		super();
		this.idVehicle = idVehicle;
		this.licensePlate = licensePlate;
		this.idModel = idModel;
		this.idUser = idUser;
	}

	public int getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(int idVehicle) {
		this.idVehicle = idVehicle;
	}

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
	
}
