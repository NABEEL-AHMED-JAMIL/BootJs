package com.admaxim.BootJs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class AppController implements IAppController {


    @RequestMapping(value = "/")
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("title", "BootJs!");
        modelMap.addAttribute("menus", menu);
        return "index";
    }

}
