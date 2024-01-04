package com.example.regsystem.Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainC {
    @GetMapping("/jst")
    public String Main01(){
        return "jst";
    }

    @GetMapping("/java1")
    public String Main02(){
        return "javasc";
    }

}
