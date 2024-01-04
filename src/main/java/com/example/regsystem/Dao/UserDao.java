package com.example.regsystem.Dao;

import com.example.regsystem.Model.members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbct;
    public int saveuser(members usermod){
    String sql="INSERT INTO member (username,password,mname,email,phone,mcity,pno,adds) values (?,?,?,?,?,?,?,?)";

    return  jdbct.update(sql,usermod.getUsername(),usermod.getSex(),usermod.getPassword(),usermod.getMname()
            ,usermod.getEmail(),usermod.getPhone(),usermod,
            usermod.getPno(),usermod.getAdds());

    }
    public Long userExis(String username){
        String sql1="SELECT COUNT(*) FROM member where username=?";
        return jdbct.queryForObject(sql1,Long.class, username);
    }

    public long loginid(String username){
        String sql2="SELECT COUNT(*) from member where username=?";
        return jdbct.queryForObject(sql2,Long.class, username);
    }
    public long loginpw(String password){
        String sql3="SELECT COUNT(*) from member where password=?";
        return jdbct.queryForObject(sql3,Long.class, password);
    }
}
