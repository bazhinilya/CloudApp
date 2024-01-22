package org.cloudapp.backend.repository;

import org.cloudapp.backend.entity.Extension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtensionRepository extends JpaRepository<Extension, Long> {
    Extension findByName(String name);
}