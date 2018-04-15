package org.activiti.user_group;

import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.activiti.user_group.user.User;
import org.activiti.user_group.user.UserManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/12 0012.
 */
@Service
public class CustomUserEntityManager extends UserEntityManager{

    private static final Log logger = LogFactory
            .getLog(CustomUserEntityManager.class);

    @Autowired
    private UserManager userManager;//自己实现的获取用户数据的Service

    @Override
    public UserEntity findUserById(final String userCode) {
        if (userCode == null)
            return null;

        try {
            UserEntity userEntity = new UserEntity();
            org.activiti.user_group.user.User bUser = userManager.getUser(userCode);
            //userEntity = ActivitiUtils.toActivitiUser(bUser);
            //类似CustomGroupManager映射方式
            userEntity.setId(bUser.getId());
            userEntity.setPassword(bUser.getPassword());


            return userEntity;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Group> findGroupsByUser(final String userCode) {
        if (userCode == null)
            return null;

        List<org.activiti.user_group.group.Group> bGroups = userManager.getUser(userCode).getGroupList();

        //List<Group> gs = null;
        //gs = ActivitiUtils.toActivitiGroups(bGroups);
        List<Group> gs = new ArrayList<>();
        GroupEntity g;
        for (org.activiti.user_group.group.Group bGroup : bGroups) {
            g = new GroupEntity();
            g.setRevision(1);
            g.setType("assignment");

            g.setId(bGroup.getId());
            g.setName(bGroup.getName());
            gs.add(g);
        }

        return gs;

    }

    @Override
    public List<org.activiti.engine.identity.User> findUserByQueryCriteria(UserQueryImpl query, Page page) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public IdentityInfoEntity findUserInfoByUserIdAndKey(String userId,
                                                         String key) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public List<String> findUserInfoKeysByUserIdAndType(String userId,
                                                        String type) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public long findUserCountByQueryCriteria(UserQueryImpl query) {
        throw new RuntimeException("not implement method.");
    }

}
