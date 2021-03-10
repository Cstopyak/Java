package com.colbystopyak.human.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
	@RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String searchQuery) {
		if(searchQuery != null) {
			return "Hello " + searchQuery;
		} else {
        return "Hello human!: ";
		}
    }
	@RequestMapping("/hello")
	public String Hello() {
		return "Hello World";
	}
}
	