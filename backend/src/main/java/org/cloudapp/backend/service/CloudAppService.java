package org.cloudapp.backend.service;

import java.io.IOException;
import java.util.List;

import org.cloudapp.backend.entity.File;
import org.cloudapp.backend.entity.Folder;
import org.cloudapp.backend.repository.FileDataRepository;
import org.cloudapp.backend.repository.FileRepository;
import org.cloudapp.backend.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CloudAppService {

    @Autowired
    private FolderRepository folderRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private FileDataRepository fileDataRepository;
    // @Autowired
    // private ExtensionRepository extensionRepository;

    public List<?> getAll(int page) throws IOException {
        return fileDataRepository.findAll(PageRequest.of(page, 10)).toList();
    }

    public Folder getDirectory(String userName) {
        return folderRepository.findByName(userName).get();
    }

    public List<File> getFilesByFolder() {
        var folderId = folderRepository.findByName("ilya").get().getId();
        return fileRepository.findAllWithFolder(folderId).get();
    }

    // public HttpStatus createDirectory(String folder) {
    // try {
    // folderRepository.save(Folder.builder().name(folder).build());
    // return HttpStatus.OK;
    // } catch (Exception e) {
    // return HttpStatus.BAD_REQUEST;
    // }
    // }

    // public FileData getFile(String fileName) throws IOException {
    // return fileDataRepository.findByName(Utils.getFileName(fileName));
    // }

    // public HttpStatus uploadFile(MultipartFile uploadFile) throws IOException {
    // String fileName = Utils.getFileName(uploadFile.getOriginalFilename());
    // if (fileDataRepository.existsByName(fileName))
    // return HttpStatus.CONFLICT;
    // fileDataRepository.save(
    // FileData.builder()
    // .id(new Random().nextLong())
    // .byteCode(uploadFile.getBytes())
    // .build());
    // return HttpStatus.OK;
    // }

    // private Extension getExtensionId(String extension) {
    // Extension extensionOfDb = extensionRepository.findByName(extension);
    // if (extensionOfDb != null)
    // return extensionOfDb;
    // return extensionRepository.save(new Extension(new Random().nextLong(),
    // extension));
    // }
}