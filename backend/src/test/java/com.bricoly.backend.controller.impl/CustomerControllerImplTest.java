package com.bricoly.backend.controller.impl;

import com.bricoly.backend.domain.Customer;
import com.bricoly.backend.mapper.CustomerMapper;
import com.bricoly.backend.mapper.ReferenceMapper;
import com.bricoly.backend.service.CustomerService;
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
public class CustomerControllerImplTest {
    //TODO: create the data Test generator class CustomerBuilder
    private static final String ENDPOINT_URL = "/customers";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private CustomerControllerImpl customerController;
    @MockBean
    private CustomerService customerService;
    @MockBean
    private CustomerMapper customerMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.customerController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(customerMapper.asDTOList(ArgumentMatchers.any())).thenReturn(CustomerBuilder.getListDTO());

        Mockito.when(customerService.findAll()).thenReturn(CustomerBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(customerMapper.asDTO(ArgumentMatchers.any())).thenReturn(CustomerBuilder.getDTO());

        Mockito.when(customerService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(CustomerBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(customerService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(customerService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(customerMapper.asEntity(ArgumentMatchers.any())).thenReturn(CustomerBuilder.getEntity());
        Mockito.when(customerService.save(ArgumentMatchers.any(Customer.class))).thenReturn(CustomerBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(CustomerBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(customerService, Mockito.times(1)).save(ArgumentMatchers.any(Customer.class));
        Mockito.verifyNoMoreInteractions(customerService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(customerMapper.asEntity(ArgumentMatchers.any())).thenReturn(CustomerBuilder.getEntity());
        Mockito.when(customerService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(CustomerBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(CustomerBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(customerService, Mockito.times(1)).update(ArgumentMatchers.any(Customer.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(customerService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(customerService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(customerService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(customerService);
    }