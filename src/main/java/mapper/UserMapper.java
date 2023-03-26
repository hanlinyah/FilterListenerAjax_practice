package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import pojo.User;

import java.util.List;

public interface UserMapper {

    @Insert(value = "insert into users values (null,#{username},#{password})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(User user);

    @Select(value = "select * from users where username=#{username} and password=#{password}")
    User selectByUsernameAndPassword(User user);

    @Select(value = "select * from users where username=#{username} ")
    User selectByUsername(String username);

    @Select(value = "select * from users ")
    List<User> selectAll();
}
