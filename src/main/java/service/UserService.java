package service;

import mapper.UserMapper;
import pojo.User;

public class UserService {
    static UserMapper userMapper;
    public static User login(String username, String password){

        userMapper=util.getSession.getUserMapper();
        User user=userMapper.selectByUsernameAndPassword(new User(username,password));
        util.getSession.closeSession();
        return user;
    }

    public static boolean register(String username,String password){
        userMapper=util.getSession.getUserMapper();
        User user=userMapper.selectByUsername(username);
        if(user == null){
            userMapper.insert(new User(username,password));
        }
        util.getSession.closeSession();
        return  user == null;
    }

    public static boolean registerCheckName(String username){
        userMapper=util.getSession.getUserMapper();
        User user=userMapper.selectByUsername(username);
        util.getSession.closeSession();
        return  user == null;
    }
}
