package com.bricoly.backend.service.impl;

import com.bricoly.backend.dao.UserRepository;
import com.bricoly.backend.domain.User;
import com.bricoly.backend.service.CustomerService;
import com.bricoly.backend.service.ProviderService;
import com.bricoly.backend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final ProviderService providerService;

    public UserServiceImpl(UserRepository repository, ProviderService providerService) {
        this.repository = repository;
        this.providerService = providerService;
    }

    @Override
    public User save(User entity) {
        return repository.save(entity);
    }

    @Override
    public List<User> save(List<User> entities) {
        return (List<User>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        Page<User> entityPage = repository.findAll(pageable);
        List<User> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public User update(User entity, Long id) {
        Optional<User> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) { return repository.findByEmail(email); }

    @Override
    public Optional<User> checkCredentials(String email, String password) { return repository.checkCredentials(email, password); }

    @Override
    public String getUserType(Long user_id) {
        if(providerService.findAll().stream().anyMatch(provider -> Objects.equals(provider.getUser().getUser_id(), user_id))){
            return "provider";
        } else {
            return "customer";
        }
    }


}