//业务逻辑层接口
package pers.kenneth.springbootcrud.service;

import pers.kenneth.springbootcrud.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    //获取全部数据
    public List<User> getAllUsers();

    //通过ID查找
    public Optional<User> getUserById(Long id);

    //保存数据
    public User saveUser(User user);

    //删除数据
    public void deleteUser(Long id);
}
