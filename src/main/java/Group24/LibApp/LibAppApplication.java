package Group24.LibApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LibAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibAppApplication.class, args);
	}

    @GetMapping("/")
    public String greet() {
        return "Hello";
    }

}
