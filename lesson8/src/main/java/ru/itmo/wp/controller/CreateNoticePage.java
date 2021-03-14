package ru.itmo.wp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmo.wp.domain.Notice;
import ru.itmo.wp.service.NoticeService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CreateNoticePage extends Page {
    private final NoticeService noticeService;

    @Autowired
    public CreateNoticePage(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @PostMapping("/create")
    public String newNotice(@Valid @ModelAttribute("notice") Notice notice,
                            BindingResult bindingResult,
                            HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "CreateNoticePage";
        }
        if (getUser(session) == null) {
            putMessage(session, "Access denied");
            return "redirect:";
        }
        noticeService.addNotice(notice);
        putMessage(session, "Notice added successfully");
        return "redirect:";
    }

    @GetMapping("/create")
    public String addNoticePage(Model model) {
        model.addAttribute("notice", new Notice());
        return "CreateNoticePage";
    }
}
