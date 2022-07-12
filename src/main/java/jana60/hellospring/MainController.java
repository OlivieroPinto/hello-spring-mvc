package jana60.hellospring;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/ora")
	public String orario(Model model) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Before : " + now);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTime = now.format(formatter);
		model.addAttribute("orario", formatDateTime);
		return "ora";
	}

}
