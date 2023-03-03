package com.spring.tennisV2.service;

import com.spring.tennisV2.exception.IllegalScorerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.spring.tennisV2.config.ScoreConstant.*;

@Service
public class ScoreService {

    @Autowired
    private PlayerService players;

    public String getScore(int playerOneScore, int playerTwoScore) {
        if (isScoreEqual(playerOneScore, playerTwoScore))
            return playerOneScore > TWO ? DEUCE : translateScore(playerOneScore) + SPACE + ALL;
        if (isAdvantage(playerOneScore, playerTwoScore))
            return getHighestScorer(playerOneScore, playerTwoScore) + SPACE + ADVANTAGE;
        if (isWin(playerOneScore, playerTwoScore)) {
            quitGame();
            return getHighestScorer(playerOneScore, playerTwoScore) + SPACE + WINS;
        }
        return getTranslatedScore(playerOneScore, playerTwoScore);
    }

    public void quitGame() {
        players.setPlayerOnePoints(0);
        players.setPlayerTwoPoints(0);
    }

    private boolean isPointDifferenceOne(int playerOneScore, int playerTwoScore) {
        return Math.abs(playerOneScore - playerTwoScore) == ONE;
    }

    private boolean isPointDiffGteTwo(int playerOneScore, int playerTwoScore) {
        return Math.abs(playerOneScore - playerTwoScore) >= TWO;
    }

    private boolean isAdvantage(int playerOneScore, int playerTwoScore) {
        return isScoreGreaterThanThree(playerOneScore, playerTwoScore) && isPointDifferenceOne(playerOneScore, playerTwoScore);
    }

    private boolean isWin(int playerOneScore, int playerTwoScore) {
        return isScoreGreaterThanThree(playerOneScore, playerTwoScore) && isPointDiffGteTwo(playerOneScore, playerTwoScore);
    }

    private String getHighestScorer(int playerOneScore, int playerTwoScore) {
        return playerOneScore > playerTwoScore ? PLAYER_ONE : PLAYER_TWO;
    }

    private boolean isScoreEqual(int playerOneScore, int playerTwoScore) {
        return playerOneScore == playerTwoScore;
    }

    private boolean isScoreGreaterThanThree(int playerOneScore, int playerTwoScore) {
        return Math.max(playerOneScore, playerTwoScore) > THREE;
    }

    private String getTranslatedScore(int playerOneScore, int playerTwoScore) {
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
        throw new IllegalScorerException("Illegal score:" + score);
    }
}
