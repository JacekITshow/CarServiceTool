package pl.itshow.java;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/test")
public class InfoController {

    @GetMapping("/info")
    String info() {
        return "Current time is: " + new Date();
    }
}
