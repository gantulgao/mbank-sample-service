package mn.mbank.sample.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.mbank.sample.service.service.SampleService;
import mn.mbank.sample.service.spec.model.FinalResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mn.mbank.sample.service.spec.SampController;
import mn.mbank.sample.service.spec.model.ReqSample1;
import mn.mbank.sample.service.spec.model.ResSample1;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(description = "Sample -тэй ажиллах API")
public class SampleControllerImp implements SampController {

    private final SampleService sampleService;

    @ApiOperation("Мэдээлэл өөрчлөх, оруулах, засах api")
    @Override
    public ResponseEntity<FinalResponse<ResSample1>> postSample(ReqSample1 req) {
        log.info("In postSample ...");
       return sampleService.postSample(req);
    }

    @ApiOperation("Мэдээлэл авах, хайх api")
    @Override
    public ResponseEntity<FinalResponse<ResSample1>> getSample(String param1) {
        log.info("In getSample ...");
       return sampleService.getSample(param1);
    }

}