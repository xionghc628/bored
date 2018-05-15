package com.springapp.mvc.testnio.servcer;

/**
 * Created by xionghuacheng on 2018/4/23.
 */
public interface Server {

    void stop();

    void start() throws Exception;

    void register(Class serviceInterface, Class impl);

    boolean isRunning();

    int getPort();
}
