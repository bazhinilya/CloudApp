package org.cloudapp.backend.controller;

import java.io.IOException;
import java.util.List;

import org.cloudapp.backend.entity.FileData;
import org.cloudapp.backend.service.CloudAppService;
import org.cloudapp.backend.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
@RestController
@RequestMapping(path = "data")
@CrossOrigin(origins = "http://localhost:3000")
public class CloudAppController {
    @Autowired
    private CloudAppService service;

    @GetMapping("files/{page}")
    public ResponseEntity<List<?>> get(@PathVariable int page) throws IOException {
        return ResponseEntity.ok(service.getAll(page));
    }

    @GetMapping("download/{fileName}")
    public ResponseEntity<?> get(@PathVariable String fileName) throws IOException {
        FileData data = service.getFile(fileName);
        String extension = data.getExtension().getName();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + data.getName() + "."
                                + Utils.getFileExtension(extension) + "\"")
                .contentType(MediaType.parseMediaType(extension))
                .body(new ByteArrayResource(data.getByteCode()));
    }

    @PostMapping("upload")
    public ResponseEntity<?> post(@RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(service.uploadFile(file));
    }
}