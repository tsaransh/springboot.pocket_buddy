package com.pocketbuddy.services;

import com.pocketbuddy.entity.UserJoinGroupDetails;

import java.util.List;
import java.util.Optional;

public interface UserJoinGroupDetailsServices {

    public UserJoinGroupDetails join(String groupId, String userUid);
    public Optional<List<String>> getGroupMembers(String groupId);
    public void deleteGroup(String groupId);
    public void leaveGroup(String groupId, String userUid);

}
