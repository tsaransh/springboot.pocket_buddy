package com.pocketbuddy.services;

import com.pocketbuddy.payload.PersonalExpenseDTO;
import com.pocketbuddy.payload.ExpenseStatement;
import com.pocketbuddy.entity.PersonalExpense;

import java.util.List;
import java.util.Optional;

public interface PersonalServices {

    public PersonalExpense add(PersonalExpenseDTO personalExpenseDTO);
    public PersonalExpense update(PersonalExpenseDTO personalExpenseDTO);
    public List<Optional<PersonalExpense>> getUserStatements(String userUid);
    public Double getTotalExpenseSum(String userUid);
    public List<Optional<PersonalExpense>> getUserStatementBetweenData(ExpenseStatement personalExpenseStatement);
    public Double getTotalExpenseSumBetweenData(ExpenseStatement personalExpenseStatement);
    public boolean delete(String id);

    PersonalExpense getExpenseDetails(String expenseId);
}
