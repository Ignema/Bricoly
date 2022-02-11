package com.bricoly.backend.mapper;

import com.bricoly.backend.domain.Offer;
import com.bricoly.backend.dto.OfferDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OfferMapper extends GenericMapper<Offer, OfferDTO> {
    @Override
    @Mapping(target = "offer_id", ignore = true)
    Offer asEntity(OfferDTO dto);
}