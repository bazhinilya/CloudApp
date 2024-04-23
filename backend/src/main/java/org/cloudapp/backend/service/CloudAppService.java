package org.cloudapp.backend.service;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.cloudapp.backend.entity.ContentType;
import org.cloudapp.backend.entity.File;
import org.cloudapp.backend.entity.FileData;
import org.cloudapp.backend.entity.Folder;
import org.cloudapp.backend.entity.Tree;
import org.cloudapp.backend.repository.ContentTypeRepository;
import org.cloudapp.backend.repository.FileDataRepository;
import org.cloudapp.backend.repository.FileRepository;
import org.cloudapp.backend.repository.FolderRepository;
import org.cloudapp.backend.repository.TreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;

@Service
public class CloudAppService {

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