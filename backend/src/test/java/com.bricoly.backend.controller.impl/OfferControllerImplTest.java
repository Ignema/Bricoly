package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.impl.CustomUtils;
import com.bricoly.backend.controller.impl.OfferControllerImpl;
import com.bricoly.backend.domain.Offer;
import com.bricoly.backend.dto.OfferDTO;
import com.bricoly.backend.mapper.OfferMapper;
import com.bricoly.backend.mapper.ReferenceMapper;
import com.bricoly.backend.service.OfferService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class OfferControllerImplTest {
    //TODO: create the data Test generator class OfferBuilder
    private static final String ENDPOINT_URL = "/offers";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private OfferControllerImpl offerController;
    @MockBean
    private OfferService offerService;
    @MockBean
    private OfferMapper offerMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.offerController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(offerMapper.asDTOList(ArgumentMatchers.any())).thenReturn(OfferBuilder.getListDTO());

        Mockito.when(offerService.findAll()).thenReturn(OfferBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(offerMapper.asDTO(ArgumentMatchers.any())).thenReturn(OfferBuilder.getDTO());

        Mockito.when(offerService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(OfferBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(offerService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(offerService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(offerMapper.asEntity(ArgumentMatchers.any())).thenReturn(OfferBuilder.getEntity());
        Mockito.when(offerService.save(ArgumentMatchers.any(Offer.class))).thenReturn(OfferBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(OfferBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(offerService, Mockito.times(1)).save(ArgumentMatchers.any(Offer.class));
        Mockito.verifyNoMoreInteractions(offerService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(offerMapper.asEntity(ArgumentMatchers.any())).thenReturn(OfferBuilder.getEntity());
        Mockito.when(offerService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(OfferBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(OfferBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(offerService, Mockito.times(1)).update(ArgumentMatchers.any(Offer.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(offerService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(offerService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(offerService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(offerService);
    }