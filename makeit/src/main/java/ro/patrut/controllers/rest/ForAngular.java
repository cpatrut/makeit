package ro.patrut.controllers.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.patrut.models.user.UserModel;

@RestController
public class ForAngular {

	
	@RequestMapping("/haha")
	public UserModel getSomething() {
		UserModel userModel = new UserModel();
		userModel.setEmail("cpatrut@optaros.com");
		userModel.setFirstName("Catalin");
		userModel.setLastName("Patrut");
		userModel.setPassword("go fuck yourself!");
		userModel.setState("US");
		return userModel;
	}
}
