package ru.cloudapp.dbmanagerservice.repository;

import ru.cloudapp.dbmanagerservice.entity.ContentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentTypeRepository extends JpaRepository<ContentType, Long> {
    ContentType findByName(String name);
}