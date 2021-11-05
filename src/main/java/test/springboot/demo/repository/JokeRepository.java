package test.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.springboot.demo.model.Joke;

@Repository
public interface JokeRepository extends JpaRepository<Joke,Long> { }
