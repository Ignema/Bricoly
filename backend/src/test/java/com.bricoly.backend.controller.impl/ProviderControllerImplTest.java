package com.bricoly.backend.controller.impl;

import com.bricoly.backend.domain.Provider;
import com.bricoly.backend.mapper.ProviderMapper;
import com.bricoly.backend.mapper.ReferenceMapper;
import com.bricoly.backend.service.ProviderService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ProviderControllerImplTest {
    //TODO: create the data Test generator class ProviderBuilder
    private static final String ENDPOINT_URL = "/providers";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private ProviderControllerImpl providerController;
    @MockBean
    private ProviderService providerService;
    @MockBean
    private ProviderMapper providerMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.providerController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(providerMapper.asDTOList(ArgumentMatchers.any())).thenReturn(ProviderBuilder.getListDTO());

        Mockito.when(providerService.findAll()).thenReturn(ProviderBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(providerMapper.asDTO(ArgumentMatchers.any())).thenReturn(ProviderBuilder.getDTO());

        Mockito.when(providerService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(ProviderBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(providerService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(providerService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(providerMapper.asEntity(ArgumentMatchers.any())).thenReturn(ProviderBuilder.getEntity());
        Mockito.when(providerService.save(ArgumentMatchers.any(Provider.class))).thenReturn(ProviderBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(ProviderBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(providerService, Mockito.times(1)).save(ArgumentMatchers.any(Provider.class));
        Mockito.verifyNoMoreInteractions(providerService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(providerMapper.asEntity(ArgumentMatchers.any())).thenReturn(ProviderBuilder.getEntity());
        Mockito.when(providerService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(ProviderBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(ProviderBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(providerService, Mockito.times(1)).update(ArgumentMatchers.any(Provider.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(providerService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(providerService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(providerService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(providerService);
    }