package org.activiti.user_group;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018/4/12 0012.
 */
public class CustomUserEntityManagerFactory implements SessionFactory {

    /*@Autowired
    private UserEntityManager userEntityManager;*/

    @Autowired
    private CustomUserEntityManager customUserEntityManager;

    public Class<?> getSessionType() {
        // 返回原始的UserManager类型
        return UserEntityManager.class;
    }
    public Session openSession() {
        // 返回自定义的UserManager实例
        return customUserEntityManager;
    }
}
