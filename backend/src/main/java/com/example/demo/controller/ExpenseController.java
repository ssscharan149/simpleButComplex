package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Expense;
import com.example.demo.service.ExpenseService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

  private final ExpenseService expenseService;
  public ExpenseController(ExpenseService expenseService){
    this.expenseService = expenseService;
  }

  @GetMapping("/getAllExpenses")
  public List<Expense> getExpenses() {
    // return;
    return expenseService.getAllExpenses();
  }

  @GetMapping("/getAllExpensesByDate/{date}")
  public List<Expense> getExpenseByDate(@PathVariable LocalDate date) {
    return expenseService.getExpenseByDate(date);
  }

  @PutMapping("updateExpense/{id}")
  public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
    return expenseService.updateExpense(id, expense);
  }

  @PostMapping("createExpense")
  public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
    Expense createdUser = expenseService.createExpense(expense);
    return ResponseEntity.ok(createdUser);
    // return ResponseEntity.ok(null);
  }
  
  @DeleteMapping("deleteExpense/{id}")
  public Expense deleteExpense(@PathVariable Long id){
    return expenseService.deleteExpense(id);
  }
}
