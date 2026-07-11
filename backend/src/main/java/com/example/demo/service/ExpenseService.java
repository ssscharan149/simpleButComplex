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

  public List<Expense> getExpenseByDate(LocalDate date){
    return expenseRepo.getAllExpensesByDate(date);
  }

  public Expense updateExpense(Long id, Expense expense){
    Expense existingExpense = expenseRepo.findById(id).orElseThrow();

    existingExpense.setAmount(expense.getAmount());
    existingExpense.setCategory(expense.getCategory());
    existingExpense.setDate(expense.getDate());
    if(existingExpense.getNote()!= null)
      existingExpense.setNote(expense.getNote());

    return expenseRepo.save(existingExpense);
    
  }

  public Expense createExpense(Expense expense){
    return expenseRepo.save(expense);
  }

  public Expense deleteExpense(Long id){
    Expense existingExpense = expenseRepo.findById(id).orElseThrow();
    if(existingExpense != null)
      expenseRepo.delete(existingExpense);
    return existingExpense;
  }

}
