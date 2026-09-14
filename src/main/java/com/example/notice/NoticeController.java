package com.example.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    // 롬복(@RequiredArgsConstructor) 대신 직접 생성자를 만들어 줍니다!
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/list")
    public String noticeList(Model model) {
        List<NoticeEntity> noticeList = noticeService.findAll();
        model.addAttribute("noticeList", noticeList);
        return "notice/list";
    }

    @GetMapping("/detail/{id}")
    public String noticeDetail(@PathVariable Long id, Model model) {
        NoticeEntity notice = noticeService.findById(id);
        model.addAttribute("notice", notice);
        return "notice/detail";
    }
    @PostMapping("/write")
    public String noticeWrite(NoticeEntity notice) {
        noticeService.save(notice);
        return "redirect:/notice/list";
    }
    @GetMapping("/write")
    public String writeForm() {
        return "notice/write";
    }
    @PostMapping("/delete/{id}")
    public String noticeDelete(@PathVariable Long id) {
        noticeService.delete(id);
        return "redirect:/notice/list";
    }
    @PostMapping("/update/{id}")
    public String noticeUpdate(@PathVariable Long id, NoticeEntity notice) {
        noticeService.update(id, notice);
        return "redirect:/notice/detail"+id;
    }
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id")Long id, Model model) {
        NoticeEntity notice = noticeService.findById(id);
        model.addAttribute("notice", notice);
        return "notice/edit";
    }
    
    @PostMapping("/edit/{id}")
    public String editNotice(@PathVariable("id") Long id, NoticeEntity notice) {
        notice.setId(id);
        noticeService.save(notice);
        return "redirect:/notice/detail/" + id;
    }

}
