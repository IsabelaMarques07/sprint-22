package br.com.sprint.sprintproject.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sprint.sprintproject.DTO.UserDTO;
import br.com.sprint.sprintproject.models.User;
import br.com.sprint.sprintproject.repositories.UserRepository;

public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/login")
	public ModelAndView index(UserDTO user) {
		ModelAndView modelView = new ModelAndView("login/index");
		return modelView;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@Valid UserDTO user, BindingResult bindingResult) {
		User userLogin = userRepository.findByEmail(user.getEmail());
		
		if(bindingResult.hasErrors()) {
			System.out.println("Temos erros!");
			return new ModelAndView("login/index");
		}
		
		if(userLogin == null) {
			System.out.println("Usuário não existe!!!");
			bindingResult.rejectValue("username", "error.user", "Usuário não existe");
			return new ModelAndView("login/index");
		}else {
			if(user.getPassword().compareTo(userLogin.getPassword()) != 0) {
				bindingResult.rejectValue("password", "error.user", "Senha incorreta");
				return new ModelAndView("login/index");
			}else {
				return new ModelAndView("redirect:/home");
			}
		}
	}
	
	@GetMapping("/signup")
	public ModelAndView signup(UserDTO user) {
		ModelAndView modelView = new ModelAndView("signup/index");
		return modelView;
	}
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView modelView = new ModelAndView("/home");
		return modelView;
	}
	
	@PostMapping("/signup")
	public ModelAndView salvar(@Valid UserDTO user, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("Temos erros!");
			return new ModelAndView("/signup");
		}
		User userEntity = modelMapper.map(user, User.class);
		userRepository.save(userEntity);
		return new ModelAndView("redirect:/login");
	}
}
