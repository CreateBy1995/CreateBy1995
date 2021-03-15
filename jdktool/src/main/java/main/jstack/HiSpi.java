package main.jstack;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2021-02-03
 **/
public class HiSpi implements CustomSpi {
    @Override
    public void doSomething() {
        System.out.println("hi");
    }
}
