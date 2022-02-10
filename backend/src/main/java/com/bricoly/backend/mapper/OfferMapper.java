package com.bricoly.backend.mapper;

import com.bricoly.backend.dto.OfferDTO;
import com.bricoly.backend.domain.Offer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface OfferMapper extends GenericMapper<Offer, OfferDTO> {
    @Override
    @Mapping(target = "offer_id", ignore = false)
    Offer asEntity(OfferDTO dto);
}