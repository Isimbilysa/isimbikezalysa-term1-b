package term1exam.DevopsExam;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControlE2eTest {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testDoMathEndpoint() {
        String url = "http://localhost:" + port + "/api/math/doMath";  // Corrected endpoint
        DoMathReq request = new DoMathReq(5, 4, "*");  // Prepare a sample request

        // Perform the POST request and receive a ResponseEntity
        ApiRes response = restTemplate.postForObject(url, request, ApiRes.class);

        // Assert
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(20.0, ((Map<String, Double>) response.getData()).get("calcResponse"));
    }
}