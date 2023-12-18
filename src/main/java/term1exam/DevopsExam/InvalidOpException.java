package term1exam.DevopsExam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidOpException extends RuntimeException {

    public InvalidOpException(String message) {
        super(message);
    }
}