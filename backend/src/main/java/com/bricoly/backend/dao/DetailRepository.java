package com.bricoly.backend.dao;

import com.bricoly.backend.domain.Detail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends PagingAndSortingRepository<Detail, Long> {
}