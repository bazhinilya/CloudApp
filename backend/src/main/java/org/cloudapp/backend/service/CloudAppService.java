package org.cloudapp.backend.service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.cloudapp.backend.entity.Extension;
import org.cloudapp.backend.entity.FileData;
import org.cloudapp.backend.repository.ExtensionRepository;
import org.cloudapp.backend.repository.FileDataRepository;
import org.cloudapp.backend.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CloudAppService {
    @Autowired
    private FileDataRepository fileDataRepository;
    @Autowired
    private ExtensionRepository extensionRepository;

    // TODO: add own Exception
    public ResponseEntity<List<?>> getAll(int offset) {
        return new ResponseEntity<>(
                fileDataRepository.findAll(PageRequest.of(offset, 10)).toList(),
                HttpStatus.OK);
    }

    public ResponseEntity<?> uploadFile(MultipartFile uploadFile) throws IOException {
        String fileName = Utils.getFileName(uploadFile.getOriginalFilename());
        if (fileDataRepository.findByName(fileName) != null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        String fileExtension = Utils.getFileExtension(uploadFile.getOriginalFilename());
        fileDataRepository.save(
                new FileData(
                        new Random().nextLong(),
                        fileName,
                        uploadFile.getBytes(),
                        getExtensionId(fileExtension)
                ));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Extension getExtensionId(String extension) {
        var extensionOfDb = extensionRepository.findByName(extension);
        if (extensionOfDb != null)
            return extensionOfDb;
        return extensionRepository.save(new Extension(new Random().nextLong(), extension));
    }
}