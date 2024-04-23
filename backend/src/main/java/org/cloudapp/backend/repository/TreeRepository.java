package org.cloudapp.backend.repository;

import org.cloudapp.backend.entity.Tree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeRepository extends JpaRepository<Tree, Long> {
    Tree findByPath(String path);
}