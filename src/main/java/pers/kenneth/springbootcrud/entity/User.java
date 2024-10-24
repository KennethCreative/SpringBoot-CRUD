//实体类（Entity）：用于映射到数据库表的类。
package pers.kenneth.springbootcrud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
}

/*
 * Lombok的注解
 * @Data注解可以自动为Java类生成setter和getter方法，‌以及toString()、‌equals()和hashCode()方法。‌
 *
 * JPA的注解
 * @Entity：用于标记一个类为JPA实体，表示该类对应数据库中的一个表。
 * @Table：用于自定义实体类对应的数据库表名、schema等。
 * @Id：用于标记实体类中的属性作为数据库表的主键。
 * @GeneratedValue：用于指定主键的生成策略，如自动生成、序列生成等。
 * @JoinColumn和@JoinTable：分别用于一对一和一对多的关联映射。
 * */