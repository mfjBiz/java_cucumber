package practice.e2e.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlogController {

    @RequestMapping(path = "/blogs", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String index() {
        return "<h1 id='blogs'>blogs</h1>";
    }

}