package org.activiti.user_group.user;

import org.activiti.user_group.group.Group;

import java.util.List;

/**
 * Created by Administrator on 2018/4/12 0012.
 */
public class User {

    private String id;

    private String name;

    private String password;

    private List<Group> groupList;


    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
