package com.springapp.mvc.testnio.servcer;

import com.springapp.mvc.testnio.UserService;

/**
 * Created by xionghuacheng on 2018/4/23.
 */
public class UserServiceImpl implements UserService {

    @Override
    public String getName(Long userId) {
        if(userId == null){
            return "不存在用户";
        }
        return userId + "号玩家";
    }
}
