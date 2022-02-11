package com.bricoly.backend.service.impl;

import com.bricoly.backend.dao.SkillRepository;
import com.bricoly.backend.domain.Skill;
import com.bricoly.backend.dto.SkillDTO;
import com.bricoly.backend.mapper.SkillMapper;
import com.bricoly.backend.service.SkillService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {
    private final SkillRepository repository;

    public SkillServiceImpl(SkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public Skill save(Skill entity) {
        return repository.save(entity);
    }

    @Override
    public List<Skill> save(List<Skill> entities) {
        return (List<Skill>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Skill> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Skill> findAll() {
        return (List<Skill>) repository.findAll();
    }

    @Override
    public Page<Skill> findAll(Pageable pageable) {
        Page<Skill> entityPage = repository.findAll(pageable);
        List<Skill> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Skill update(Skill entity, Long id) {
        Optional<Skill> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}