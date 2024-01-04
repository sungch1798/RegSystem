package com.example.regsystem.Control;

import com.example.regsystem.Model.members;
import com.example.regsystem.Service.RegSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class memberC {
    @Autowired
    RegSer regser;
    @GetMapping("/reg")
    public String regsys(Model model){
        members mems= new members();
       model.addAttribute("usermod",mems);
        return "reg";
    }
    @PostMapping("/reg")
    public String regsys2(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String email,
                          @RequestParam String phone,
                          Model model){
        model.addAttribute("user",username);
        return "regok";
    }

    @PostMapping("/reg2")
    public String regsys3(@ModelAttribute members usermod
                          ,Model model){
        String msg=null;
       int res=regser.regser01(usermod);
       switch (res)
       {
           case 0:
               msg="新增失敗";
               break;
           case 1:
               msg="帳號成功註冊!";
               break;
           case 2:
               msg="帳號已經存在，請使用登入";
               break;
           case 3:
               msg="帳號含有非法字元";
               break;
           default:
               msg="其他原因，請洽管理員";
               break;



       }


        model.addAttribute("user",usermod.getUsername());
        model.addAttribute("password",usermod.getPassword());
        model.addAttribute("mname",usermod.getMname());
        model.addAttribute("sex",usermod.getSex());
        model.addAttribute("email",usermod.getEmail());
        model.addAttribute("phone",usermod.getPhone());

        model.addAttribute("pno",usermod.getPno());
        model.addAttribute("adds",usermod.getAdds());
        model.addAttribute("mesg", msg);

        return "regok";
    }
    @GetMapping ("/login")
    public String login (Model model){
        members mems= new members();
        model.addAttribute("usermod",mems);
        return "login";
    }
}
