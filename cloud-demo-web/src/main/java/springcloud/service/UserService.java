package springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import springcloud.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tzhou on 2017/7/24.
 */
@Component
public class UserService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${service.name:cloudservice}")
    String SERVICE_NAME;

    @SuppressWarnings("unchecked")
    @HystrixCommand(fallbackMethod = "fallbackSearchAll")
    public User readUserInfo() {
        return restTemplate.getForObject("http://"+ SERVICE_NAME +"/user/getUserById", User.class);
    }

    @SuppressWarnings("unused")
    private User fallbackSearchAll() {
        System.out.println("HystrixCommand fallbackMethod handle!");
        /*List<User> ls = new ArrayList<User>();
        User user = new User();
        user.setName("ivan");
        ls.add(user);*/
        return new User(2L,"ali","hangzhou");
    }
}
