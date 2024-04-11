package com.pocketbuddy.services;

import com.pocketbuddy.entity.GroupDetails;
import com.pocketbuddy.payload.GroupDetailsReturn;

public interface GroupServices {

    public GroupDetailsReturn createGroup(String userUid);
    public void deleteGroup(String groupId);
    public GroupDetails update(String groupTitle, String groupId);
    public GroupDetails getGroup(String groupId);


}
