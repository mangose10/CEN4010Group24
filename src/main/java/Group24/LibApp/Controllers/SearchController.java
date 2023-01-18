package Group24.LibApp.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SearchController {

    @GetMapping("/search")
    public String test(){
        return "test successful";
    }

}
