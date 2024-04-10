package com.pocketbuddy.services;

import com.pocketbuddy.payload.PersonalExpenseDTO;
import com.pocketbuddy.payload.PersonalExpenseStatement;
import com.pocketbuddy.entity.PersonalExpense;

import java.util.List;
import java.util.Optional;

public interface PersonalServices {

    public PersonalExpense add(PersonalExpenseDTO personalExpenseDTO);
    public PersonalExpense update(PersonalExpenseDTO personalExpenseDTO);
    public List<Optional<PersonalExpense>> getUserStatements(String userUid);
    public Double getTotalExpenseSum(String userUid);
    public List<PersonalExpense> getUserStatementBetweenData(PersonalExpenseStatement personalExpenseStatement);
    public Double getTotalExpenseSumBetweenData(PersonalExpenseStatement personalExpenseStatement);
    public boolean delete(String id);

}
