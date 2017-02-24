package com.pneizhmak.footapp;

import com.pneizhmak.footapp.model.Player;
import com.pneizhmak.footapp.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class PlayerCommandLineRunner implements CommandLineRunner {

    private final PlayerRepository repository;

    public PlayerCommandLineRunner(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of("Player_1", "Player_2", "Player_3", "Player_4", "Player_5")
                .forEach(name -> repository.save(new Player(name)));
        System.out.println(repository.findAll());
    }
}