package com.bricoly.backend.mapper;

import com.bricoly.backend.domain.Job;
import com.bricoly.backend.dto.JobDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobMapper extends GenericMapper<Job, JobDTO> {
    @Override
    @Mapping(target = "job_id", ignore = true)
    Job asEntity(JobDTO dto);
}