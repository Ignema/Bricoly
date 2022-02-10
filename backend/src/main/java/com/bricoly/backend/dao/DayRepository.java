package com.bricoly.backend.dao;

import com.bricoly.backend.domain.Day;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepository extends PagingAndSortingRepository<Day, Long> {
}