package org.cloudapp.backend.controller;

import java.io.IOException;
import java.util.List;

import org.cloudapp.backend.service.CloudAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CloudAppController {
    @Autowired
    private CloudAppService service;

    @GetMapping("files/{page}")
    public ResponseEntity<List<?>> get(@PathVariable int page) throws IOException {
        return ResponseEntity.ok(service.getAll(page));
    }

    @GetMapping("{userName}")
    public ResponseEntity<?> getDefaultFolder(@PathVariable String userName) {
        return ResponseEntity.ok(service.getDirectory(userName));
    }

    @GetMapping("folder")
    public ResponseEntity<?> getFolderByName() {
        return ResponseEntity.ok(service.getFilesByFolder());
    }

    // @GetMapping("folders/{name}")
    // public ResponseEntity<List<?>> get(@PathVariable String name) {
    // return ResponseEntity.ok(service.getDirectory(name));
    // }

    // @PostMapping("create/{folder}")
    // public ResponseEntity<?> postMethodName(@PathVariable String folder) {
    // return ResponseEntity.ok(service.createDirectory(folder));
    // }

    // @GetMapping("download/{fileName}")
    // public ResponseEntity<?> get(@PathVariable String fileName) throws
    // IOException {
    // FileData data = service.getFile(fileName);
    // String extension = data.getExtension().getName();
    // return ResponseEntity.ok()
    // .header(HttpHeaders.CONTENT_DISPOSITION,
    // "attachment; filename=\"" + data.getName() + "."
    // + Utils.getFileExtension(extension) + "\"")
    // .contentType(MediaType.parseMediaType(extension))
    // .body(new ByteArrayResource(data.getByteCode()));
    // }

    // @PostMapping("upload")
    // public ResponseEntity<?> post(@RequestParam("file") MultipartFile file)
    // throws IOException {
    // return ResponseEntity.ok(service.uploadFile(file));
    // }
}