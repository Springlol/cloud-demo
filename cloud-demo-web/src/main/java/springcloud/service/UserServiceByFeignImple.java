package springcloud.service;

import org.springframework.stereotype.Component;
import springcloud.domain.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceByFeignImple implements UserServiceByFeign{

	@Override
	public List<User> getAllUsers() {
		return new ArrayList<User>();
	}

}
