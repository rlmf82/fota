package man.fota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import man.fota.service.CSVReaderService;

@RestController
@RequestMapping("read")
@Api(value = "CSV Controller", description = "Available user operations")
public class CSVController {

    @Autowired
    private CSVReaderService csvService;

    @GetMapping
    @ApiOperation(value = "Force execution of service to read CSV files")
    public void list() throws Exception {
        csvService.processFiles();
    }
}