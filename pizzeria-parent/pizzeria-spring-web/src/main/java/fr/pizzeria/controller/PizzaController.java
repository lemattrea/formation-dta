package fr.pizzeria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String bonjour() {
		return "vuebonjour";
	}
}
