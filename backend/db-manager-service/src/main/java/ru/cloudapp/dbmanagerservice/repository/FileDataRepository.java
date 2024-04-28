package ru.cloudapp.dbmanagerservice.repository;

import ru.cloudapp.dbmanagerservice.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDataRepository extends JpaRepository<FileData, Long> {
}