package springcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import springcloud.domain.User;
import springcloud.service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tzhou on 2017/7/24.
 */
@RestController
@RequestMapping("/user")
public class ExportController {


        @Autowired
        private UserService userService;

        @Resource
        private DiscoveryClient client;


        @RequestMapping(value="/getUserById",method=RequestMethod.GET)
        @ResponseBody
        public User getUserById(){
            return userService.findOne();
        }

        @RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
        @ResponseBody
        public List<User> getAllUsers(){
            int total = userService.coutUser();
            //获取服务信息
            System.out.println(total);
            ServiceInstance instance = client.getLocalServiceInstance();
            //输出服务信息
            System.out.println(String.format("uri={}，serviceId={}，result={}", instance.getUri(), instance.getServiceId(),total));
            return new ArrayList<>();
        }

}
