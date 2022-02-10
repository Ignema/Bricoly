package com.bricoly.backend.mapper;

import com.bricoly.backend.dto.JobDTO;
import com.bricoly.backend.domain.Job;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface JobMapper extends GenericMapper<Job, JobDTO> {
    @Override
    @Mapping(target = "job_id", ignore = false)
    Job asEntity(JobDTO dto);
}