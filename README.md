# tennisV2

## Tennis game rules:
1. A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
2. The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as “love”, “15”, “30”, and “40” respectively.
3. If at least three points have been scored by each player, and the scores are equal, the score is “deuce”.
4. If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is “advantage” for the player in the lead.

## Prerequisites
- Java 11
- Spring Boot 2.4.2
- Maven

## Steps to build the application
- Clone this repository 
- Build the project and run the tests by running ```maven clean build``` and ```maven clean test```

## Steps to run the application
- By default, the application will start on port 8080. To run on different port ex: 8081, add ```server.port=8082``` in properties file, while starting the application
- Once successfully built, run the service by using one of below commands:
```
  java -jar build/libs/fizzBuzzV2.jar
                    or                  
  java -jar build/libs/fizzBuzzV2.jar --server.port=8081
```
- Hit ```http://localhost:8080/tennis/updateScore?pointsTo=playerOne``` url to increment the point by 1 for Player one
- Hit ```http://localhost:8080/tennis/updateScore?pointsTo=playerTwo``` url to increment the point by 1 for Player two
- Hit ```http://localhost:8080/tennis/getScore``` url to get the tennis score 

## sample tennis score :
| Player one points |Player two points|	Output |
| ------------------|:---------------:| ------:|
|  0                |   0             |Love All
|           1	    |   1            |Fifteen All
| 2	                |  2             |Thirty All
| 3	                |   3            |Deuce
| 3	                |  4             |PlayerTwo Advantage
| 4	                |  3             |PlayerOne Advantage
| 4	                |   6            |PlayerTwo Wins
| 6	                |   4            |PlayerOne Wins
| 0	                |1                |Love Fifteen
| 0	                |2                |Love Thirty |


