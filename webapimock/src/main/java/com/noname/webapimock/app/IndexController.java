package com.noname.webapimock.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    String index(Model model) {
        model.addAttribute("greeting", "Hello, world!");
        return "index";
    }
}
