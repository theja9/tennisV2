package com.spring.tennisV2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tennis")
public class TennisController {
    private int playerOneScore;

    @GetMapping("/updateScore")
    public int updateScore(@RequestParam String scorer) {
        if (scorer.equalsIgnoreCase("playerOne"))
             ++playerOneScore;
        return playerOneScore;
    }
}
