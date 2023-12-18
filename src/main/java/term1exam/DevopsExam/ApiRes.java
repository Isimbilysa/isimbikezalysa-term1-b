package term1exam.DevopsExam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiRes {
    private Boolean success;
    private String message;
    private Object data;

    public ApiRes(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiRes(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public static ApiRes success(Object data) {
        return new ApiRes(true, data);
    }

    public static ApiRes fail(Object data) {
        return new ApiRes(false, data);
    }

    public static ApiRes success(String message) {
        return new ApiRes(true, message);
    }

    public static ApiRes fail(String message) {
        return new ApiRes(false, message);
    }


}
