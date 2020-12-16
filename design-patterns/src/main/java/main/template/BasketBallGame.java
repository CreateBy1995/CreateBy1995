package main.template;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: dongcx
 * @Description: 此子类中对钩子方法做了拓展实现
 * @Date: 2020-12-16
 **/
@Slf4j
public class BasketBallGame extends AbstractGame {
    private final static String GAME_NAME = "BasketBall";

    @Override
    public void playGame(Player player, String gameName) {
        log.info("player {} is playing {} game",
                player.getPlayerName(), gameName);
    }

    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    /**
     * 对父类的钩子方法做拓展实现
     *
     * @param player
     */
    @Override
    public void preLogin(Player player) {
        player.setTicket(5);
    }
}
