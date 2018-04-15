package org.activiti.user_group;


import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.impl.GroupQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.activiti.user_group.group.GroupManager;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的Activiti用户组管理器
 *
 */
@Service
public class CustomGroupManager extends GroupEntityManager {

    private static final Log logger = LogFactory
            .getLog(CustomGroupManager.class);

    @Autowired
    private GroupManager groupManager;

    public GroupEntity findGroupById(final String groupCode) {
        if (groupCode == null)
            return null;

        try {
            org.activiti.user_group.group.Group bGroup = groupManager.getGroupByGroupId(groupCode);

            GroupEntity e = new GroupEntity();
            e.setRevision(1);

            // activiti有3种预定义的组类型：security-role、assignment、user
            // 如果使用Activiti
            // Explorer，需要security-role才能看到manage页签，需要assignment才能claim任务
            e.setType("assignment");

            e.setId(bGroup.getId());
            e.setName(bGroup.getName());
            return e;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    @Override
    public List<Group> findGroupsByUser(final String userCode) {
        if (userCode == null)
            return null;

        List<org.activiti.user_group.group.Group> bGroupList = groupManager.getUser(userCode).getGroupList();

        List<Group> gs = new ArrayList<>();
        GroupEntity g;
        for (org.activiti.user_group.group.Group bGroup : bGroupList) {
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
    public List<Group> findGroupByQueryCriteria(GroupQueryImpl query, Page page) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public long findGroupCountByQueryCriteria(GroupQueryImpl query) {
        throw new RuntimeException("not implement method.");
    }


}
