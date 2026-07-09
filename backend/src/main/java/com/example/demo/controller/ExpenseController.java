package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Expense;
import com.example.demo.service.ExpenseService;


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
  
}
