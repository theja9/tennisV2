package com.spring.tennisV2.service;

import com.spring.tennisV2.exception.IllegalScorerException;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";
    private static final String ALL = "All";
    private static final String SPACE = " ";

    public String getScore(int playerOneScore, int playerTwoScore) {
        if(playerOneScore == playerTwoScore)
            return translateScore(playerOneScore) + SPACE + ALL;
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
