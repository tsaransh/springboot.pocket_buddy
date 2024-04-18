package com.pocketbuddy.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@Table(name = "group_expense_details")
@EntityListeners(AuditingEntityListener.class)
public class GroupExpenseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_no")
    public int sno;

    @Column(name = "expense_id")
    public String expenseId;

    @Column(name= "expense_title")
    public String expenseTitle;

    @Column(name="expense_amount")
    public Double expenseAmount;

    @CreatedDate
    public Date dateOfExpense;

    @Column(name="user_uid")
    public String userUid;

    @Column(name="group_id")
    public String groupId;

}
