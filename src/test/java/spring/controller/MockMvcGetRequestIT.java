package spring.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcGetRequestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void get_response_body_string() throws Exception {
        mockMvc.perform(get("/index").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Index Page"));
    }

    // {"item 1", "item 2", "item 3"} 测试返回的List数据结果
    @Test
    void get_response_list_string() throws Exception {
        mockMvc.perform(get("/list").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$[0]").value("item 1"))
                .andExpect((ResultMatcher) jsonPath("$.length()").value(3))
                .andExpect(content().json("[\"item 1\", \"item 2\", \"item 3\"]"));
    }

    // $[0].name 获取返回的JSON数据列表的第一个数据的name属性
    @Test
    public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {
        // createTestEmployee("bob");
        mockMvc.perform(get("/api/employees").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$[0].name").value("bob"));
    }

    // TODO: 使用MockMvcResultMatchers来匹配复杂的返回结果(JSON对象)
    // https://www.tabnine.com/code/java/methods/
    @Test
    public void givenEmployeeNames_thenStatus200() throws Exception {
        mockMvc.perform(get("/v1/resource/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].date").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].type").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].element.list").value(new ArrayList<>()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].element.id").value("42"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].element.*", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].*", hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", hasSize(1)));
    }
}
