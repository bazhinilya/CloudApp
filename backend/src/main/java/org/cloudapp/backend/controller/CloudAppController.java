package org.cloudapp.backend.controller;

import java.io.IOException;

import org.cloudapp.backend.entity.File;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CloudAppController {

    @Autowired
    private CloudAppService service;

    @GetMapping("folder/{folderName}")
    public ResponseEntity<?> getFolder(@PathVariable String folderName) {
        return ResponseEntity.ok(service.getFolderByName(folderName));
    }

    @PostMapping("folder/add")
    public ResponseEntity<?> setFolder(@RequestBody Folder folder) {
        return ResponseEntity.ok(service.createDirectory(folder));
    }

    // TODO: Проверить, подтягиваются ли Lazy данные автоматически
    @GetMapping("file/download")
    public ResponseEntity<?> getFile(@RequestBody File file) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .contentType(MediaType.parseMediaType(file.getContentType().getName()))
                .body(file.getFileData().getByteCode());
    }

    @PostMapping("file/upload")
    public ResponseEntity<?> setFile(@RequestBody MultipartFile file, @RequestBody Folder folder) throws IOException {
        return ResponseEntity.ok(service.uploadFile(file, folder));
    }
}