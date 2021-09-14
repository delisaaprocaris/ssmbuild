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

    //跳转到添加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPage(){
        return "addbook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        //重定向到“@RequestMapping("/allBook")”请求
        return "redirect:/book/allBook";
    }

    //跳转到修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdatePage(int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("books",books);
        return "updatebook";
    }

    //修改书籍的请求
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    //删除书籍的请求
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

}
