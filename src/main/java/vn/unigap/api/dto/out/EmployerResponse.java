package vn.unigap.api.dto.out;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import vn.unigap.api.entity.Employer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EmployerResponse{
    public static ResponseEntity<Object> responseBuilder(
            String message,
            HttpStatus httpStatus,
            Object responseObject
    )
    {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("httpStatus", httpStatus);
        response.put("Object", responseObject);

        return new ResponseEntity<>(response, httpStatus);
    }
    // Constructors, getters, and setters
}
