package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.impl.CustomUtils;
import com.bricoly.backend.controller.impl.SkillControllerImpl;
import com.bricoly.backend.domain.Skill;
import com.bricoly.backend.dto.SkillDTO;
import com.bricoly.backend.mapper.ReferenceMapper;
import com.bricoly.backend.mapper.SkillMapper;
import com.bricoly.backend.service.SkillService;
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
public class SkillControllerImplTest {
    //TODO: create the data Test generator class SkillBuilder
    private static final String ENDPOINT_URL = "/skills";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private SkillControllerImpl skillController;
    @MockBean
    private SkillService skillService;
    @MockBean
    private SkillMapper skillMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.skillController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(skillMapper.asDTOList(ArgumentMatchers.any())).thenReturn(SkillBuilder.getListDTO());

        Mockito.when(skillService.findAll()).thenReturn(SkillBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(skillMapper.asDTO(ArgumentMatchers.any())).thenReturn(SkillBuilder.getDTO());

        Mockito.when(skillService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(SkillBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(skillService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(skillService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(skillMapper.asEntity(ArgumentMatchers.any())).thenReturn(SkillBuilder.getEntity());
        Mockito.when(skillService.save(ArgumentMatchers.any(Skill.class))).thenReturn(SkillBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(SkillBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(skillService, Mockito.times(1)).save(ArgumentMatchers.any(Skill.class));
        Mockito.verifyNoMoreInteractions(skillService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(skillMapper.asEntity(ArgumentMatchers.any())).thenReturn(SkillBuilder.getEntity());
        Mockito.when(skillService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(SkillBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(SkillBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(skillService, Mockito.times(1)).update(ArgumentMatchers.any(Skill.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(skillService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(skillService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(skillService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(skillService);
    }