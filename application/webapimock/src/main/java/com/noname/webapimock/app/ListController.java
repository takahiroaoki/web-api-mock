package com.noname.webapimock.app;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.noname.webapimock.domain.model.constant.Path;
import com.noname.webapimock.domain.model.entity.Mock;
import com.noname.webapimock.domain.service.MockService;

@Controller
@RequestMapping(Path.LIST_BASE)
public class ListController {
    @Autowired
    MockService mockService;

    @RequestMapping(path = { "", "/" }, method = RequestMethod.GET)
    String indexAction(Model model) {
        // mock-list
        List<Mock> mockList = mockService.findAllMocks();
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
        for (Mock mock : mockList) {
            mock.setMockPath(baseUrl + Path.MOCK_BASE + mock.getMockPath());
        }
        model.addAttribute("mockList", mockList);

        // create-button
        model.addAttribute("newMock", new Mock());
        return "list/index";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    String createAction(@ModelAttribute Mock mock, UriComponentsBuilder builder) {

        mock.setMockPath("/" + mock.getMockPath());
        mockService.saveMock(mock);

        URI destination = builder.path(Path.LIST_BASE).build().toUri();
        return "redirect:" + destination.toString();
    }

}
