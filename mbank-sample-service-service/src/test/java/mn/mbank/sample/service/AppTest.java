package mn.mbank.sample.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import mn.mbank.sample.service.spec.model.ReqSample1;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {

    private static final ObjectMapper mapper = new ObjectMapper();

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void getSample() throws Exception {
        mockMvc.perform(get("/v1.0/sample").param("id","test1"))
                .andExpect(status().isOk());
    }

    @Test
    public void postSample() throws Exception {
        ReqSample1 req = new ReqSample1();
        req.setItem1("aaaa");
        req.setItem2("bbbb");

        mockMvc.perform(post("/v1.0/sample")
                        .content(req.toString())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isAccepted());
    }

}
