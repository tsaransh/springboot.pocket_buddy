package com.pocketbuddy.repository;

import com.pocketbuddy.entity.UserJoinGroupDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserJoinGroupDetailsRepository extends JpaRepository<UserJoinGroupDetails, String> {

    @Query(value = "DELETE FROM user_join_group_details WHERE group_id = :groupId", nativeQuery = true)
    public void deleteByGroupId(@Param("groupId") String groupId);

    @Query(value = "DELETE from user_join_group_details where group_id = :groupId and user_uid = :userUid", nativeQuery = true)
    public void leave(@Param("groupId") String groupId,@Param("userUid") String userUid);

    @Query(value = "select user_uid from user_join_group_details where group_id = :groupId", nativeQuery = true)
    public Optional<List<String>> getMembers(@Param("groupId") String groupId);
}
