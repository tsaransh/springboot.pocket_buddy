package com.pocketbuddy.services.impl;

import com.pocketbuddy.entity.GroupDetails;
import com.pocketbuddy.payload.GroupDetailsReturn;
import com.pocketbuddy.repository.GroupRepository;
import com.pocketbuddy.services.GroupServices;
import com.pocketbuddy.services.UserJoinGroupDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class GroupExpenseServices implements GroupServices {

    private final GroupRepository group;
    private final UserJoinGroupDetailsServices joinGroupDetailsServices;

    @Autowired
    public GroupExpenseServices(GroupRepository group, UserJoinGroupDetailsServices joinGroupDetailsServices) {
        this.group = group;
        this.joinGroupDetailsServices = joinGroupDetailsServices;
    }


    @Override
    public GroupDetailsReturn createGroup(String userUid) {
        long timeStamp = System.currentTimeMillis();
        UUID uuid = UUID.randomUUID();
        String groupId = timeStamp + uuid.toString().substring(0,6);
        String title = uuid.toString().substring(0,6);

        GroupDetails groupDetails = new GroupDetails();
        groupDetails.setGroupId(groupId);
        groupDetails.setGroupTitle(title);
        groupDetails.setUserUid(userUid);

        GroupDetailsReturn detailsReturn = new GroupDetailsReturn();
        detailsReturn.groupDetails = group.save(groupDetails);
        detailsReturn.userJoinGroupDetails = joinGroupDetailsServices.join(groupId, userUid);

        return detailsReturn;
    }

    @Override
    public void deleteGroup(String groupId) {
        // delete data from all three table
        group.deleteById(groupId);
        joinGroupDetailsServices.deleteGroup(groupId);
    }

    @Override
    public GroupDetails update(String groupTitle, String groupId) {
        GroupDetails groupDetails = getGroup(groupId);
        groupDetails.setGroupTitle(groupTitle);

        return group.save(groupDetails);
    }

    @Override
    public GroupDetails getGroup(String groupId) {
        return group.findById(groupId).orElseThrow();
    }
}
