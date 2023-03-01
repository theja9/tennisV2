package com.spring.tennisV2.service;

import com.spring.tennisV2.exception.IllegalScorerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    @Autowired
    private PlayerService players;

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
    private static final String DEUCE = "Deuce";
    private static final String PLAYER_ONE = "PlayerOne";
    private static final String PLAYER_TWO = "PlayerTwo";
    private static final String ADVANTAGE = "Advantage";
    private static final String WINS = "Wins";

    public String getScore(int playerOneScore, int playerTwoScore) {
        if (Math.max(playerOneScore, playerTwoScore) > THREE) {
            if (isPointDifferenceOne(playerOneScore, playerTwoScore))
                return getHighestScorer(playerOneScore, playerTwoScore) + SPACE + ADVANTAGE;
            else {
                quitGame();
                return getHighestScorer(playerOneScore, playerTwoScore) + SPACE + WINS;
            }
        }
        if (playerOneScore > TWO && playerOneScore == playerTwoScore) {
            return DEUCE;
        }
        if (playerOneScore == playerTwoScore)
            return translateScore(playerOneScore) + SPACE + ALL;
        return String.format("%s %s", translateScore(playerOneScore), translateScore(playerTwoScore));
    }

    public void quitGame() {
        players.setPlayerOnePoints(0);
        players.setPlayerTwoPoints(0);
    }

    private boolean isPointDifferenceOne(int playerOneScore, int playerTwoScore) {
        return Math.abs(playerOneScore - playerTwoScore) == ONE;
    }

    private String getHighestScorer(int playerOneScore, int playerTwoScore) {
        return playerOneScore > playerTwoScore ? PLAYER_ONE : PLAYER_TWO;
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
        throw new IllegalScorerException("Illegal score:" + score);
    }
}
