package com.example.regsystem.Control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PControl {
    @GetMapping("/p/{type}/{pid}")
    public String prodt101(@PathVariable String pid, @PathVariable String type , Model model){
        model.addAttribute("pid",pid);
        model.addAttribute("type",type);
       return "prodt";

    }
}
