package test.springboot.demo.dto;

public class JokeData {
    private final Long id;
    private final String joke;

    public JokeData(Long id, String joke) {
        this.id = id;
        this.joke = joke;
    }

    public Long getId() {
        return id;
    }

    public String getJoke() {
        return joke;
    }
}
