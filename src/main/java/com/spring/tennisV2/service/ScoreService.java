package com.spring.tennisV2.service;

import com.spring.tennisV2.exception.IllegalScorerException;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    public String getScore(int playerOneScore, int playerTwoScore) {
        return String.format("%s %s", translateScore(playerOneScore), translateScore(playerTwoScore));
    }

    public String translateScore(int score) {
        switch (score) {
            case THREE:
                return FORTY;
            case TWO:
                return THIRTY;
            case ONE:
                return FIFTEEN;
            case ZERO:
                return LOVE;
        }
        throw new IllegalScorerException("Illegal score:"+ score);
    }
}
