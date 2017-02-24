package com.pneizhmak.footapp.controller;

import com.pneizhmak.footapp.repository.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Pavel Neizhmak
 */
@RestController
public class PlayerController {

    private PlayerRepository repository;

    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/players")
    public Collection<Map<String, String>> goodBeers() {

        return repository.findAll().stream()
                .map(playerMapFunction -> {
                    Map<String, String> m = new HashMap<>();
                    m.put("id", playerMapFunction.getId().toString());
                    m.put("name", playerMapFunction.getName());
                    return m;
                }).collect(Collectors.toList());
    }
}