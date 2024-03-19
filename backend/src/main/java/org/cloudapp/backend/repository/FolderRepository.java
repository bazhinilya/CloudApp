package org.cloudapp.backend.repository;

import java.util.Optional;

import org.cloudapp.backend.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
    // @Query("SELECT f from folder f WHERE u.name = :name")
    // List<Folder> findByName(String name);
    Optional<Folder> findByName(String name);
}