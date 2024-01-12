package hutech.trancongmanh.quanlyduanxaydung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @GetMapping
    public String home() {
        return "layout/mainpages/index";
    }

    @GetMapping(value = "home")
    public String contact() {
        return "home/CreateDuAn";
    }


}
