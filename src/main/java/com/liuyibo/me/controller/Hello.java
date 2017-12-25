package com.liuyibo.me.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Hello {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    public JSONObject hello(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "hello world! mother fucker...");
        return jsonObject;
    }

    @GetMapping("/jdbc")
    public JSONObject jdbcTest(){
        JSONObject jsonObject = new JSONObject();
        int count = jdbcTemplate.queryForObject("select count(*) from article", Integer.class);
        jsonObject.put("msg", "article count");
        jsonObject.put("value", count);
        List articles = jdbcTemplate.query("select title, author from article", (rs, rowNum) -> {
            Article article = new Article();
            article.setTitle(rs.getString("title"));
            article.setAuthor(rs.getString("author"));
            return article;
        });
        jsonObject.put("content", articles);
        return jsonObject;
    }

}
