package com.personal.dao;

import com.personal.entity.user;
import java.util.List;

public class userDao {
    //返回数据
    private final List<user> userList =  (database.getInstance()).getUserList();

    public user findUserNameAndPassword(String userName,String password){
        for(user user: userList){

            if(userName.equals(user.getUserName())&&(password.equals(user.getPassword()))){
                return  user;
            }
        }
        return null;
    }

    public boolean isUserNameOccupied(String username){
    for(user user:userList){
        if(username.equals(user.getUserName())){
            return true;
        }
    }
    return false;
    }

    public void addNewUserNameAndPassword(String username,String password) {
        userList.add(new user(username,password,0,1));
    }
}
