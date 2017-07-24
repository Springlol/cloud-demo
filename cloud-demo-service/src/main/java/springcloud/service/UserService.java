package springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import springcloud.domain.User;
import springcloud.mapper.UserMapper;

import javax.annotation.Resource;

/**
 * Created by Tzhou on 2017/7/24.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private DiscoveryClient client;

    public User findOne() {
        return userMapper.findOne(1L);
    }


    public int coutUser() {
        return userMapper.countUser();
    }

}
