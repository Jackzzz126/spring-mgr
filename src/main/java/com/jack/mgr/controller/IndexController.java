package com.jack.mgr.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class IndexController {
    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("name", "Jack");

        return "index";
    }

    @RequestMapping(value = "/test")
    public String test(Model model, Long id) {
        log.info("got {}", id);
        return "";
    }
}
