package pl.itshow.java;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/info/")
    String info() {
        return "info";
    }
}
