package org.fasttrackit.budgettrackerapi;

import org.fasttrackit.budgettrackerapi.domain.Expense;
import org.fasttrackit.budgettrackerapi.exception.ResourceNotFoundException;
import org.fasttrackit.budgettrackerapi.service.ExpenseService;
import org.fasttrackit.budgettrackerapi.transfer.CreateExpenseIncurred;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpenseServiceIntegrationTests {

    @Autowired
    private ExpenseService expenseService;


    // test ca sa vedem ca putem adauga o cheltuiala pt metoda CREATE
    @Test
    public void  testCreateExpense_whenValidRequest_thenReturnExpenseWithId(){

        Expense expense = createExpense();

        //asigura-te ca nu valoarea nu e nula
        assertThat(expense, notNullValue());
        assertThat(expense.getId(), greaterThan(0L));
    }

    private Expense createExpense() {
        CreateExpenseIncurred incurred = new CreateExpenseIncurred();
        incurred.setName("Rent");
        incurred.setAmount(650);
        incurred.setQuantity(1);

        return expenseService.createExpense(incurred);
    }


    // test pt metoda de GET, vedem daca ne da Ch dupa un anumit ID, putem incerca daca ne da ceva daca cerem Ch cu ID = 0 si nu ar trebui sa ne dea nimic pt ca ID-urile incep de la 1
    // 1. facem testul pozitiv
    @Test(expected = ResourceNotFoundException.class)
    public void testShowExpense_whenExpenseNotFound_thenThrowResourceNotFoundException() throws ResourceNotFoundException {
        expenseService.showExpense(0);

    }

    // 2. facem si testul negativ
    @Test //test inseamna ca ii putem da si Run separat, nu e doar o simpla metoda
    public void testShowExpense_whenExistingId_thenReturnRequestedExpense() throws ResourceNotFoundException {
        Expense expense = createExpense();

        Expense retrievedExpense = expenseService.showExpense(expense.getId());

        assertThat(retrievedExpense.getId(), is(expense.getId()));
        assertThat(retrievedExpense.getName(), is(expense.getName()));


    }
}
