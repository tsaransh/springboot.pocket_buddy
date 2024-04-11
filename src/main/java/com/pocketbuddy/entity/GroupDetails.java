package com.pocketbuddy.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Table(name = "group_details")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class GroupDetails {

    @Id
    @Column(name = "group_id")
    public String groupId; //Primary Key

    @Column(name="group_title")
    public String groupTitle;

    @CreatedDate
    @Column(name="created_date")
    public Date createdDate;

    @Column(name="create_by")
    public String userUid;



}
