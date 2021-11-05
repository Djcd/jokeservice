package test.springboot.demo.model;

import org.springframework.util.DigestUtils;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.util.Locale;

@Entity
@Table(name = "JOKES")
public class Joke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="JOKETEXT", nullable=false)
    private String joke;

    @Column(name="ADDED")
    private LocalDate date;

    public Joke() {
        this.date = LocalDate.now();
    }

    public Joke(Long id, String joke) {
        this.id = id;
        this.joke = joke;
        this.date = LocalDate.now();
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
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
