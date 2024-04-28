package ru.cloudapp.dbmanagerservice.repository;

import ru.cloudapp.dbmanagerservice.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}