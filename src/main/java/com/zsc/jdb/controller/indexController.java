package com.zsc.jdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Duanran 2019/3/12 0012
 */
@Controller
public class indexController {

  @RequestMapping("/")
  @ResponseBody
  public String index() {
    return "hello";
  }

  @RequestMapping("/test")
  @ResponseBody
  public String test() {
    return "this is another method";
  }
}
