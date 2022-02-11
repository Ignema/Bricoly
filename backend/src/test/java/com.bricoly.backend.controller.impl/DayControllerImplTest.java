package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.impl.CustomUtils;
import com.bricoly.backend.controller.impl.DayControllerImpl;
import com.bricoly.backend.domain.Day;
import com.bricoly.backend.dto.DayDTO;
import com.bricoly.backend.mapper.DayMapper;
import com.bricoly.backend.mapper.ReferenceMapper;
import com.bricoly.backend.service.DayService;
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
public class DayControllerImplTest {
    //TODO: create the data Test generator class DayBuilder
    private static final String ENDPOINT_URL = "/days";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private DayControllerImpl dayController;
    @MockBean
    private DayService dayService;
    @MockBean
    private DayMapper dayMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.dayController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(dayMapper.asDTOList(ArgumentMatchers.any())).thenReturn(DayBuilder.getListDTO());

        Mockito.when(dayService.findAll()).thenReturn(DayBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(dayMapper.asDTO(ArgumentMatchers.any())).thenReturn(DayBuilder.getDTO());

        Mockito.when(dayService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(DayBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(dayService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(dayService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(dayMapper.asEntity(ArgumentMatchers.any())).thenReturn(DayBuilder.getEntity());
        Mockito.when(dayService.save(ArgumentMatchers.any(Day.class))).thenReturn(DayBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(DayBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(dayService, Mockito.times(1)).save(ArgumentMatchers.any(Day.class));
        Mockito.verifyNoMoreInteractions(dayService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(dayMapper.asEntity(ArgumentMatchers.any())).thenReturn(DayBuilder.getEntity());
        Mockito.when(dayService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(DayBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(DayBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(dayService, Mockito.times(1)).update(ArgumentMatchers.any(Day.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(dayService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(dayService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(dayService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(dayService);
    }