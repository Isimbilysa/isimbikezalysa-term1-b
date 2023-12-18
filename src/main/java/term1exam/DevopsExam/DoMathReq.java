package term1exam.DevopsExam;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoMathReq {
    private double operand1;
    private double operand2;
    private String operation;
}
