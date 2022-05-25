package br.com.sprint.sprintproject.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.sprint.sprintproject.DTO.PartDTO;
import br.com.sprint.sprintproject.models.Part;
import br.com.sprint.sprintproject.models.User;
import br.com.sprint.sprintproject.repositories.PartRepository;

@Controller
public class PartController {
	@Autowired
	private PartRepository partRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/pecas/{id}")
	public ModelAndView index(@PathVariable int id, HttpServletRequest request) {
		ModelAndView modelView = new ModelAndView("parts/showParts");
		request.setAttribute("id", Integer.toString(id));
		List<Part> partsDaRepository = partRepository.findByIdVehicle(id);
		modelView.addObject("listarPecas", partsDaRepository);
		return modelView;
	}
	@GetMapping("/peca/{id}")
	public ModelAndView part(@PathVariable int id, HttpServletRequest request, PartDTO partDto) {
		Optional<Part> optionalPart = partRepository.findById(id);
		request.setAttribute("id", Integer.toString(id));
		if (optionalPart.isPresent()) {
			Part part = optionalPart.get();
			partDto.fromPart(part);
			ModelAndView model = new ModelAndView("parts/showPart");
			model.addObject("partId", part.getIdPart());
			return model;
		}
		//
		return new ModelAndView("redirect:/home");
	}
}
