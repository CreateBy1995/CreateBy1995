package main;

import main.template.AbstractGame;
import main.template.BasketBallGame;
import main.template.FootBallGame;
import main.template.Player;
import org.junit.Test;

/**
 * @Author: dongcx
 * @Description: 模板模式测试类， 一个模板定法可以由具体方法、抽象方法、钩子方法组成
 * 具体方法:一般都是各个子类可以共用的 (也就是可复用代码)
 * 抽象方法:各个子类都有不同的实现
 * 钩子方法:可以模板方法的基本框架上实现一些自定义的拓展
 * 模板方法在Spring中的应用
 * @see org.springframework.context.support.AbstractApplicationContext
 * 该类的refresh方法就是一个模板方法，也是由具体方法、抽象方法、钩子方法组成
 * @Date: 2020-12-16
 **/
public class TemplateTest {
    @Test
    public void test0001(){
        Player player = new Player("Hello", 0);
        AbstractGame abstractGame = new FootBallGame();
        abstractGame.play(player);
    }

    @Test
    public void test0002(){
        Player player = new Player("Hello", 0);
        AbstractGame abstractGame = new BasketBallGame();
        abstractGame.play(player);
    }
}
