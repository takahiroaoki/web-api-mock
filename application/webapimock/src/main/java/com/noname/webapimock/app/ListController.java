package com.noname.webapimock.app;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.noname.webapimock.domain.model.constant.Path;
import com.noname.webapimock.domain.model.entity.Mock;
import com.noname.webapimock.domain.model.form.MockForm;
import com.noname.webapimock.domain.service.MockService;

@Controller
@RequestMapping(Path.LIST_BASE)
public class ListController {
    @Autowired
    MockService mockService;

    ListController(MockService mockService) {
        this.mockService = mockService;
    }

    @RequestMapping(path = { "", "/" }, method = RequestMethod.GET)
    String indexAction(Model model) {
        // mock-list
        List<Mock> mockList = mockService.findAllMocks();
        String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
        for (Mock mock : mockList) {
            mock.setMockPath(baseUrl + Path.MOCK_BASE + mock.getMockPath());
        }
        model.addAttribute("mockList", mockList);

        // create-form
        model.addAttribute("mockForm", new MockForm());
        return "list/index";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    String createAction(@Validated MockForm mockForm, BindingResult bindingResult, UriComponentsBuilder builder) {

        if (!bindingResult.hasErrors()) {
            Mock newMock = new Mock()
                    .setMockPath("/" + mockForm.getMockPath())
                    .setMockName(mockForm.getMockName())
                    .setStatusCode(mockForm.getStatusCode())
                    .setContentType(mockForm.getContentType())
                    .setResponseBody(mockForm.getResponseBody());

            mockService.saveMock(newMock);
        }

        URI destination = builder.path(Path.LIST_BASE).build().toUri();
        return "redirect:" + destination.toString();
    }

}
