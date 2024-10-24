//服务类（Service）：包含业务逻辑。
package pers.kenneth.springbootcrud.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kenneth.springbootcrud.entity.User;
import pers.kenneth.springbootcrud.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    //业务逻辑层调用数据访问层
    private final UserRepository userRepository;

    //构造方法
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    * 以上代码也可以写为以下代码
    * @Autowired
    * private UserRepository userRepository;
    * */

    //获取全部数据
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //通过ID查找
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    //保存数据
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //删除数据
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
