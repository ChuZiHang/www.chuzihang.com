package com.chuzihang.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.chuzihang.model.UserInfo;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/7/10 16:46
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    /**********    HTTP GET method   **************/

    @GetMapping("/get")
    public String get() {
        String url = "http://localhost:8080/test/getApi";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        String body = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();
        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpHeaders headers = responseEntity.getHeaders();
        StringBuilder result = new StringBuilder();
        result.append("responseEntity.getBody()：").append(body).append("<hr>")
                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
        return result.toString();
    }

    @GetMapping("/get1")
    public String get1() {
        String param = "测试啊真的";
        String url = "http://localhost:8080/test/getApi1?param={1}";
        JSONObject json = restTemplate.getForEntity(url, JSONObject.class, param).getBody();
        return json.toJSONString();
    }

    @GetMapping("/get2")
    public String get2() {
        String param = "测试啊真的";
        JSONObject getData = new JSONObject();
        getData.put("param", param);
        String url = "http://localhost:8080/test/getApi1?param={param}";
        JSONObject json = restTemplate.getForEntity(url, JSONObject.class, getData).getBody();
        return json.toJSONString();
    }

    @GetMapping("/get3")
    public String get3() {
        UriComponents uriComponents =
                UriComponentsBuilder.fromUriString("http://localhost:8080/test/getApi1?param={name}")
                        .build()
                        .expand("测试啊真的")
                        .encode();
        URI uri = uriComponents.toUri();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        return responseEntity.getBody();
    }

    @GetMapping("/getApi")
    public Object getApi() {
        JSONObject json = new JSONObject();
        json.put("descp", "this is spring rest template sample");
        return json;
    }

    @GetMapping("/getApi1")
    public Object genJson(@RequestParam String param) {
        logger.info("==========================" + param);
        JSONObject json = new JSONObject();
        json.put("descp", "this is spring rest template sample");
        return json;
    }

    /**********    HTTP POST method   **************/

    /**
     * @Author Q_先生
     * 第一种：postForEntity
     * 第二种：postForObject
     * 如果你只关注，返回的消息体，可以直接使用postForObject。用法和getForObject一致。
     * 第三种：postForLocation
     * postForLocation也是提交新资源，提交成功之后，返回新资源的URI，postForLocation的参数和前面两种的参数基本一致，
     * 只不过该方法的返回值为Uri，这个只需要服务提供者返回一个Uri即可，该Uri表示新资源的位置。
     **/
    @PostMapping("/postApi")
    public UserInfo iAmPostApi(@RequestBody UserInfo userInfo) {
        logger.info("username==================" + userInfo.getUserName());
        userInfo.setId(RandomUtils.nextInt(1, 100));
        return userInfo;
    }

    @PostMapping("/post")
    public Object testPost() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("楚子航");
        String url = "http://localhost:8080/test/postApi";
        ResponseEntity<UserInfo> responseEntity = restTemplate.postForEntity(url, userInfo, UserInfo.class);
        return responseEntity.getBody();
    }

    /**********    HTTP PUT method   没有具体实现  **************/

    @RequestMapping("/put")
    public void put() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("路明非");
        restTemplate.put("http://localhost:8080/test/postApi1/{1}", userInfo, 99);
    }

    /**********    HTTP DELETE method   没有具体实现  **************/

    @RequestMapping("/delete")
    public void delete() {
        restTemplate.delete("http://localhost:8080/test/postApi2/{1}", 100);
    }

}
