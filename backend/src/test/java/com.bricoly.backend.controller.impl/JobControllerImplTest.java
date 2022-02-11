package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.impl.CustomUtils;
import com.bricoly.backend.controller.impl.JobControllerImpl;
import com.bricoly.backend.domain.Job;
import com.bricoly.backend.dto.JobDTO;
import com.bricoly.backend.mapper.JobMapper;
import com.bricoly.backend.mapper.ReferenceMapper;
import com.bricoly.backend.service.JobService;
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
public class JobControllerImplTest {
    //TODO: create the data Test generator class JobBuilder
    private static final String ENDPOINT_URL = "/jobs";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private JobControllerImpl jobController;
    @MockBean
    private JobService jobService;
    @MockBean
    private JobMapper jobMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.jobController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(jobMapper.asDTOList(ArgumentMatchers.any())).thenReturn(JobBuilder.getListDTO());

        Mockito.when(jobService.findAll()).thenReturn(JobBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(jobMapper.asDTO(ArgumentMatchers.any())).thenReturn(JobBuilder.getDTO());

        Mockito.when(jobService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(JobBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(jobService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(jobService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(jobMapper.asEntity(ArgumentMatchers.any())).thenReturn(JobBuilder.getEntity());
        Mockito.when(jobService.save(ArgumentMatchers.any(Job.class))).thenReturn(JobBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(JobBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(jobService, Mockito.times(1)).save(ArgumentMatchers.any(Job.class));
        Mockito.verifyNoMoreInteractions(jobService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(jobMapper.asEntity(ArgumentMatchers.any())).thenReturn(JobBuilder.getEntity());
        Mockito.when(jobService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(JobBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(JobBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(jobService, Mockito.times(1)).update(ArgumentMatchers.any(Job.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(jobService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(jobService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(jobService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(jobService);
    }