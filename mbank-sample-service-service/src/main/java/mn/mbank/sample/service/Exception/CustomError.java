package mn.mbank.sample.service.Exception;

import lombok.extern.slf4j.Slf4j;
import mn.mbank.sample.service.spec.model.FinalResponse;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
public class CustomError extends AbstractErrorController {
    public CustomError(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> handleError(HttpServletRequest request) {
        log.debug("Getting error!");
        Map<String, Object> errorAttributes = super.getErrorAttributes(request, true);
        log.warn("Error att!: {}",errorAttributes);
        Map<String, String> error = new HashMap<>();
        error.put("error", errorAttributes.containsKey("trace")?errorAttributes.get("trace").toString():errorAttributes.get("error").toString());
        FinalResponse res = new FinalResponse();
        res.setCode("5000");
        res.setMessage("Дотоод алдаа");
        return ResponseEntity.ok(res);
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}