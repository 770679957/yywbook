package com.yyw.book.controller;

import com.yyw.book.entity.User;
import com.yyw.book.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "book")
public class BookController {

    @Autowired
    public UserMapper userMapper;

    //http://127.0.0.1:8080/book/getUserList
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> userList = userMapper.selectList(null);
        return  userList;
    }


}
