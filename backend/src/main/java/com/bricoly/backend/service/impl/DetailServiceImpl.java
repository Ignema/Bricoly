package com.bricoly.backend.service.impl;

import com.bricoly.backend.dao.DetailRepository;
import com.bricoly.backend.domain.Detail;
import com.bricoly.backend.service.DetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DetailServiceImpl implements DetailService {
    private final DetailRepository repository;

    public DetailServiceImpl(DetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public Detail save(Detail entity) {
        return repository.save(entity);
    }

    @Override
    public List<Detail> save(List<Detail> entities) {
        return (List<Detail>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Detail> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Detail> findAll() {
        return (List<Detail>) repository.findAll();
    }

    @Override
    public Page<Detail> findAll(Pageable pageable) {
        Page<Detail> entityPage = repository.findAll(pageable);
        List<Detail> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Detail update(Detail entity, Long id) {
        Optional<Detail> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}