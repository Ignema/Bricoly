package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.SkillController;
import com.bricoly.backend.dto.SkillDTO;
import com.bricoly.backend.mapper.SkillMapper;
import com.bricoly.backend.domain.Skill;
import com.bricoly.backend.service.SkillService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/skill")
@RestController
public class SkillControllerImpl implements SkillController {
    private final SkillService skillService;
    private final SkillMapper skillMapper;

    public SkillControllerImpl(SkillService skillService, SkillMapper skillMapper) {
        this.skillService = skillService;
        this.skillMapper = skillMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SkillDTO save(@RequestBody SkillDTO skillDTO) {
        Skill skill = skillMapper.asEntity(skillDTO);
        return skillMapper.asDTO(skillService.save(skill));
    }

    @Override
    @GetMapping("/{id}")
    public SkillDTO findById(@PathVariable("id") Long id) {
        Skill skill = skillService.findById(id).orElse(null);
        return skillMapper.asDTO(skill);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        skillService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<SkillDTO> list() {
        return skillMapper.asDTOList(skillService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<SkillDTO> pageQuery(Pageable pageable) {
        Page<Skill> skillPage = skillService.findAll(pageable);
        List<SkillDTO> dtoList = skillPage
                .stream()
                .map(skillMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, skillPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public SkillDTO update(@RequestBody SkillDTO skillDTO, @PathVariable("id") Long id) {
        Skill skill = skillMapper.asEntity(skillDTO);
        return skillMapper.asDTO(skillService.update(skill, id));
    }
}