package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.impl.CustomUtils;
import com.bricoly.backend.controller.impl.DetailControllerImpl;
import com.bricoly.backend.domain.Detail;
import com.bricoly.backend.dto.DetailDTO;
import com.bricoly.backend.mapper.DetailMapper;
import com.bricoly.backend.mapper.ReferenceMapper;
import com.bricoly.backend.service.DetailService;
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
public class DetailControllerImplTest {
    //TODO: create the data Test generator class DetailBuilder
    private static final String ENDPOINT_URL = "/details";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private DetailControllerImpl detailController;
    @MockBean
    private DetailService detailService;
    @MockBean
    private DetailMapper detailMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.detailController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(detailMapper.asDTOList(ArgumentMatchers.any())).thenReturn(DetailBuilder.getListDTO());

        Mockito.when(detailService.findAll()).thenReturn(DetailBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(detailMapper.asDTO(ArgumentMatchers.any())).thenReturn(DetailBuilder.getDTO());

        Mockito.when(detailService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(DetailBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(detailService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(detailService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(detailMapper.asEntity(ArgumentMatchers.any())).thenReturn(DetailBuilder.getEntity());
        Mockito.when(detailService.save(ArgumentMatchers.any(Detail.class))).thenReturn(DetailBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(DetailBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(detailService, Mockito.times(1)).save(ArgumentMatchers.any(Detail.class));
        Mockito.verifyNoMoreInteractions(detailService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(detailMapper.asEntity(ArgumentMatchers.any())).thenReturn(DetailBuilder.getEntity());
        Mockito.when(detailService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(DetailBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(DetailBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(detailService, Mockito.times(1)).update(ArgumentMatchers.any(Detail.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(detailService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(detailService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(detailService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(detailService);
    }