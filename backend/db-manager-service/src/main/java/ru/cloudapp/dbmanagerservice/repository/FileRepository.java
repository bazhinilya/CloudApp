package ru.cloudapp.dbmanagerservice.repository;

import ru.cloudapp.dbmanagerservice.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}