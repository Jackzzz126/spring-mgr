package com.jack.mgr.controller;

import com.jack.mgr.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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

    @RequestMapping(value = "/postTest",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String postTest(@RequestParam Map<String, Object> parmas) {
        log.info("post test got {}", JsonUtils.toJson(parmas));
        return "";
    }
}
