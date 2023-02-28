package com.spring.tennisV2.controller;

import com.spring.tennisV2.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tennis")
public class TennisController {

    @Autowired
    private PlayerService players;

    @GetMapping("/updateScore")
    public void updateScore(@RequestParam String scorer) {
        if (scorer.equalsIgnoreCase("playerOne"))
            players.playerOneScores();
        if (scorer.equalsIgnoreCase("playerTwo")) {
            players.playerTwoScores();
        }
    }
}