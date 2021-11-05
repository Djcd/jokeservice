package test.springboot.demo.service.interfaces;

import test.springboot.demo.dto.JokeData;

import java.util.List;

public interface JokeService {
    JokeData saveJoke(JokeData Joke);
    boolean deleteJoke(final Long JokeId);
    JokeData updateJoke(JokeData Joke);
    List<JokeData> getAllJokes();
    JokeData getJokeById(final Long JokeId);
    JokeData getRandomJoke();
}
