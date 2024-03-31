package org.cloudapp.backend.repository;

import org.cloudapp.backend.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    Folder findByName(String name);
}