package main;

import main.builder.Request;
import org.junit.Test;

/**
 * @Author: dongcx
 * @Description: 建造者模式用于将复杂的构建过程隐藏起来，
 * 当一个类的构造函数参数个数有多个，而且这些参数有些是可选的参数，考虑使用建造者模式。
 * 例如在Request对象中，创建对象时一般只考虑url和请求方式，timeout和retry属性都是可忽略的
 * 那么此时就可以使用建造者模式，可以参考Spring中使用的建造者模式
 * @see org.springframework.web.util.UriComponentsBuilder
 * @see org.springframework.beans.factory.support.BeanDefinitionBuilder
 * @Date: 2020-12-14
 **/
public class BuilderTest {
    @Test
    public void test0001() {
        Request request = Request.RequestBuilder.postBuilder()
                .host("localhost").port(8080).path("web").build();
        System.out.println(request);
    }
}
