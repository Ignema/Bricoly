package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.IconController;
import com.bricoly.backend.dto.IconDTO;
import com.bricoly.backend.mapper.IconMapper;
import com.bricoly.backend.domain.Icon;
import com.bricoly.backend.service.IconService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/icon")
@RestController
public class IconControllerImpl implements IconController {
    private final IconService iconService;
    private final IconMapper iconMapper;

    public IconControllerImpl(IconService iconService, IconMapper iconMapper) {
        this.iconService = iconService;
        this.iconMapper = iconMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IconDTO save(@RequestBody IconDTO iconDTO) {
        Icon icon = iconMapper.asEntity(iconDTO);
        return iconMapper.asDTO(iconService.save(icon));
    }

    @Override
    @GetMapping("/{id}")
    public IconDTO findById(@PathVariable("id") Long id) {
        Icon icon = iconService.findById(id).orElse(null);
        return iconMapper.asDTO(icon);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        iconService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<IconDTO> list() {
        return iconMapper.asDTOList(iconService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<IconDTO> pageQuery(Pageable pageable) {
        Page<Icon> iconPage = iconService.findAll(pageable);
        List<IconDTO> dtoList = iconPage
                .stream()
                .map(iconMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, iconPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public IconDTO update(@RequestBody IconDTO iconDTO, @PathVariable("id") Long id) {
        Icon icon = iconMapper.asEntity(iconDTO);
        return iconMapper.asDTO(iconService.update(icon, id));
    }
}