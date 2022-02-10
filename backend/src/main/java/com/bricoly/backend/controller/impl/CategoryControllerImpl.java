package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.CategoryController;
import com.bricoly.backend.dto.CategoryDTO;
import com.bricoly.backend.mapper.CategoryMapper;
import com.bricoly.backend.domain.Category;
import com.bricoly.backend.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/category")
@RestController
public class CategoryControllerImpl implements CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryControllerImpl(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO save(@RequestBody CategoryDTO categoryDTO) {
        Category category = categoryMapper.asEntity(categoryDTO);
        return categoryMapper.asDTO(categoryService.save(category));
    }

    @Override
    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id).orElse(null);
        return categoryMapper.asDTO(category);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        categoryService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<CategoryDTO> list() {
        return categoryMapper.asDTOList(categoryService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<CategoryDTO> pageQuery(Pageable pageable) {
        Page<Category> categoryPage = categoryService.findAll(pageable);
        List<CategoryDTO> dtoList = categoryPage
                .stream()
                .map(categoryMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, categoryPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public CategoryDTO update(@RequestBody CategoryDTO categoryDTO, @PathVariable("id") Long id) {
        Category category = categoryMapper.asEntity(categoryDTO);
        return categoryMapper.asDTO(categoryService.update(category, id));
    }
}