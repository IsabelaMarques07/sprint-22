package br.com.sprint.sprintproject.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sprint.sprintproject.DTO.UserDTO;
import br.com.sprint.sprintproject.models.User;
import br.com.sprint.sprintproject.repositories.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/login")
	public ModelAndView index(UserDTO user) {
		ModelAndView modelView = new ModelAndView("users/login");
		return modelView;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@Valid UserDTO user, BindingResult bindingResult) {
		User userLogin = userRepository.findByEmail(user.getEmail());
		
		if(bindingResult.hasErrors()) {
			System.out.println("Temos erros!");
			System.out.println(bindingResult);
			return new ModelAndView("users/login");
		}
		
		if(userLogin == null) {
			System.out.println("Email não cadastrado!!!");
			bindingResult.rejectValue("email", "error.user", "Email não cadastrado");
			return new ModelAndView("users/login\"");
		}else {
			if(user.getPassword().compareTo(userLogin.getPassword()) != 0) {
				bindingResult.rejectValue("password", "error.user", "Senha incorreta");
				return new ModelAndView("users/login\"");
			}else {
				return new ModelAndView("redirect:/home/"+userLogin.getIdUser());
			}
		}
	}

	@GetMapping("/signup")
	public ModelAndView signup(UserDTO user) {
		ModelAndView modelView = new ModelAndView("users/signup");
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
		return new ModelAndView("redirect:/home/"+userEntity.getIdUser());
	}

	@GetMapping("/home/{id}")
	public ModelAndView home(HttpServletRequest request, @PathVariable int id) {
		request.setAttribute("id", Integer.toString(id));
		ModelAndView modelView = new ModelAndView("home");
		return modelView;
	}
	
	@GetMapping("/config/{id}")
	public ModelAndView config(HttpServletRequest request, @PathVariable int id, UserDTO userDTO) {
		Optional<User> optionalUser = userRepository.findById(id);
		request.setAttribute("id", Integer.toString(id));
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			userDTO.fromUser(user);
			ModelAndView model = new ModelAndView("users/config");
			model.addObject("userId", user.getIdUser());
			return model;
		}

		//
		return new ModelAndView("redirect:/home");
	}
	
	@PostMapping("/config/{id}")
	public ModelAndView update(@PathVariable int id, @Valid UserDTO request, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("config/index");
			model.addObject("userId", id);
			return model;
		}
		
		Optional<User> optionalUser = userRepository.findById(id);
		
		if(optionalUser.isPresent()){
			User user = modelMapper.map(request, User.class);
			user.setIdUser(id);
			userRepository.save(user);
			return new ModelAndView("redirect:/home/".concat(Integer.toString(user.getIdUser())));
		}
		
		return new ModelAndView("redirect:/home");
	}
	
}
