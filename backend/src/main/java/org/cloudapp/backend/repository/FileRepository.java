package org.cloudapp.backend.repository;

import org.cloudapp.backend.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}