package test.springboot.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import test.springboot.demo.dto.JokeData;
import test.springboot.demo.service.DefaultJokeService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/joke")
public class JokeController {

    @Resource(name = "JokeService")
    private DefaultJokeService JokeService;

    @GetMapping
    public List<JokeData> getJokes() {
        return JokeService.getAllJokes();
    }

    @GetMapping("/{id}")
    public JokeData getJoke(@PathVariable Long id){
        JokeData joke = JokeService.getJokeById(id);
        if(joke == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return joke;
    }

    @GetMapping("/random")
    public JokeData getRandomJoke(){
        JokeData joke = JokeService.getRandomJoke();
        if(joke == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return joke;
    }

    @PostMapping
    public JokeData saveJoke(final @RequestBody JokeData JokeData) {
        if(JokeData.getJoke() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return JokeService.saveJoke(JokeData);
    }

    @PutMapping
    public JokeData updateJoke(final @RequestBody JokeData JokeData) {
        if(JokeData.getId() == null || JokeData.getJoke() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return JokeService.updateJoke(JokeData);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteJoke(@PathVariable Long id) {
        return JokeService.deleteJoke(id);
    }
}
