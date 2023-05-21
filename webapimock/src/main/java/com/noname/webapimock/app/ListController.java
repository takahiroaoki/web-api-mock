package com.noname.webapimock.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.noname.webapimock.domain.model.constant.Path;
import com.noname.webapimock.domain.model.entity.Mock;
import com.noname.webapimock.domain.service.MockService;

@Controller
@RequestMapping(Path.LIST_BASE)
public class ListController {
    @Autowired
    MockService mockService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    String listAction(Model model) {
        List<Mock> mockList = mockService.findAllMocks();
        model.addAttribute("mockList", mockList);
        return "list";
    }

}
