package org.fasttrackit.budgettrackerapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.budgettrackerapi.domain.Expense;
import org.fasttrackit.budgettrackerapi.exception.ResourceNotFoundException;
import org.fasttrackit.budgettrackerapi.persistence.ExpenseRepository;
import org.fasttrackit.budgettrackerapi.transfer.CreateExpenseIncurred;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ExpenseService.class);

    private final ExpenseRepository expenseRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, ObjectMapper objectMapper) {
        this.expenseRepository = expenseRepository;
        this.objectMapper = objectMapper;
    }

    // Incepem sa facem metodele de CRUD


    // 1. Create - adica adaugam o cheltuiala in BD
    public Expense createExpense(CreateExpenseIncurred incurring) {
        LOGGER.info("Creating expense {}", incurring);
        Expense expense = objectMapper.convertValue(incurring, Expense.class);
        return expenseRepository.save(expense);

    }

    // 2. Read - adica ne afisam una dintre cheltuielile din BD in fct de un criteriu dorit si daca nu gaseste, sa arunce o exceptie
    public Expense showExpense(long id) throws ResourceNotFoundException {
        LOGGER.info("Showing expense {}", id);
        return expenseRepository.findById(id)
                // Optional & lambda expression
                .orElseThrow(() -> new ResourceNotFoundException("Expense " + id + " not found"));

    }

}
