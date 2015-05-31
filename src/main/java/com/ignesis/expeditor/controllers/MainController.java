package com.ignesis.expeditor.controllers;

import com.ignesis.expeditor.beans.SimpleBean;
import com.ignesis.expeditor.dto.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Kardi on 30.05.2015.
 */

@Controller
@RequestMapping("/*")
public class MainController {

    @Autowired
    SimpleBean simpleBean;

    @RequestMapping("index/*/{path}")
    public ModelAndView index(@PathVariable String path) {
        ModelAndView view = new ModelAndView("index");
        view.addObject("pathVariable", path);
        return view;
    }


    @RequestMapping(value = "hello", method = RequestMethod.GET, produces = "text/html")
    @ResponseBody
    public String getHelloPage() {
        return "<html><body>MainController.hello response<br>"+simpleBean+"</body></html>";
    }

    @RequestMapping(value = "calculate", method = RequestMethod.GET, produces = "text/html")
    @ResponseBody
    public String getCalculatePage(@RequestBody Param param) {
        return "<html><body>MainController.calculate response" + (param.a * param.b) +"</body></html>";
    }
}
