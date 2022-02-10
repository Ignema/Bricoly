package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.JobController;
import com.bricoly.backend.dto.JobDTO;
import com.bricoly.backend.mapper.JobMapper;
import com.bricoly.backend.domain.Job;
import com.bricoly.backend.service.JobService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/job")
@RestController
public class JobControllerImpl implements JobController {
    private final JobService jobService;
    private final JobMapper jobMapper;

    public JobControllerImpl(JobService jobService, JobMapper jobMapper) {
        this.jobService = jobService;
        this.jobMapper = jobMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JobDTO save(@RequestBody JobDTO jobDTO) {
        Job job = jobMapper.asEntity(jobDTO);
        return jobMapper.asDTO(jobService.save(job));
    }

    @Override
    @GetMapping("/{id}")
    public JobDTO findById(@PathVariable("id") Long id) {
        Job job = jobService.findById(id).orElse(null);
        return jobMapper.asDTO(job);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        jobService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<JobDTO> list() {
        return jobMapper.asDTOList(jobService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<JobDTO> pageQuery(Pageable pageable) {
        Page<Job> jobPage = jobService.findAll(pageable);
        List<JobDTO> dtoList = jobPage
                .stream()
                .map(jobMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, jobPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public JobDTO update(@RequestBody JobDTO jobDTO, @PathVariable("id") Long id) {
        Job job = jobMapper.asEntity(jobDTO);
        return jobMapper.asDTO(jobService.update(job, id));
    }
}