package com.example.regsystem.Service;

import com.example.regsystem.Dao.UserDao;
import com.example.regsystem.Model.members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegSer {
    @Autowired
    UserDao udao;
    public int regser01(members usermod){
        if(usermod.getUsername().contains("select") || usermod.getUsername().contains("delete"))
        {
            return 3;
        }
        if(userExis(usermod.getUsername()))
        {
            return 2;
        }
    int cno = udao.saveuser(usermod);
        if (cno > 0)
        {
            return 1;

        }else {
            return cno;
        }

    }
    public boolean userExis(String username){
        Long count =udao.userExis(username);
        if(count > 0) {
            return true;
        } else {
        return false;
        }
    }

}
