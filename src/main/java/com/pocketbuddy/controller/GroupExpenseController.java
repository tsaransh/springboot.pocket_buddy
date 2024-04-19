package com.pocketbuddy.controller;

import com.pocketbuddy.entity.GroupDetails;
import com.pocketbuddy.services.GroupServices;
import com.pocketbuddy.services.UserJoinGroupDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/pocket_buddy/group/expense")
public class GroupExpenseController {

    private final GroupServices groupServices;
    private final UserJoinGroupDetailsServices joinGroupDetailsServices;

    @Autowired
    public GroupExpenseController(GroupServices groupServices, UserJoinGroupDetailsServices joinGroupDetailsServices) {
        this.groupServices = groupServices;
        this.joinGroupDetailsServices = joinGroupDetailsServices;
    }


    @PostMapping("/create")
    public ResponseEntity<?> createExpenseGroup(@RequestParam String userUid) {
        return new ResponseEntity<>(groupServices.createGroup(userUid), HttpStatus.CREATED);
    }

    @PostMapping("/join")
    public ResponseEntity<?> joinGroup(@RequestParam String groupId, @RequestParam String userUid) {
        return ResponseEntity.ok(joinGroupDetailsServices.join(groupId,userUid));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam String groupId, @RequestParam String userUid) {
        groupServices.deleteGroup(groupId, userUid);
        GroupDetails details = groupServices.getGroup(groupId);
        return details != null ? ResponseEntity.ok(true) : new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get")
    public ResponseEntity<?> getGroupDetails(@RequestParam String groupId) {
        GroupDetails groupDetails = groupServices.getGroup(groupId);

        return ResponseEntity.ok(groupServices.getGroup(groupId));
    }

    @GetMapping("/getjoingroupbyuser")
    public ResponseEntity<?> getJoinGroupByUser(@RequestParam String userUid) {
        return null;
    }

    @DeleteMapping("/leave")
    public ResponseEntity<?> leaveGroup(@RequestParam String groupId, @RequestParam String userUid) {
        joinGroupDetailsServices.leaveGroup(groupId, userUid);
        return ResponseEntity.ok(true);
    }

    // how join who(s) groups
    @GetMapping("/getMembers")
    public ResponseEntity<?> getMembers(@RequestParam String groupId) {
        return ResponseEntity.ok(joinGroupDetailsServices.getGroupMembers(groupId));
    }

}
