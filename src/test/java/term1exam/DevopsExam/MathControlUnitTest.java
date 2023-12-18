package term1exam.DevopsExam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MathControllerUnitTest {

    @Mock
    private MathImpl mathImpl;

    @Mock
    private MathOp mathOp;

    @InjectMocks
    private MathContro mathContro; // Corrected class name

    @Test
    void testDoMath_ValidOperation_ReturnsSuccessResponse() throws InvalidOpException {
        // Arrange
        DoMathReq request = new DoMathReq(5, 4, "*");
        when(mathImpl.doMath(5, 4, "*")).thenReturn(20.0);

        // Act
        ResponseEntity<ApiRes> responseEntity = mathContro.create(request); // Corrected method name

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(20.0, ((Map<String, Double>) responseEntity.getBody().getData()).get("calcResponse"));
        verify(mathImpl, times(1)).doMath(5, 4, "*");
    }

    @Test
    void testDoMath_InvalidOperation_ReturnsErrorResponse() throws InvalidOpException {
        // Arrange
        DoMathReq request = new DoMathReq(5, 0, "/");
        when(mathImpl.doMath(5, 0, "/")).thenThrow(new InvalidOpException("Cannot divide by 0"));

        // Act
        ResponseEntity<ApiRes> responseEntity = mathContro.create(request);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Cannot divide by 0", responseEntity.getBody().getError());
        verify(mathImpl, times(1)).doMath(5, 0, "/");
    }
}

