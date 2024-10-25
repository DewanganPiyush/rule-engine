package com.example.ruleengine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = RuleEngineApplication.class)
@AutoConfigureMockMvc
public class RuleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RuleRepository ruleRepository;

    @BeforeEach
    void setUp() {
        ruleRepository.deleteAll(); // Clear the database before each test
    }

    @Test
    void createRule() throws Exception {
        String ruleJson = "{\"ruleString\": \"((age > 30 AND department = 'Sales'))\"}";

        mockMvc.perform(post("/rules")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ruleJson))
                .andExpect(status().isOk());
    }
}
