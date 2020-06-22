package br.ufpb.dcx.firstApp.firstAppSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class FirstAppSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstAppSpringApplication.class, args);
	}

	@GetMapping("/")
	@ResponseBody
	String index(){
		return "This is application used for study";
	}

}
