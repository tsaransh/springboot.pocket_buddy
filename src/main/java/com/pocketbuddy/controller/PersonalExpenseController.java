package com.pocketbuddy.controller;


import com.pocketbuddy.entity.PersonalExpense;
import com.pocketbuddy.payload.PersonalExpenseDTO;
import com.pocketbuddy.payload.ExpenseStatement;
import com.pocketbuddy.services.PersonalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/pocket_buddy/personal/expense")
public class PersonalExpenseController {

    private final PersonalServices services;

    @Autowired
    public PersonalExpenseController(PersonalServices services) {
        this.services = services;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addExpense(@RequestBody PersonalExpenseDTO personalExpenseDTO) {
        return new ResponseEntity<>(services.add(personalExpenseDTO), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateExpense(@RequestBody PersonalExpenseDTO personalExpenseDTO) {
        return new ResponseEntity<>(services.update(personalExpenseDTO), HttpStatus.OK);
    }

    @GetMapping("/alltimestatement")
    public ResponseEntity<?> getUserStatements(@RequestParam String userUid) {
        List<Optional<PersonalExpense>> expenseList = services.getUserStatements(userUid);
        if(!expenseList.isEmpty())
            return  ResponseEntity.ok(expenseList);
        else
            return ResponseEntity.ok(List.of());
    }

    @GetMapping("/alltimetotal")
    public ResponseEntity<?> getTotalExpenseSum(@RequestParam String userUid) {
        double result = services.getTotalExpenseSum(userUid);
       return result !=0.00 ? ResponseEntity.ok(result) : ResponseEntity.ok(0.00);
    }

    @PostMapping("/statements")
    public ResponseEntity<List<Optional<PersonalExpense>>> getUserStatementBetweenData(@RequestBody ExpenseStatement personalExpenseStatement) {
        List<Optional<PersonalExpense>> expenseList = services.getUserStatementBetweenData(personalExpenseStatement);
        return !expenseList.isEmpty() ? ResponseEntity.ok(expenseList) : ResponseEntity.ok(List.of());
    }

    @PostMapping("/total")
    public ResponseEntity<?> getTotalExpenseSumBetweenData(@RequestBody ExpenseStatement personalExpenseStatement) {
        double result = services.getTotalExpenseSumBetweenData(personalExpenseStatement);
        return result !=0.00 ? ResponseEntity.ok(result) : ResponseEntity.ok(0.00);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteExpense(@RequestParam String id) {
        return ResponseEntity.ok(services.delete(id));
    }

    @GetMapping("/statement/details")
    public ResponseEntity<?> getStatementDetails(@RequestParam String expenseId) {
        PersonalExpense expense = services.getExpenseDetails(expenseId);
        return expense != null ? ResponseEntity.ok(expense) : ResponseEntity.ok(null);
    }


}
