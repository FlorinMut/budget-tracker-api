package org.fasttrackit.budgettrackerapi.web;

import org.fasttrackit.budgettrackerapi.domain.Expense;
import org.fasttrackit.budgettrackerapi.exception.ResourceNotFoundException;
import org.fasttrackit.budgettrackerapi.service.ExpenseService;
import org.fasttrackit.budgettrackerapi.transfer.AddExpense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import sun.security.util.PropertyExpander;


// FACEM un servlet
@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }


    //facem un Endpoint care sa ne dea o ch dupa ID
    @GetMapping("/{id}")
    public ResponseEntity<Expense> showExpense(@PathVariable("id") long id) throws ResourceNotFoundException {
        Expense response = expenseService.showExpense(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    // un alt Endpoint - de create
    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody @Valid AddExpense incurred) {

        Expense reponse = expenseService.addExpense(incurred);
        return new ResponseEntity<>(reponse, HttpStatus.CREATED);

    }

}
