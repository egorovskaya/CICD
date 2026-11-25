package ru.netology.ToDoList;

import com.google.gson.Gson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;



@SpringBootTest
@AutoConfigureMockMvc
class RestControllerListTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testGet() throws Exception {
        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"title\":\"Homework\",\"completed\":false,\"createdAt\":\"2026-11-18\"}"));

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk());

    }

    @Test
    public void testPost() throws Exception {
        mockMvc.perform(post("/tasks")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"id\":2,\"title\":\"Homework\",\"completed\":false,\"createdAt\":\"2026-11-18\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testPut() throws Exception {
        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":3,\"title\":\"Homework\",\"completed\":false,\"createdAt\":\"2026-11-18\"}"));

        mockMvc.perform(put("/tasks/3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":3,\"title\":\"Homework\",\"completed\":true,\"createdAt\":\"2026-11-18\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":4,\"title\":\"Homework\",\"completed\":false,\"createdAt\":\"2026-11-18\"}"));

        mockMvc.perform(delete("/tasks/4"))
                .andExpect(status().isOk());
    }
}