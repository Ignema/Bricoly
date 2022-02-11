package com.bricoly.backend.service.impl;

import com.bricoly.backend.dao.IconRepository;
import com.bricoly.backend.domain.Icon;
import com.bricoly.backend.dto.IconDTO;
import com.bricoly.backend.mapper.IconMapper;
import com.bricoly.backend.service.IconService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IconServiceImpl implements IconService {
    private final IconRepository repository;

    public IconServiceImpl(IconRepository repository) {
        this.repository = repository;
    }

    @Override
    public Icon save(Icon entity) {
        return repository.save(entity);
    }

    @Override
    public List<Icon> save(List<Icon> entities) {
        return (List<Icon>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Icon> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Icon> findAll() {
        return (List<Icon>) repository.findAll();
    }

    @Override
    public Page<Icon> findAll(Pageable pageable) {
        Page<Icon> entityPage = repository.findAll(pageable);
        List<Icon> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Icon update(Icon entity, Long id) {
        Optional<Icon> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}