package org.cloudapp.backend.service;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.cloudapp.backend.entity.ContentType;
import org.cloudapp.backend.entity.File;
import org.cloudapp.backend.entity.FileData;
import org.cloudapp.backend.entity.Folder;
import org.cloudapp.backend.repository.FileDataRepository;
import org.cloudapp.backend.repository.FileRepository;
import org.cloudapp.backend.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CloudAppService {

    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private FileDataRepository fileDataRepository;

    public Folder getFolderByName(String folder) {
        return folderRepository.findByName(folder);
    }

    public Folder createDirectory(Folder folder) {
        return folderRepository.save(
                Folder.builder()
                        .name(folder.getName())
                        .parentId(folder.getParentId())
                        .build());
    }

    public byte[] getFileData(long fileDataId) {
        return Optional.ofNullable(fileDataRepository.findById(fileDataId).get().getByteCode()).orElseThrow();
    }

    // TODO: Проверить, подтягиваются ли Lazy данные автоматически
    // и срабатывает ли автополстановка id join-ов
    public File uploadFile(MultipartFile file, Folder folder) throws IOException {
        return fileRepository.save(
                File.builder()
                        .name(file.getOriginalFilename())
                        .folder(folder)
                        .dateCreated(new Date())
                        .fileData(FileData.builder().byteCode(file.getBytes()).build())
                        .contentType(ContentType.builder().name(file.getContentType()).build())
                        .build());
    }
}