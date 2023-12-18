package term1exam.DevopsExam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/math")
public class MathContro {

    private final MathOp mathOp;
    private final MathImpl mathImpl;

    @Autowired
    public MathContro(MathOp mathOp,
                      MathImpl mathImpl) {
        this.mathOp = mathOp;
        this.mathImpl = mathImpl;
    }

    @PostMapping("/doMath")
    public ResponseEntity<ApiRes> create(@RequestBody DoMathReq dto) throws InvalidOpException {
        return ResponseEntity.ok(ApiRes.success(mathImpl.doMath(dto.getOperand1(), dto.getOperand2(), dto.getOperation())));
    }
}
