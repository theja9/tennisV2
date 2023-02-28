package com.spring.tennisV2.service;

import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    public String getScore(int playerOneScore, int playerTwoScore) {
        return String.format("%s %s", translateScore(playerOneScore), translateScore(playerTwoScore));
    }

    public String translateScore(int score) {
        if(score == 0)
            return "Love";
        if(score == 1)
            return "Fifteen";
        if(score == 2)
            return "Thirty";
        return null;
    }
}
