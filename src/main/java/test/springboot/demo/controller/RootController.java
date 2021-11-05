package test.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import test.springboot.demo.service.DefaultJokeService;

import javax.annotation.Resource;

@Controller
public class RootController {

    @Resource(name = "JokeService")
    private DefaultJokeService JokeService;

    @GetMapping("/")
    public String rootIndex(Model model) {
        model.addAttribute("Jokes", JokeService.getAllJokes());
        return "root";
    }
}
