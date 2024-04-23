package org.cloudapp.backend.repository;

import org.cloudapp.backend.entity.ContentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentTypeRepository extends JpaRepository<ContentType, Long> {
    ContentType findByName(String name);
}