package test.springboot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.springboot.demo.dto.JokeData;
import test.springboot.demo.model.Joke;
import test.springboot.demo.repository.JokeRepository;
import test.springboot.demo.service.interfaces.JokeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service("JokeService")
public class DefaultJokeService implements JokeService {

    @Autowired
    private JokeRepository JokeRepository;

    @Override
    public JokeData saveJoke(JokeData Joke) {
        Joke joke = populateJokeEntity(Joke);
        return populateJokeData(JokeRepository.save(joke));
    }

    @Override
    public boolean deleteJoke(Long JokeId) {
        JokeRepository.deleteById(JokeId);
        return true;
    }

    @Override
    public JokeData updateJoke(JokeData Joke) {
        Joke joke = populateJokeEntity(Joke);
        return populateJokeData(JokeRepository.save(joke));
    }

    @Override
    public List<JokeData> getAllJokes() {
        List<JokeData> Jokes = new ArrayList<>();
        List<Joke> JokeList = JokeRepository.findAll();
        JokeList.forEach(Joke -> {
            Jokes.add(populateJokeData(Joke));
        });
        return Jokes;
    }

    @Override
    public JokeData getJokeById(Long JokeId) {
        Joke joke = JokeRepository.findById(JokeId).orElse(null);
        if(joke == null)
            return null;
        else
            return populateJokeData(joke);
    }

    @Override
    public JokeData getRandomJoke() {
        List<Joke> jokes = JokeRepository.findAll();
        if(jokes.size() == 0)
            return null;
        Random rand = new Random();
        return populateJokeData(jokes.get(rand.nextInt(jokes.size())));
    }

    private JokeData populateJokeData(final Joke Joke){
        JokeData JokeData = new JokeData(Joke.getId(), Joke.getJoke());
        return JokeData;
    }

    private Joke populateJokeEntity(JokeData JokeData){
        Joke Joke = new Joke(JokeData.getId(), JokeData.getJoke());
        return Joke;
    }
}
