package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.impl.CustomUtils;
import com.bricoly.backend.controller.impl.IconControllerImpl;
import com.bricoly.backend.domain.Icon;
import com.bricoly.backend.dto.IconDTO;
import com.bricoly.backend.mapper.IconMapper;
import com.bricoly.backend.mapper.ReferenceMapper;
import com.bricoly.backend.service.IconService;
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
public class IconControllerImplTest {
    //TODO: create the data Test generator class IconBuilder
    private static final String ENDPOINT_URL = "/icons";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private IconControllerImpl iconController;
    @MockBean
    private IconService iconService;
    @MockBean
    private IconMapper iconMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.iconController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(iconMapper.asDTOList(ArgumentMatchers.any())).thenReturn(IconBuilder.getListDTO());

        Mockito.when(iconService.findAll()).thenReturn(IconBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(iconMapper.asDTO(ArgumentMatchers.any())).thenReturn(IconBuilder.getDTO());

        Mockito.when(iconService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(IconBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(iconService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(iconService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(iconMapper.asEntity(ArgumentMatchers.any())).thenReturn(IconBuilder.getEntity());
        Mockito.when(iconService.save(ArgumentMatchers.any(Icon.class))).thenReturn(IconBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(IconBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(iconService, Mockito.times(1)).save(ArgumentMatchers.any(Icon.class));
        Mockito.verifyNoMoreInteractions(iconService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(iconMapper.asEntity(ArgumentMatchers.any())).thenReturn(IconBuilder.getEntity());
        Mockito.when(iconService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(IconBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(IconBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(iconService, Mockito.times(1)).update(ArgumentMatchers.any(Icon.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(iconService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(iconService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(iconService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(iconService);
    }