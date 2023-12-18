package term1exam.DevopsExam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc

public class MathcontrolIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDoMathEndpoint() throws Exception {
        String requestBody = "{\"operand1\": 5, \"operand2\": 4, \"operation\": \"*\"}";

        // Perform the POST request and validate the response
        mockMvc.perform(MockMvcRequestBuilders.post("/api/math/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.calcResponse").value(20.0));
    }

    }
