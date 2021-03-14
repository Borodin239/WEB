package ru.itmo.wp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmo.wp.domain.User;
import ru.itmo.wp.form.ChangeStatusRequest;
import ru.itmo.wp.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UsersPage extends Page {
    private final UserService userService;

    public UsersPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/all")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "UsersPage";
    }

    @PostMapping("/changeStatus")
    public String changeStatus(@Valid @ModelAttribute("changeStatusRequest") ChangeStatusRequest changeStatusRequest,
                             Model model,
                             HttpSession session) {
        User user = getUser(session);
        if (user == null || user.getDisabled()) {
            putMessage(session, "Access denied");
            return "redirect:";
        }
        if (user.getId() == changeStatusRequest.getId()) {
            putMessage(session, "You can't make your account disabled");
            return "redirect:";
        }
        userService.updateStatus(changeStatusRequest.getId(), changeStatusRequest.getDisabled());
        model.addAttribute("users", userService.findAll());
        return "redirect:/users/all";
    }
}
