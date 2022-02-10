package com.rs.api_querydsl.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("local")
@AutoConfigureMockMvc
@Utf8Encoding
class ProductControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testProducts() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/product/products")
//            .param("keyword", "test")
            .param("sort", "1")
            .param("page", "1")
            .param("rows", "4")
            .param("keyword", "웰릭스")
//            .param("category", "RTPD031")
            .accept(MediaType.APPLICATION_JSON);

        mvc.perform(builder)
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.data.products[0].productName", Matchers.containsString("웰릭스")));
//            .andExpect(jsonPath("$.data.products[0].category", Matchers.is("RTPD0015")));
//            .andExpect(jsonPath("$.data.products", Matchers.hasSize(2)));
    }

    @Test
    public void testProduct() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/product/product/{productId}", 262)
            .accept(MediaType.APPLICATION_JSON);

        mvc.perform(builder)
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCategoryTree() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/product/categories")
            .accept(MediaType.APPLICATION_JSON);

        mvc.perform(builder)
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

}