package com.pocketbuddy.services.impl;

import com.pocketbuddy.exception.ApiException;
import com.pocketbuddy.payload.PersonalExpenseDTO;
import com.pocketbuddy.payload.ExpenseStatement;
import com.pocketbuddy.entity.PersonalExpense;
import com.pocketbuddy.repository.PersonalRepository;
import com.pocketbuddy.services.PersonalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PersonalExpenseServices implements PersonalServices {

    private final PersonalRepository repository;

    @Autowired
    public PersonalExpenseServices(PersonalRepository repository) {
        this.repository = repository;
    }


    @Override
    public PersonalExpense add(PersonalExpenseDTO personalExpenseDTO)  {

        if (personalExpenseDTO == null || personalExpenseDTO.getId() == null ||
                personalExpenseDTO.getExpenseTitle() == null || personalExpenseDTO.getExpenseAmount() == null ||
                personalExpenseDTO.getUserUid() == null) {
            throw new ApiException("PersonalExpense or its fields cannot be null");
        }

        PersonalExpense expense = new PersonalExpense();

        expense.setId(personalExpenseDTO.getId());
        expense.setExpenseTitle(personalExpenseDTO.getExpenseTitle());
        expense.setExpenseAmount(personalExpenseDTO.getExpenseAmount());
        expense.setDate(new Date());
        expense.setUserUid(personalExpenseDTO.getUserUid());

        return repository.save(expense);
    }


    @Override
    public PersonalExpense update(PersonalExpenseDTO personalExpenseDTO) {
        PersonalExpense expense = repository.findById(personalExpenseDTO.getId()).orElseThrow();

        expense.setExpenseTitle(personalExpenseDTO.getExpenseTitle());
        expense.setExpenseAmount(personalExpenseDTO.getExpenseAmount());

        return repository.save(expense);
    }

    @Override
    public List<Optional<PersonalExpense>> getUserStatements(String userUid) {
        if(userUid == null || userUid.trim().isEmpty()) {
            throw new ApiException("user uid can't be empty or null");
        }

        return repository.getStatements(userUid);
    }

    @Override
    public Double getTotalExpenseSum(String userUid) {
          double amount = repository.getTotalExpense(userUid);
        return amount != 0 ? amount : 0.00;
    }

    @Override
    public List<Optional<PersonalExpense>> getUserStatementBetweenData(ExpenseStatement personalExpenseStatement) {
        if(personalExpenseStatement == null ||personalExpenseStatement.id.isEmpty()
                || personalExpenseStatement.startDate == null
                || personalExpenseStatement.endDate == null) {
            throw new ApiException("user_uid and date can't be empty and null");
        }
        return repository.getUserStatementBetweenData(
                personalExpenseStatement.id,
                personalExpenseStatement.startDate,
                personalExpenseStatement.endDate
                );
    }

    @Override
    public Double getTotalExpenseSumBetweenData(ExpenseStatement personalExpenseStatement) {
        if(personalExpenseStatement == null ||personalExpenseStatement.id.isEmpty()
                || personalExpenseStatement.startDate == null
                || personalExpenseStatement.endDate == null) {
            throw new ApiException("user_uid and date can't be empty and null");
        }
        return repository.getTotalExpenseSumBetweenData(
                personalExpenseStatement.id,
                personalExpenseStatement.startDate,
                personalExpenseStatement.endDate
        );
    }

    @Override
    public boolean delete(String id) {
        PersonalExpense expense = repository.findById(id).orElseThrow();
        repository.delete(expense);

        return !repository.existsById(id);
        // return true that mean the data was deleted if false data is not return
    }
}
