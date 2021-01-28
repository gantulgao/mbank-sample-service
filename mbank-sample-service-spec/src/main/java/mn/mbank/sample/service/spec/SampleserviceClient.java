package mn.mbank.sample.service.spec;

import mn.mbank.sample.service.spec.model.FinalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mn.mbank.sample.service.spec.model.ReqSample1;
import mn.mbank.sample.service.spec.model.ResSample1;

@FeignClient(name = "mbank-ganaa-service-service", path = "/mbank-ganaa-service-service", primary = false)
public interface SampleserviceClient {

    @PostMapping(value = "/v1.0/sample")
    ResponseEntity<FinalResponse<ResSample1>> postSample(@RequestBody ReqSample1 req);

    @GetMapping(value = "/v1.0/sample")
    ResponseEntity<FinalResponse<ResSample1>> getSample(@RequestParam(required = false) String param1);

}
