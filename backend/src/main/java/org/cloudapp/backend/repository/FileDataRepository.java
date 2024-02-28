package org.cloudapp.backend.repository;

import org.cloudapp.backend.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDataRepository extends JpaRepository<FileData, Long> {
    boolean existsByName(String name);
    FileData findByName(String name);
}