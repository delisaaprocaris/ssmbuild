package com.bao.controller;

import com.bao.pojo.Books;
import com.bao.service.BookService;
import com.bao.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    //controller层调用service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService = new BookServiceImpl();

    //查询全部的书书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allbook";
    }

}
