package org.cloudapp.backend.controller;

import java.io.IOException;
import java.util.List;

import org.cloudapp.backend.service.CloudAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
@RestController
@RequestMapping(path = "api/data")
public class CloudAppController {
    @Autowired
    private CloudAppService service;

    @GetMapping("files")
    public ResponseEntity<List<?>> getData() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> postData(@RequestParam("file") MultipartFile file) throws IOException {
        return service.uploadFile(file);
    }
}