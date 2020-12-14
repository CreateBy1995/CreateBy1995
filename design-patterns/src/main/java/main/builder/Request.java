package main.builder;

import lombok.Getter;
import lombok.ToString;

/**
 * @Author: dongcx
 * @Description: 表示一个请求对象
 * @Date: 2020-12-12
 **/
@Getter
@ToString
public class Request {
    private Request(RequestBuilder requestBuilder) {
        this.host = requestBuilder.host;
        this.port = requestBuilder.port;
        this.path = requestBuilder.path;
        this.methodType = requestBuilder.methodType;
        this.timeout = requestBuilder.timeout;
        this.retry = requestBuilder.retry;
    }

    private Integer retry;
    private Integer timeout;
    private String host;
    private Integer port;
    private String path;
    private MethodType methodType;

    public static class RequestBuilder {
        private Integer timeout;
        private String host;
        private Integer port;
        private String path;
        private MethodType methodType;
        private Integer retry;

        private RequestBuilder() {

        }

        public static RequestBuilder builder() {
            RequestBuilder requestBuilder = new RequestBuilder();
            requestBuilder.timeout(3000);
            requestBuilder.retry(3);
            return requestBuilder;
        }

        public static RequestBuilder postBuilder() {
            RequestBuilder requestBuilder = builder();
            requestBuilder.methodType(MethodType.POST);
            return requestBuilder;
        }

        public static RequestBuilder getBuilder() {
            RequestBuilder requestBuilder = builder();
            requestBuilder.methodType(MethodType.GET);
            return new RequestBuilder();
        }

        public RequestBuilder port(Integer port) {
            this.port = port;
            return this;
        }

        public RequestBuilder methodType(MethodType methodType) {
            this.methodType = methodType;
            return this;
        }

        public RequestBuilder host(String host) {
            this.host = host;
            return this;
        }

        public RequestBuilder path(String path) {
            this.path = path;
            return this;
        }

        public RequestBuilder timeout(Integer timeout) {
            this.timeout = timeout;
            return this;
        }

        public RequestBuilder retry(Integer retry) {
            this.retry = retry;
            return this;
        }

        public Request build() {
            return new Request(this);
        }


    }
}
