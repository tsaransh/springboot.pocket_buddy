package com.pocketbuddy.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name = "user_join_group_details")
@Data
@EntityListeners(AuditingEntityListener.class)
public class UserJoinGroupDetails {

    @Id
    @Column(name = "s_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Sno;

    @Column(name="group_id")
    public String groupId;

    @Column(name = "user_uid")
    public String userUid;

    @CreatedDate
    @Column(name="joined_date")
    public Date joinDate;



}
