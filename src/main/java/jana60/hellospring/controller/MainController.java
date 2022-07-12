package jana60.hellospring.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("/home")
	public String home(Model model) {
		Random rand = new Random();
		int n = rand.nextInt(5);
		String[] salutini = { "Ciao carissimi", "Hello dear", "Che la forza sia con te", "Saluto generico", "Ciá",
				"Ja mo basta ciao." };
		model.addAttribute("saluto", salutini[n]);
		return "home";
	}

	@GetMapping("/ora")
	public String orario(Model model) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		model.addAttribute("orario", now.format(formatter));
		return "ora";
	}

}
