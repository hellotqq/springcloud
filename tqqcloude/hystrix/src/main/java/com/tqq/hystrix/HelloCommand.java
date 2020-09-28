package com.tqq.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * @author ： tqq
 * @date ： 2020/9/27 16:01
 * @Description:
 */
public class HelloCommand extends HystrixCommand<String> {
    RestTemplate restTemplate;

    protected HelloCommand(Setter setter,RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }


    @Override
    protected String run() throws Exception {
        int i = 1/0;
        return restTemplate.getForObject("http://provider/hello",String.class);
    }

    @Override
    protected String getFallback() {
        return "error-extends"+getExecutionException().getMessage();
    }
}
