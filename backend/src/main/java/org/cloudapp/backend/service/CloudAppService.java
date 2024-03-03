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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CloudAppService {
    @Autowired
    private FileDataRepository fileDataRepository;
    @Autowired
    private ExtensionRepository extensionRepository;

    public List<?> getAll(int page) throws IOException {
        return fileDataRepository.findAll(PageRequest.of(page, 10)).toList();
    }

    public FileData getFile(String fileName) throws IOException {
        return fileDataRepository.findByName(Utils.getFileName(fileName));
    }

    public HttpStatus uploadFile(MultipartFile uploadFile) throws IOException {
        String fileName = Utils.getFileName(uploadFile.getOriginalFilename());
        if (fileDataRepository.existsByName(fileName))
            return HttpStatus.CONFLICT;
        fileDataRepository.save(
                new FileData(
                        new Random().nextLong(),
                        fileName,
                        uploadFile.getBytes(),
                        getExtensionId(uploadFile.getContentType())
                ));
        return HttpStatus.OK;
    }

    private Extension getExtensionId(String extension) {
        Extension extensionOfDb = extensionRepository.findByName(extension);
        if (extensionOfDb != null)
            return extensionOfDb;
        return extensionRepository.save(new Extension(new Random().nextLong(), extension));
    }
}