package main.templete;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: dongcx
 * @Description: 此子类中不对钩子方法做实现，默认使用父类中的空实现
 * @Date: 2020-12-16
 **/
@Slf4j
public class FootBallGame extends AbstractGame {
    private final static String GAME_NAME = "FootBall";

    @Override
    public void playGame(Player player, String gameName) {
        log.info("player {} is playing {} game",
                player.getPlayerName(), gameName);
    }

    @Override
    public String getGameName() {
        return GAME_NAME;
    }
}
