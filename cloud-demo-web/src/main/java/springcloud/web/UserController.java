package springcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springcloud.domain.User;
import springcloud.service.UserService;
import springcloud.service.UserServiceByFeign;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Resource
    UserServiceByFeign userSeriveFeign;

    @RequestMapping(value="/getAllUsers")
    @ResponseBody
    public ResponseEntity<User> getAllUsers(){
        return new ResponseEntity<User>(userService.readUserInfo(), HttpStatus.OK);
    }

    @RequestMapping(value="/getUsersFeign")
    @ResponseBody
    public ResponseEntity<List<User>> getUsersFeign(){
        return new ResponseEntity<List<User>>(userSeriveFeign.getAllUsers(), HttpStatus.OK);
    }
}
