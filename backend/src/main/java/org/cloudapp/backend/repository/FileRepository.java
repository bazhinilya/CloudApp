package org.cloudapp.backend.repository;

import java.util.List;
import java.util.Optional;

import org.cloudapp.backend.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FileRepository extends JpaRepository<File, Long> {
    // @Query("SELECT b FROM file b JOIN b.author a WHERE a.name = 'John'")
    @Query("SELECT f FROM File f WHERE f.folder = ?1")
    Optional<List<File>> findAllWithFolder(Long folderId);
}