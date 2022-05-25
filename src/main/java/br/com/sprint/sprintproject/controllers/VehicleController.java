package br.com.sprint.sprintproject.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sprint.sprintproject.DTO.VehicleDTO;
import br.com.sprint.sprintproject.models.Vehicle;
import br.com.sprint.sprintproject.repositories.VehicleRepository;

@Controller
public class VehicleController {
	
	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/vehicles/{id}")
	public ModelAndView index(@PathVariable int id) {
		ModelAndView modelView = new ModelAndView("vehicles/showVehicles");

		List<Vehicle> vehiclesDaRepository = vehicleRepository.findByIdUser(id);
		modelView.addObject("listarVeiculos", vehiclesDaRepository);

		return modelView;
	}
	
	@GetMapping("/vehicles/{id}/new")
	public ModelAndView create(@PathVariable int id, VehicleDTO vehicle) {
		ModelAndView modelView = new ModelAndView("vehicles/addVehicle");
		return modelView;
	}

}
