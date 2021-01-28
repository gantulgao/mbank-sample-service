package mn.mbank.sample.service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mn.mbank.sample.service.Exception.CoreException;
import mn.mbank.sample.service.config.OrdsConfig;
import mn.mbank.sample.service.spec.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import mn.mbank.sample.service.spec.model.FinalResponse;
import mn.mbank.sample.service.spec.model.ReqSample1;
import mn.mbank.sample.service.spec.model.ResSample1;
import mn.mbank.sample.service.utils.OrdsCore;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.ok;

@Service
@RequiredArgsConstructor
@Slf4j
public class SampleService {

    private final OrdsCore core;
    private final OrdsConfig conf;

    public ResponseEntity<FinalResponse<ResSample1>> getSample(String id)  {
        log.debug("In getSample ...");
        FinalResponse<ResSample1> res = new FinalResponse();
        try {

            log.debug("REQ:{}",id);
            String resOrds = core.getOrds(conf.getOrds().getUrl1(),HttpMethod.POST, id);
            log.debug("RES:{}",resOrds);

            res.setBody(new ResSample1(resOrds,""));

            return ok(res);

        }
        catch (Exception e){
            log.error("Cannot getSample!",e);
            throw new CoreException(e.getMessage());
        }
        finally {
            log.debug("Out getSample ...");
        }
    }

    public ResponseEntity<FinalResponse<ResSample1>> postSample(ReqSample1 req){
        log.debug("In postSample ...");
        FinalResponse<ResSample1> res = new FinalResponse();
        try {

            log.debug("REQ:{}",new ObjectMapper().writeValueAsString(req));
            String  resOrds = core.getOrds(conf.getOrds().getUrl2(),HttpMethod.POST, new ObjectMapper().writeValueAsString(req));
            log.debug("RES{}",resOrds);

            return accepted().body(res);
        }
        catch (Exception e){
            log.warn("Cannot postSample",e);
            throw new CoreException("Cannot update firebase token!");
        }
        finally {
            log.debug("Out postSample ...");
        }

    }

}