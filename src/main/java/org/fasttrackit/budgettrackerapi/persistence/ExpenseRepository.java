package org.fasttrackit.budgettrackerapi.persistence;

import org.fasttrackit.budgettrackerapi.domain.Expense;
import org.springframework.data.repository.PagingAndSortingRepository;

// Long is the wrapper class for primitive long
public interface ExpenseRepository extends PagingAndSortingRepository<Expense, Long> {


}
