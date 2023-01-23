package org.profitsoft.fifth_task;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.profitsoft.fifth_task.dto.RestResponse;
import org.profitsoft.fifth_task.model.Item;
import org.profitsoft.fifth_task.repository.ItemRepository;
import org.profitsoft.fifth_task.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = FifthTaskApplication.class)
@AutoConfigureMockMvc
class ItemControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @AfterEach
    public void afterEach() {
        itemRepository.deleteAll();
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateItem() throws Exception {
        String name = "testName";
        int storeId = 1;

        String body = """
                {
                "name": "%s",
                "storeId":"%s"
                """.formatted(name, storeId);

        MvcResult mvcResult = mvc.perform(post("/api/items/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
        .andExpect(status().is2xxSuccessful())
                .andReturn();

        RestResponse restResponse = parseResponse(mvcResult, RestResponse.class);
        int itemId = Integer.parseInt(restResponse.getResult());
        assertThat(itemId).isGreaterThanOrEqualTo(1);

        Item item = itemRepository.get(itemId);
        assertThat(item).isNotNull();
        assertThat(item.getName()).isEqualTo(name);
        assertThat(item.getStore().getId()).isEqualTo(storeId);

    }

    private <T>T parseResponse(MvcResult mvcResult, Class<T> c){
        try{
            return objectMapper.readValue(mvcResult.getResponse().getContentAsString(), c);
        } catch (JsonProcessingException | UnsupportedEncodingException e) {
            throw new RuntimeException("Error parsing json", e);
        }
    }
}
