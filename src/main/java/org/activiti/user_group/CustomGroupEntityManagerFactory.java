package org.activiti.user_group;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.activiti.user_group.CustomGroupManager;

/**
 * Created by Administrator on 2018/4/12 0012.
 */
public class CustomGroupEntityManagerFactory implements SessionFactory{

    @Autowired
    private CustomGroupManager groupManager;

    /*
    private GroupEntityManager groupEntityManager;

    @Autowired
    public void setGroupEntityManager(GroupEntityManager groupEntityManager) {
        this.groupEntityManager = groupEntityManager;
    }
    */

    public Class<?> getSessionType() {
        // 返回原始的GroupEntityManager类型
        return GroupEntityManager.class;
    }

    public Session openSession() {
        // 返回自定义的GroupEntityManager实例
        return groupManager;
    }

}
