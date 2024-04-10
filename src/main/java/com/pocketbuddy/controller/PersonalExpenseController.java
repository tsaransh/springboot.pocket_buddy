package com.pocketbuddy.controller;


import com.pocketbuddy.entity.PersonalExpense;
import com.pocketbuddy.payload.PersonalExpenseDTO;
import com.pocketbuddy.payload.PersonalExpenseStatement;
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
        return null;
    }

    @GetMapping("/alltimestatement")
    public ResponseEntity<?> getUserStatements(@RequestParam String userUid) {
        List<Optional<PersonalExpense>> expenseList = services.getUserStatements(userUid);
        return new ResponseEntity<>(expenseList, HttpStatus.FOUND);
    }

    @GetMapping("/alltimetotal")
    public ResponseEntity<?> getTotalExpenseSum(@RequestParam String userUid) {
        return null;
    }

    @GetMapping("/statement")
    public void getUserStatementBetweenData(@RequestBody PersonalExpenseStatement personalExpenseStatement) {

    }

    @GetMapping("/total")
    public void getTotalExpenseSumBetweenData(@RequestBody PersonalExpenseStatement personalExpenseStatement) {

    }

    @DeleteMapping("/delete")
    public void deleteExpense() {

    }

}
