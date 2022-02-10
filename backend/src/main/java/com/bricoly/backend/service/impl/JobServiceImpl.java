package com.bricoly.backend.service.impl;

import com.bricoly.backend.dao.JobRepository;
import com.bricoly.backend.domain.Job;
import com.bricoly.backend.service.JobService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JobServiceImpl implements JobService {
    private final JobRepository repository;

    public JobServiceImpl(JobRepository repository) {
        this.repository = repository;
    }

    @Override
    public Job save(Job entity) {
        return repository.save(entity);
    }

    @Override
    public List<Job> save(List<Job> entities) {
        return (List<Job>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Job> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Job> findAll() {
        return (List<Job>) repository.findAll();
    }

    @Override
    public Page<Job> findAll(Pageable pageable) {
        Page<Job> entityPage = repository.findAll(pageable);
        List<Job> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Job update(Job entity, Long id) {
        Optional<Job> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}