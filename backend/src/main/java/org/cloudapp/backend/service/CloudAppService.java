package org.cloudapp.backend.service;

import java.io.IOException;
import java.util.List;

import org.cloudapp.backend.entity.FileData;
import org.cloudapp.backend.repository.ExtensionRepository;
import org.cloudapp.backend.repository.FileDataRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

public class CloudAppService {
    private FileDataRepository fileDataRepository;
    private ExtensionRepository extensionRepository;

    public List<FileData> getFileDataByPage(int pageNumber) {
        return fileDataRepository.findAll(PageRequest.of(pageNumber, 10)).toList();
    }

    public String uploadFile(MultipartFile uploadFile) throws IOException {
        String fileName = uploadFile.getName();
        String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
        String fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
        extensionRepository.findByName(fileExtension);
        if (extensionRepository == null) {
            //добавить расширение в бд
            // extensionRepository.save();
        }
        //new FileData()
        fileDataRepository.save(null);
        return HttpStatus.OK.toString();
    }
}
