package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.ProviderController;
import com.bricoly.backend.dto.ProviderDTO;
import com.bricoly.backend.mapper.ProviderMapper;
import com.bricoly.backend.domain.Provider;
import com.bricoly.backend.service.ProviderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/provider")
@RestController
public class ProviderControllerImpl implements ProviderController {
    private final ProviderService providerService;
    private final ProviderMapper providerMapper;

    public ProviderControllerImpl(ProviderService providerService, ProviderMapper providerMapper) {
        this.providerService = providerService;
        this.providerMapper = providerMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProviderDTO save(@RequestBody ProviderDTO providerDTO) {
        Provider provider = providerMapper.asEntity(providerDTO);
        return providerMapper.asDTO(providerService.save(provider));
    }

    @Override
    @GetMapping("/{id}")
    public ProviderDTO findById(@PathVariable("id") Long id) {
        Provider provider = providerService.findById(id).orElse(null);
        return providerMapper.asDTO(provider);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        providerService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<ProviderDTO> list() {
        return providerMapper.asDTOList(providerService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<ProviderDTO> pageQuery(Pageable pageable) {
        Page<Provider> providerPage = providerService.findAll(pageable);
        List<ProviderDTO> dtoList = providerPage
                .stream()
                .map(providerMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, providerPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public ProviderDTO update(@RequestBody ProviderDTO providerDTO, @PathVariable("id") Long id) {
        Provider provider = providerMapper.asEntity(providerDTO);
        return providerMapper.asDTO(providerService.update(provider, id));
    }
}