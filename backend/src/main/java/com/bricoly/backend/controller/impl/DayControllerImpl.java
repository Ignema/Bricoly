package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.DayController;
import com.bricoly.backend.dto.DayDTO;
import com.bricoly.backend.mapper.DayMapper;
import com.bricoly.backend.domain.Day;
import com.bricoly.backend.service.DayService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/day")
@RestController
public class DayControllerImpl implements DayController {
    private final DayService dayService;
    private final DayMapper dayMapper;

    public DayControllerImpl(DayService dayService, DayMapper dayMapper) {
        this.dayService = dayService;
        this.dayMapper = dayMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DayDTO save(@RequestBody DayDTO dayDTO) {
        Day day = dayMapper.asEntity(dayDTO);
        return dayMapper.asDTO(dayService.save(day));
    }

    @Override
    @GetMapping("/{id}")
    public DayDTO findById(@PathVariable("id") Long id) {
        Day day = dayService.findById(id).orElse(null);
        return dayMapper.asDTO(day);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        dayService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<DayDTO> list() {
        return dayMapper.asDTOList(dayService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<DayDTO> pageQuery(Pageable pageable) {
        Page<Day> dayPage = dayService.findAll(pageable);
        List<DayDTO> dtoList = dayPage
                .stream()
                .map(dayMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, dayPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public DayDTO update(@RequestBody DayDTO dayDTO, @PathVariable("id") Long id) {
        Day day = dayMapper.asEntity(dayDTO);
        return dayMapper.asDTO(dayService.update(day, id));
    }
}