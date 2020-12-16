package main.templete;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: dongcx
 * @Description: 顶级抽象类，定义了模板方法的框架，各个抽象方法交由子类去实现
 * 模板方法中的各个方法定义为protected，只暴露出一个模板方法
 * @Date: 2020-12-16
 **/
@Slf4j
public abstract class AbstractGame {
    /**
     * 具体方法，具体方法一般都是各个子类可以共用的
     * 例如login这个方法的含义表示只能通过一种方式登陆
     *
     * @param player
     * @return
     */
    protected Boolean login(Player player) {
        return player.getTicket() > 0;
    }

    /**
     * 钩子方法，在login方法前执行之前,可以对player对象进行修改
     *
     * @param player
     */
    protected void preLogin(Player player) {
    }

    /**
     * 具体方法，具体方法一般都是各个子类可以共用的
     * 例如login这个方法的含义表示只能通过一种方式登陆
     *
     * @param player
     * @return
     */
    protected void exit(Player player) {
        Integer ticket = player.getTicket();
        if (ticket <= 0) {
            log.error("exit failed");
            return;
        }
        player.setTicket(ticket - 1);
    }

    /**
     * 钩子方法，在exit方法前执行之前,可以对player对象进行修改
     *
     * @param player
     */
    protected void preExit(Player player) {
    }

    /**
     * 抽象方法 由子类实现 因为各个游戏的实现不同，所以定义为抽象方法
     *
     * @param player
     * @param gameName
     */
    protected abstract void playGame(Player player, String gameName);

    /**
     * 抽象方法 由子类实现  因为各个游戏名称不同，所以定义为抽象方法
     */
    protected abstract String getGameName();

    /**
     * 模板方法
     * 由具体方法、抽象方法、钩子方法组成
     *
     * @param player
     */
    public final void play(Player player) {
        // step1、钩子方法
        preLogin(player);
        // step2、具体方法
        if (!login(player)) {
            log.error("login failed! playerName:{}", player.getPlayerName());
            return;
        }
        // step3、抽象方法，由子类实现
        playGame(player, getGameName());
        // step4、钩子方法
        preExit(player);
        // step5、具体方法
        exit(player);
    }
}
