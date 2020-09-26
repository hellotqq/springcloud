package com.tqq.consumer;

import com.tqq.commoms.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author ： tqq
 * @date ： 2020/9/25 14:56
 * @Description:
 */
@RestController
public class UserHelloController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/hello1")
    public String hello1(){
        HttpURLConnection con = null;
        try {
            URL url = new URL("http://localhost:1113/hello");
            con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode() == 200){
                InputStream in;
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String s = br.readLine();
                br.close();
                return s;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
    @Autowired
    @Qualifier("restTemplateOne")
    RestTemplate restTemplateOne;
    @GetMapping("/hello2")
    public String hello2(){
        List<ServiceInstance> list = discoveryClient.getInstances("provider");
        ServiceInstance instance = list.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        StringBuffer sb = new StringBuffer();
        sb.append("http://")
                .append(host)
                .append(":")
                .append(port)
                .append("/hello");
        String s = restTemplateOne.getForObject(sb.toString(), String.class);
        return s;

//        HttpURLConnection con = null;
//        try {
//            URL url = new URL(sb.toString());
//            con = (HttpURLConnection) url.openConnection();
//            if (con.getResponseCode()==200){
//                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//                String s = br.readLine();
//                br.close();
//                return s;
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "error";
    }
    int count=0;
    @GetMapping("/hello3")
    public String hello3(){
        List<ServiceInstance> list = discoveryClient.getInstances("provider");
        ServiceInstance instance = list.get((count++)%list.size());
        String host = instance.getHost();
        int port = instance.getPort();
        StringBuffer sb = new StringBuffer();
        sb.append("http://")
                .append(host)
                .append(":")
                .append(port)
                .append("/hello");
        HttpURLConnection con = null;
        try {
            URL url = new URL(sb.toString());
            con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode()==200){
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String s = br.readLine();
                br.close();
                return s;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
    @Autowired
    @Qualifier("restTemplate")
    RestTemplate restTemplate;
    @GetMapping("/hello31")
    public String hello31(){
    return restTemplate.getForObject("http://provider/hello",String.class);
    }
    @GetMapping("/hello4")
    public void hello4(){
        String s1 = restTemplate.getForObject("http://provider/hello2?name={1}", String.class, "tqq");
        System.out.println(s1);
        ResponseEntity<String> rest = restTemplate.getForEntity("http://provider/hello2?name={1}", String.class, "tqq");
        String body = rest.getBody();
        System.out.println(body);
        HttpStatus statusCode = rest.getStatusCode();
        System.out.println(statusCode);
        int statusCodeValue = rest.getStatusCodeValue();
        System.out.println(statusCodeValue);
        HttpHeaders headers = rest.getHeaders();
        Set<String> keySet = headers.keySet();
        for (String s : keySet) {
            System.out.println(s+":"+headers.get(s));
        }
    }
    @GetMapping("/hello5")
    public void hello5() throws UnsupportedEncodingException {
        String s1 = restTemplate.getForObject("http://provider/hello2?name={1}", String.class, "tqq");
        System.out.println(s1);
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","zhangsan");
        s1=  restTemplate.getForObject("http://provider/hello2?name={name}",String.class,map);
        System.out.println(s1);
        String url = "http://provider/hello2?name="+ URLEncoder.encode("张三","UTF-8");
        URI uri = URI.create(url);
        s1=restTemplate.getForObject(uri,String.class);
        System.out.println(s1);
    }
    @GetMapping("/hello6")
    public void hello6(){
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("username","tqq");
        map.add("password","123");
        map.add("id",99);
        User user = restTemplate.postForObject("http://provider/user1", map, User.class);
        System.out.println(user);
        user.setId(98);
         user = restTemplate.postForObject("http://provider/user2", user, User.class);
        System.out.println(user);
    }
    @GetMapping("/hello7")
    public void hello7(){
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("username","tqq");
        map.add("password","123");
        map.add("id",99);
        URI uri = restTemplate.postForLocation("http://provider/register", map);
        String s = restTemplate.getForObject(uri, String.class);
        System.out.println(s);
    }
    @GetMapping("/hello8")
    public void hello8(){
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("username","tqq");
        map.add("password","123");
        map.add("id",99);
         restTemplate.put("http://provider/user1", map);
        User user = new User();
        user.setId(98);
        user.setUsername("tqq123");
        user.setPassword("456");
        restTemplate.put("http://provider/user2", user);
        System.out.println(user);
    }
    @GetMapping("/hello9")
    public void hello9(){
        restTemplate.delete("http://provider/user1?id={1}",99);
        restTemplate.delete("http://provider/user2/{1}",99);
    }
}
