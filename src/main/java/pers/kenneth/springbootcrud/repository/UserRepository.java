//数据访问对象（Repository）：用于与数据库交互的接口。
package pers.kenneth.springbootcrud.repository;
//Spring Data JPA

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.kenneth.springbootcrud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

