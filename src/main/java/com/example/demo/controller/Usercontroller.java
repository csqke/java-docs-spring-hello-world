// package com.example.demo.controller;

// import com.example.demo.pojo.student;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.client.RestTemplate;
// @RestController
// @RequestMapping("/consumer")
// public class Usercontroller {

//     @Autowired
//     private RestTemplate restTemplate;

//     @RequestMapping("/find-provider1")
//     public Long findUserByIdprovider1(){
//         String url = "https://csqweb.azurewebsites.net/getCount";
//         return restTemplate.getForObject(url, Long.class);
//     }

//     @RequestMapping("/find-provider2")
//     public String findUserByIdprovider2(){
//         String url = "https://csqweb.azurewebsites.net/findAll";
//         return restTemplate.getForObject(url, String.class);
//     }
// }
package com.example.demo.controller;

import com.example.demo.pojo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/customers")
public class Usercontroller {
    private static String PROVIDER_URL = "https://csqweb.azurewebsites.net/provider/";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/count")
    public Long count(){
        String url = PROVIDER_URL+"count";
        return restTemplate.getForObject(url, Long.class);
    }

    @RequestMapping("/list")
    public String list(){
        String url = PROVIDER_URL+"list";
        return restTemplate.getForObject(url, String.class);
    }

    @RequestMapping("/get-by-id/{id}")
    public String getById(@PathVariable(value = "id")Integer id){
        String url = PROVIDER_URL+"get-by-id";
        HashMap<String, Integer> paraMap = new HashMap<>();
        paraMap.put("id",id);
        return restTemplate.getForObject(url, String.class,paraMap);
    }
}
