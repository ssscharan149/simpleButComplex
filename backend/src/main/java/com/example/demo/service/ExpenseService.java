package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.repository.ExpenseRepo;
import com.example.demo.model.Expense;

import java.time.LocalDate;
import java.util.List;


@Service
public class ExpenseService {
  private final ExpenseRepo expenseRepo;
  public ExpenseService(ExpenseRepo expenseRepo){
    this.expenseRepo = expenseRepo;
  }
  
  public List<Expense> getAllExpenses(){
    return expenseRepo.findAll();
  }

  public Expense getExpenseByDate(LocalDate date){
    return expenseRepo.getExpenseByDate(date);
  }

  // if made, all other fields remains same, except the one which is edited
  // public void updateExpense(@Request){

  // }

}
