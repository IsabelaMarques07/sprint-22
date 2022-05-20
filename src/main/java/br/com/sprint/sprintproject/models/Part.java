package br.com.sprint.sprintproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Part {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPart;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int idStatus;
	@Column(nullable = false)
	private int idVehicle;
	
	public Part() {

	}
	
	public Part(int idPart, String name, int idStatus, int idVehicle) {
		super();
		this.idPart = idPart;
		this.name = name;
		this.idStatus = idStatus;
		this.idVehicle = idVehicle;
	}

	public int getIdPart() {
		return idPart;
	}

	public void setIdPart(int idPart) {
		this.idPart = idPart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setidStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public int getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(int idVehicle) {
		this.idVehicle = idVehicle;
	}
		
}
