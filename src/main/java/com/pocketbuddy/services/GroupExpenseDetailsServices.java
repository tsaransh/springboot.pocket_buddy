package com.pocketbuddy.services;

import com.pocketbuddy.entity.GroupExpenseDetails;
import com.pocketbuddy.payload.ExpenseStatement;
import com.pocketbuddy.payload.GroupExpenseDetailsInput;

import java.util.Optional;
import java.util.List;

public interface GroupExpenseDetailsServices {

    public GroupExpenseDetails add(GroupExpenseDetailsInput detailsInput);
    public GroupExpenseDetails update(GroupExpenseDetailsInput detailsInput);
    public void delete(String expenseId);
    public void deleteGroup(String groupId);
    public GroupExpenseDetails read(String expenseId);

    public Optional<List<GroupExpenseDetails>> getStatement(String groupId);
    public Double getTotal(String groupId);

    public Optional<List<GroupExpenseDetails>> getStatementWithDates(ExpenseStatement statement);
    public Double getTotalWithDates(ExpenseStatement statement);

}
