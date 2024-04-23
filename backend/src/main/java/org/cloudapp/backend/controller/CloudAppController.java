package org.cloudapp.backend.controller;

import java.io.IOException;
import java.net.URI;

import org.cloudapp.backend.entity.Folder;
import org.cloudapp.backend.service.CloudAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CloudAppController {

    @Autowired
    private CloudAppService service;

    @GetMapping("cd/{id}")
    public ResponseEntity<?> getDirectoryById(@PathVariable long id) {
        return ResponseEntity.ok(service.getDirectoryById(id));
    }

    @PostMapping("mkdir")
    public ResponseEntity<?> createDirectory(@RequestBody Folder folder) {
        Folder createdFolder = service.createDirectory(folder);
        return ResponseEntity.created(URI.create(createdFolder.getName())).body(createdFolder);
    }

    @GetMapping("download")
    public ResponseEntity<?> downloadFile(@RequestParam("fileDataId") long fileDataId,
            @RequestParam("fileName") String fileName,
            @RequestParam("contentType") String contentType) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .contentType(MediaType.parseMediaType(contentType))
                .body(service.getFileData(fileDataId));
    }

    @PostMapping(path = "upload")
    public ResponseEntity<?> uploadFile(@RequestPart("file") MultipartFile file,
            @RequestPart("path") String path)
            throws IOException {
        return ResponseEntity.ok(service.uploadFile(file, path));
    }
}