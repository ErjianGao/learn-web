package com.service;

import com.service.impl.UserServiceImpl;

/**
 * 在com.service下，创建ServiceFactory服务工厂，对外暴露服务对象，隐藏服务的具体实现。即，外部仅通过服务工厂获取指定服务接口对象，无需关心接口的具体实现类
 */
public class ServiceFactory {
    private static final UserService USER_SERVICE = create();

    private static UserService create() {
        return new UserServiceImpl();
    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }
}
