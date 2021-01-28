package mn.mbank.sample.service.spec;

import mn.mbank.sample.service.spec.model.FinalResponse;
import mn.mbank.sample.service.spec.model.ReqSample1;
import mn.mbank.sample.service.spec.model.ResSample1;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

@Validated
@RequestMapping(value = "/v1.0/sample", produces = "application/json")
public interface SampController {

    @PostMapping
    ResponseEntity<FinalResponse<ResSample1>> postSample(@RequestBody ReqSample1 req);

    @GetMapping
    ResponseEntity<FinalResponse<ResSample1>> getSample(@RequestParam(required = false) String param1);

}
