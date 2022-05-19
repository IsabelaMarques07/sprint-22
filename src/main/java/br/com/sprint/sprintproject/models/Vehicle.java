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
	private String model;
	@Column(nullable = false)
	private int idUser;
	
	public Vehicle() {

	}
	
	public Vehicle(int idVehicle, String licensePlate, String model, int idUser) {
		super();
		this.idVehicle = idVehicle;
		this.licensePlate = licensePlate;
		this.model = model;
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
}
