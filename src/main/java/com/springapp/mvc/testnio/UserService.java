package com.springapp.mvc.testnio;

/**
 * Created by xionghuacheng on 2018/4/23.
 */
public interface UserService {

    /**
     * 根据ID 获取用户名称
     * @param userId
     * @return
     */
    String getName(Long userId);
}
