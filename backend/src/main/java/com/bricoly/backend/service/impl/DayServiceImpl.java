package com.bricoly.backend.service.impl;

import com.bricoly.backend.dao.DayRepository;
import com.bricoly.backend.domain.Day;
import com.bricoly.backend.dto.DayDTO;
import com.bricoly.backend.mapper.DayMapper;
import com.bricoly.backend.service.DayService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DayServiceImpl implements DayService {
    private final DayRepository repository;

    public DayServiceImpl(DayRepository repository) {
        this.repository = repository;
    }

    @Override
    public Day save(Day entity) {
        return repository.save(entity);
    }

    @Override
    public List<Day> save(List<Day> entities) {
        return (List<Day>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Day> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Day> findAll() {
        return (List<Day>) repository.findAll();
    }

    @Override
    public Page<Day> findAll(Pageable pageable) {
        Page<Day> entityPage = repository.findAll(pageable);
        List<Day> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Day update(Day entity, Long id) {
        Optional<Day> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}