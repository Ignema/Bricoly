package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.impl.CustomUtils;
import com.bricoly.backend.controller.impl.UserControllerImpl;
import com.bricoly.backend.domain.User;
import com.bricoly.backend.dto.UserDTO;
import com.bricoly.backend.mapper.ReferenceMapper;
import com.bricoly.backend.mapper.UserMapper;
import com.bricoly.backend.service.UserService;
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
public class UserControllerImplTest {
    //TODO: create the data Test generator class UserBuilder
    private static final String ENDPOINT_URL = "/users";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private UserControllerImpl userController;
    @MockBean
    private UserService userService;
    @MockBean
    private UserMapper userMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.userController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(userMapper.asDTOList(ArgumentMatchers.any())).thenReturn(UserBuilder.getListDTO());

        Mockito.when(userService.findAll()).thenReturn(UserBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(userMapper.asDTO(ArgumentMatchers.any())).thenReturn(UserBuilder.getDTO());

        Mockito.when(userService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(UserBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(userService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(userService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(userMapper.asEntity(ArgumentMatchers.any())).thenReturn(UserBuilder.getEntity());
        Mockito.when(userService.save(ArgumentMatchers.any(User.class))).thenReturn(UserBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(UserBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(userService, Mockito.times(1)).save(ArgumentMatchers.any(User.class));
        Mockito.verifyNoMoreInteractions(userService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(userMapper.asEntity(ArgumentMatchers.any())).thenReturn(UserBuilder.getEntity());
        Mockito.when(userService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(UserBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(UserBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(userService, Mockito.times(1)).update(ArgumentMatchers.any(User.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(userService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(userService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(userService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(userService);
    }