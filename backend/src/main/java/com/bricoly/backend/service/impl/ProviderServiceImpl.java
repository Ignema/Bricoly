package com.bricoly.backend.service.impl;

import com.bricoly.backend.dao.ProviderRepository;
import com.bricoly.backend.domain.Provider;
import com.bricoly.backend.dto.ProviderDTO;
import com.bricoly.backend.mapper.ProviderMapper;
import com.bricoly.backend.service.ProviderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository repository;

    public ProviderServiceImpl(ProviderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Provider save(Provider entity) {
        return repository.save(entity);
    }

    @Override
    public List<Provider> save(List<Provider> entities) {
        return (List<Provider>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Provider> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Provider> findAll() {
        return (List<Provider>) repository.findAll();
    }

    @Override
    public Page<Provider> findAll(Pageable pageable) {
        Page<Provider> entityPage = repository.findAll(pageable);
        List<Provider> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Provider update(Provider entity, Long id) {
        Optional<Provider> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}