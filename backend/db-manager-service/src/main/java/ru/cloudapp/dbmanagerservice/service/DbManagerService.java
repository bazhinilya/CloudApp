package ru.cloudapp.dbmanagerservice.service;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;
import ru.cloudapp.dbmanagerservice.entity.ContentType;
import ru.cloudapp.dbmanagerservice.entity.File;
import ru.cloudapp.dbmanagerservice.entity.FileData;
import ru.cloudapp.dbmanagerservice.entity.Folder;
import ru.cloudapp.dbmanagerservice.entity.Tree;
import ru.cloudapp.dbmanagerservice.repository.ContentTypeRepository;
import ru.cloudapp.dbmanagerservice.repository.FileDataRepository;
import ru.cloudapp.dbmanagerservice.repository.FileRepository;
import ru.cloudapp.dbmanagerservice.repository.FolderRepository;
import ru.cloudapp.dbmanagerservice.repository.TreeRepository;

@Service
public class DbManagerService {

    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private FileDataRepository fileDataRepository;
    @Autowired
    private ContentTypeRepository contentTypeRepository;
    @Autowired
    private TreeRepository treeRepository;

    public Tree getDirectoryById(long id) {
        return treeRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Folder createDirectory(Folder folder) {
        return folderRepository.save(
                Folder.builder()
                        .name(folder.getName())
                        .dateCreated(new Date())
                        .tree(getOrCreateTree(folder.getTree().getPath()))
                        .build());
    }

    private Tree getOrCreateTree(String path) {
        return Optional.ofNullable(treeRepository.findByPath(path))
                .orElseGet(() -> treeRepository.save(Tree.builder().path(path).build()));
    }

    public byte[] getFileData(long fileDataId) {
        return Optional.ofNullable(fileDataRepository.findById(fileDataId).get().getByteCode())
                .orElseThrow();
    }

    @Transactional
    public File uploadFile(MultipartFile file, String path) throws IOException {
        return fileRepository.save(
                File.builder()
                        .name(file.getOriginalFilename())
                        .dateCreated(new Date())
                        .fileData(createFileData(file.getBytes()))
                        .contentType(getOrCreateContentType(file.getContentType()))
                        .tree(Tree.builder().path(path).build())
                        .build());
    }

    private FileData createFileData(byte[] fileData) {
        return fileDataRepository.save(FileData.builder().byteCode(fileData).build());
    }

    private ContentType getOrCreateContentType(String contentType) {
        return Optional.ofNullable(contentTypeRepository.findByName(contentType))
                .orElseGet(() -> contentTypeRepository.save(ContentType.builder().name(contentType).build()));
    }
}