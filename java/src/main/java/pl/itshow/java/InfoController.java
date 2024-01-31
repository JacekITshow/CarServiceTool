package pl.itshow.java;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itshow.java.DTO.CustomerDto;
import pl.itshow.java.repository.CustomerDao;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public class InfoController {

    @Autowired
    CustomerDao customerDao;

    @GetMapping("/info")
    String info() {
        List<CustomerDto> maleCustomers = customerDao.findCustomersByGender("Male");

        return "Current time is: " + new Date();
    }
}
