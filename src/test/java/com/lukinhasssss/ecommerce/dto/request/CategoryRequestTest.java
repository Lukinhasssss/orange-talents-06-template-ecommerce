package com.lukinhasssss.ecommerce.dto.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoryRequestTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper jsonMapper;

    @Test
    void shouldRegisterCategoryWithoutMotherCategory() throws Exception {
        mockMvc.perform(post("/categories")
        .contentType(MediaType.APPLICATION_JSON)
        .content(toJson(new CategoryRequest("Celulares", null))))
        .andExpect(status().isOk());
    }

    @Test
    void shouldRegisterCategoryWithMotherCategory() throws Exception {
        mockMvc.perform(post("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(new CategoryRequest("Smartphones", 2L))))
                .andExpect(status().isOk());
    }

    private String toJson(CategoryRequest request) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(request);
    }

}
