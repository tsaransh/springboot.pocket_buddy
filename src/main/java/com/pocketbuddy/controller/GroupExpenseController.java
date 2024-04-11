package com.pocketbuddy.controller;

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

    // delete get leave

}
