package com.ucrev.foodchow;

import com.ucrev.foodchow.service.FoodChowService;
import com.ucrev.foodchow.service.FoodChowServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
        FoodChowService service = new FoodChowServiceImpl();
        service.getRestaurents();
		return "hello";
	}
}