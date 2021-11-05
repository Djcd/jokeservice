package test.springboot.demo.model;

import org.springframework.util.DigestUtils;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Locale;

@Entity
public class Joke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String joke;

    @Column(unique=true)
    private String hash;

    public Joke() {
    }

    public Joke(Long id, String joke) {
        this.id = id;
        this.joke = joke;
        this.hash = DigestUtils.md5DigestAsHex(this.joke.toLowerCase().getBytes(StandardCharsets.UTF_8));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
        this.hash = DigestUtils.md5DigestAsHex(this.joke.toLowerCase().getBytes(StandardCharsets.UTF_8));
    }

    public String getHash() {
        return hash;
    }
}
