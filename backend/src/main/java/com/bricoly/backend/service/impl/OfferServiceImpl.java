package com.bricoly.backend.service.impl;

import com.bricoly.backend.dao.OfferRepository;
import com.bricoly.backend.domain.Offer;
import com.bricoly.backend.dto.OfferDTO;
import com.bricoly.backend.mapper.OfferMapper;
import com.bricoly.backend.service.OfferService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {
    private final OfferRepository repository;

    public OfferServiceImpl(OfferRepository repository) {
        this.repository = repository;
    }

    @Override
    public Offer save(Offer entity) {
        return repository.save(entity);
    }

    @Override
    public List<Offer> save(List<Offer> entities) {
        return (List<Offer>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Offer> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Offer> findAll() {
        return (List<Offer>) repository.findAll();
    }

    @Override
    public Page<Offer> findAll(Pageable pageable) {
        Page<Offer> entityPage = repository.findAll(pageable);
        List<Offer> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Offer update(Offer entity, Long id) {
        Optional<Offer> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}