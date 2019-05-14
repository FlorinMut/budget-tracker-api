package org.fasttrackit.budgettrackerapi.persistence;

import org.fasttrackit.budgettrackerapi.domain.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

// Long is the wrapper class for primitive long
public interface UserRepository extends PagingAndSortingRepository<Expense, Long> {



}
