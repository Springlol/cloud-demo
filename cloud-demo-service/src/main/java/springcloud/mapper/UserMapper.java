package springcloud.mapper;

import springcloud.domain.User;

/**
 * Created by Tzhou on 2017/7/24.
 */
public interface UserMapper {

    User findOne(Long id);

    int countUser();
}
