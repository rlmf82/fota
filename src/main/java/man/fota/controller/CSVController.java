package man.fota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import man.fota.service.CSVReaderService;

@RestController
@RequestMapping("read")
public class CSVController {

    @Autowired
    private CSVReaderService csvService;

    @GetMapping
    public void list() throws Exception {
        csvService.processFiles();
    }
}