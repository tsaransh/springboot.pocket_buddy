package com.pocketbuddy.controller;

import com.pocketbuddy.payload.ExpenseStatement;
import com.pocketbuddy.payload.GroupExpenseDetailsInput;
import com.pocketbuddy.services.GroupExpenseDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/pocket_buddy/group/expense/data")
public class GroupExpenseDataController {

    private final GroupExpenseDetailsServices detailsServices;

    @Autowired
    public GroupExpenseDataController(GroupExpenseDetailsServices detailsServices) {
        this.detailsServices = detailsServices;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody GroupExpenseDetailsInput detailsInput) {
        return new ResponseEntity<>(detailsServices.add(detailsInput), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody GroupExpenseDetailsInput detailsInput) {
        return ResponseEntity.ok(detailsServices.update(detailsInput));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam String expenseId) {
        detailsServices.delete(expenseId);
    }

    @GetMapping("/statement")
    public ResponseEntity<?> getStatement(@RequestParam String groupId) {
        return ResponseEntity.ok(detailsServices.getStatement(groupId));
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getTotal(@RequestParam String groupId) {
        return ResponseEntity.ok(detailsServices.getTotal(groupId));
    }

    @GetMapping("/getStatementByDates")
    public ResponseEntity<?> getStatementWithDate(@RequestBody ExpenseStatement expenseStatement) {
        return ResponseEntity.ok(detailsServices.getStatementWithDates(expenseStatement));
    }

    @GetMapping("getTotalByDates")
    public ResponseEntity<Double> getTotalWithDates(@RequestBody ExpenseStatement expenseStatement) {
        return ResponseEntity.ok(detailsServices.getTotalWithDates(expenseStatement));
    }

}
