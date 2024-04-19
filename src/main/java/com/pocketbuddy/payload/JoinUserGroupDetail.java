package com.pocketbuddy.payload;

import lombok.Data;

import java.util.Date;

@Data
public class JoinUserGroupDetail {

    public String groupId;
    public String groupTitle;
    public Date createdDate;
    public String userUid;

}
