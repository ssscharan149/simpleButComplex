package com.example.demo.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Expense;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {
  Expense getExpenseByDate(LocalDate date);
}
