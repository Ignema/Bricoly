package com.bricoly.backend.controller.impl;

import com.bricoly.backend.controller.impl.CategoryControllerImpl;
import com.bricoly.backend.controller.impl.CustomUtils;
import com.bricoly.backend.domain.Category;
import com.bricoly.backend.dto.CategoryDTO;
import com.bricoly.backend.mapper.CategoryMapper;
import com.bricoly.backend.mapper.ReferenceMapper;
import com.bricoly.backend.service.CategoryService;
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
public class CategoryControllerImplTest {
    //TODO: create the data Test generator class CategoryBuilder
    private static final String ENDPOINT_URL = "/categorys";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private CategoryControllerImpl categoryController;
    @MockBean
    private CategoryService categoryService;
    @MockBean
    private CategoryMapper categoryMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.categoryController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(categoryMapper.asDTOList(ArgumentMatchers.any())).thenReturn(CategoryBuilder.getListDTO());

        Mockito.when(categoryService.findAll()).thenReturn(CategoryBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(categoryMapper.asDTO(ArgumentMatchers.any())).thenReturn(CategoryBuilder.getDTO());

        Mockito.when(categoryService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(CategoryBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(categoryService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(categoryService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(categoryMapper.asEntity(ArgumentMatchers.any())).thenReturn(CategoryBuilder.getEntity());
        Mockito.when(categoryService.save(ArgumentMatchers.any(Category.class))).thenReturn(CategoryBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(CategoryBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(categoryService, Mockito.times(1)).save(ArgumentMatchers.any(Category.class));
        Mockito.verifyNoMoreInteractions(categoryService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(categoryMapper.asEntity(ArgumentMatchers.any())).thenReturn(CategoryBuilder.getEntity());
        Mockito.when(categoryService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(CategoryBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(CategoryBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(categoryService, Mockito.times(1)).update(ArgumentMatchers.any(Category.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(categoryService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(categoryService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(categoryService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(categoryService);
    }