package com.spring.tennisV2.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class PlayerService {
    private int playerOnePoints;
    private int playerTwoPoints;

    public void playerOneScores() {
        playerOnePoints++;
    }

    public void playerTwoScores() {
        playerTwoPoints++;
    }

}
