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
        Task task = new Task(1, "Homework", false, "18.11.2026");
        mockMvc.perform(post("/tasks").content(task.toString()));

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk());

    }

    @Test
    public void testPost() throws Exception {
        Task task = new Task(2, "Homework", false, "18.11.2026");
        Gson gson = new Gson();
        String jsonContent = gson.toJson(task);

        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void testPut() throws Exception {
        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":0,\"title\":\"Homework\",\"completed\":false,\"createdAt\":\"2026-11-18\"}"));

        mockMvc.perform(put("/tasks/0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":0,\"title\":\"Homework\",\"completed\":true,\"createdAt\":\"2026-11-18\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":0,\"title\":\"Homework\",\"completed\":false,\"createdAt\":\"2026-11-18\"}"));

        mockMvc.perform(delete("/tasks/0"))
                .andExpect(status().isOk());
    }
//                .andExpect(jsonPath("$.title").value("New Updated Title"))
//                .andExpect(jsonPath("$.completed").value(true));
        //Task task = new Task(1, "Homework", false, "18.11.2026");
        //mockMvc.perform(post("/tasks").content(task.toString()));

//        Task task2 = new Task(1, "Homework", true, "18.11.2026");
//        mockMvc.perform(put("/tasks/1").content(task2.toString()))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void testDelete() throws Exception {
//        //Task task = new Task(1, "Homework", false, "18.11.2026");
//        //mockMvc.perform(post("/tasks").content(task.toString()));
//
//        mockMvc.perform(delete("/tasks/1"))
//                .andExpect(status().isOk());
//                //.andExpect(content().string(""));
//    }
}