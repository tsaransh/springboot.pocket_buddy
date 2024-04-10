package com.pocketbuddy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users_personal_expenses_table")
@Entity
public class PersonalExpense {
    @Id
    @Column(name = "id")
    public String id;
    @Column(name = "expense_title")
    public String expenseTitle;
    @Column(name = "expense_amount")
    public Double expenseAmount;
    @Column(name = "expense_date")
    public Date date;
    @Column(name="user_uid")
    public String userUid;
}
