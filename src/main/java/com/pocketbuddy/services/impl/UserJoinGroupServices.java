package com.pocketbuddy.services.impl;

import com.pocketbuddy.entity.UserJoinGroupDetails;
import com.pocketbuddy.repository.UserJoinGroupDetailsRepository;
import com.pocketbuddy.services.UserJoinGroupDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserJoinGroupServices implements UserJoinGroupDetailsServices {

    private final UserJoinGroupDetailsRepository joinGroupDetailsRepository;

    @Autowired
    public UserJoinGroupServices(UserJoinGroupDetailsRepository joinGroupDetailsRepository) {
        this.joinGroupDetailsRepository = joinGroupDetailsRepository;
    }

    @Override
    public UserJoinGroupDetails join(String groupId, String userUid) {
        UserJoinGroupDetails groupDetails = new UserJoinGroupDetails();
        groupDetails.setGroupId(groupId);
        groupDetails.setUserUid(userUid);
        return joinGroupDetailsRepository.save(groupDetails);
    }

    public Optional<List<String>> getGroupMembers(String groupId) {
        return joinGroupDetailsRepository.getMembers(groupId);
    }

    @Override
    public void deleteGroup(String groupId) {
        joinGroupDetailsRepository.deleteByGroupId(groupId);
    }

    @Override
    public void leaveGroup(String groupId, String userUid) {
        joinGroupDetailsRepository.leave(groupId, userUid);
    }
}
