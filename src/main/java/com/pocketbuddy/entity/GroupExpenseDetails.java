package com.pocketbuddy.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
@Entity
@Table(name = "group_expense_details")
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
    public String user_uid;

    @Column(name="group_id")
    public String groupId;

}
