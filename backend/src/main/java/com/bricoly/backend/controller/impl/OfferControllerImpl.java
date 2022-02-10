package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.OfferController;
import com.bricoly.backend.dto.OfferDTO;
import com.bricoly.backend.mapper.OfferMapper;
import com.bricoly.backend.domain.Offer;
import com.bricoly.backend.service.OfferService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/offer")
@RestController
public class OfferControllerImpl implements OfferController {
    private final OfferService offerService;
    private final OfferMapper offerMapper;

    public OfferControllerImpl(OfferService offerService, OfferMapper offerMapper) {
        this.offerService = offerService;
        this.offerMapper = offerMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OfferDTO save(@RequestBody OfferDTO offerDTO) {
        Offer offer = offerMapper.asEntity(offerDTO);
        return offerMapper.asDTO(offerService.save(offer));
    }

    @Override
    @GetMapping("/{id}")
    public OfferDTO findById(@PathVariable("id") Long id) {
        Offer offer = offerService.findById(id).orElse(null);
        return offerMapper.asDTO(offer);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        offerService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<OfferDTO> list() {
        return offerMapper.asDTOList(offerService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<OfferDTO> pageQuery(Pageable pageable) {
        Page<Offer> offerPage = offerService.findAll(pageable);
        List<OfferDTO> dtoList = offerPage
                .stream()
                .map(offerMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, offerPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public OfferDTO update(@RequestBody OfferDTO offerDTO, @PathVariable("id") Long id) {
        Offer offer = offerMapper.asEntity(offerDTO);
        return offerMapper.asDTO(offerService.update(offer, id));
    }
}