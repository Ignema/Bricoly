package com.bricoly.backend.dao;

import com.bricoly.backend.domain.Icon;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IconRepository extends PagingAndSortingRepository<Icon, Long> {
}