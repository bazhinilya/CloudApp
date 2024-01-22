package org.cloudapp.backend.service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.cloudapp.backend.entity.Extension;
import org.cloudapp.backend.entity.FileData;
import org.cloudapp.backend.repository.ExtensionRepository;
import org.cloudapp.backend.repository.FileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CloudAppService {
    @Autowired
    private FileDataRepository fileDataRepository;
    @Autowired
    private ExtensionRepository extensionRepository;

    public ResponseEntity<List<?>> getAll() {
        return new ResponseEntity<>(fileDataRepository.findAll(), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> uploadFile(MultipartFile uploadFile) throws IOException {
        String fileName = uploadFile.getOriginalFilename();
        String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
        FileData file = fileDataRepository.save(new FileData(
                new Random().nextLong(),
                fileNameWithoutExtension,
                uploadFile.getBytes(),
                getExtensionByName(fileExtension)));
        return new ResponseEntity<>(file, HttpStatus.OK);
    }

    private Extension getExtensionByName(String extension) {
        Extension extensionOfDb = extensionRepository.findByName(extension);
        if (extensionOfDb != null)
            return extensionOfDb;
        extensionOfDb = new Extension(new Random().nextLong(), extension);
        extensionRepository.save(extensionOfDb);
        return extensionOfDb;
    }
}