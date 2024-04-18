package com.pocketbuddy.services.impl;

import com.pocketbuddy.entity.GroupExpenseDetails;
import com.pocketbuddy.payload.ExpenseStatement;
import com.pocketbuddy.payload.GroupExpenseDetailsInput;
import com.pocketbuddy.repository.GroupExpenseDetailsRepository;
import com.pocketbuddy.services.GroupExpenseDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupExpenseDateServices implements GroupExpenseDetailsServices {

    private final GroupExpenseDetailsRepository groupExpenseRepository;

    @Autowired
    public GroupExpenseDateServices(GroupExpenseDetailsRepository groupExpenseRepository) {
        this.groupExpenseRepository = groupExpenseRepository;
    }

    @Override
    public GroupExpenseDetails add(GroupExpenseDetailsInput detailsInput) {
        GroupExpenseDetails expenseDetails = new GroupExpenseDetails();
        expenseDetails.setExpenseId(detailsInput.expenseId);
        expenseDetails.setExpenseTitle(detailsInput.expenseTitle);
        expenseDetails.setExpenseAmount(detailsInput.expenseAmount);
        expenseDetails.setGroupId(detailsInput.groupId);
        expenseDetails.setUserUid(detailsInput.userUid);

        return groupExpenseRepository.save(expenseDetails);
    }

    @Override
    public GroupExpenseDetails update(GroupExpenseDetailsInput detailsInput) {
        GroupExpenseDetails expenseDetails = new GroupExpenseDetails();

        expenseDetails.setExpenseTitle(detailsInput.expenseTitle);
        expenseDetails.setExpenseAmount(detailsInput.expenseAmount);

        return groupExpenseRepository.save(expenseDetails);
    }

    @Override
    public void delete(String expenseId) {
        groupExpenseRepository.deleteByExpenseId(expenseId);
    }

    public void deleteGroup(String groupId) {
        groupExpenseRepository.deleteGroup(groupId);
    }

    @Override
    public GroupExpenseDetails read(String expenseId) {
        return groupExpenseRepository.findByExpenseId(expenseId);
    }

    @Override
    public Optional<List<GroupExpenseDetails>> getStatement(String groupId) {
        return groupExpenseRepository.getStatement(groupId);
    }

    @Override
    public Double getTotal(String groupId) {
        return groupExpenseRepository.getTotal(groupId);
    }

    @Override
    public Optional<List<GroupExpenseDetails>> getStatementWithDates(ExpenseStatement statement) {
        return groupExpenseRepository.getStatement(statement.id, statement.startDate, statement.endDate);
    }

    @Override
    public Double getTotalWithDates(ExpenseStatement statement) {
        return groupExpenseRepository.getTotal(statement.id, statement.startDate, statement.endDate);
    }
}
