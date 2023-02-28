package com.spring.tennisV2.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class PlayerService {
    private int playerOnePoints;

    public void playerOneScores() {
        playerOnePoints++;
    }

}
