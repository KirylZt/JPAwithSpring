package by.tms.controller;

import by.tms.dao.UserDAO;
import by.tms.entity.Address;
import by.tms.entity.Role;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


public class UserController {

    @Autowired
    private UserDAO userDao;

    @GetMapping("/save")
    public String save(){
        User user = new User();
        userDao.save(user);
        return "test";
    }

    @GetMapping("/update")
    public String update(){
        User user = new User();
        userDao.update(user);
        return "test";
    }

    @GetMapping("/findAll")
    public String findAll(){
        List<User> all = userDao.findAll();
        System.out.println(all);
        return "test";
    }
}
