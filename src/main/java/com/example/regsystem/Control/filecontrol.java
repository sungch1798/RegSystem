package com.example.regsystem.Control;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class filecontrol {
    @GetMapping("/upload")
    public String upload1(){
        return "fupload";
    }
    @PostMapping("/upload")
    public String uploadres(Model model, @RequestPart("imgfile")MultipartFile mp) {
        //MultipartFile mp =((MultipartHttpServletRequest)request).getFile("imgfile");
        model.addAttribute("result","檔案存檔成功!!");
        model.addAttribute("size",mp.getSize());
        model.addAttribute("type",mp.getContentType());
        model.addAttribute("filename",mp.getOriginalFilename());

        try {
            mp.transferTo(Paths.get("c:/temp/"+mp.getOriginalFilename()));
            InputStream is =mp.getInputStream();
            System.out.println("檔案轉存成功!!");
        }
        catch (IOException e){
            System.err.println("寫入存檔失敗");
        }
        return "resupload";
    }

    @PostMapping("/upload2")
    public String uploadres2(Model model,HttpServletRequest request) {
        List<MultipartFile> mps =((MultipartHttpServletRequest)request).getFiles("imgfiles");
        model.addAttribute("count",mps.size());
        for (MultipartFile mp:mps)

        try {
            mp.transferTo(Paths.get("c:/temp/"+mp.getOriginalFilename()));
            InputStream is =mp.getInputStream();
            System.out.println("檔案轉存成功!!");
        }
        catch (IOException e){
            System.err.println("寫入存檔失敗");
        }
        return "resupload2";
    }

}
