package man.fota.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import man.fota.response.dto.FeatureResponse;
import man.fota.service.FeatureService;

@RestController
@RequestMapping("features")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @GetMapping
    public List<FeatureResponse> getAll() throws Exception {
        return featureService.getAll();
    }
}