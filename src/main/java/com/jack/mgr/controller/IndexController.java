package com.jack.mgr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IndexController
 *
 * @author zhengzhe17
 * @date 2021/4/7
 */
@Controller
public class IndexController {
    @RequestMapping(value = {"/", "/index", "/index.html"})
    public String index(Model model) {
        model.addAttribute("name", "Jack");
        return "index";
    }
}
