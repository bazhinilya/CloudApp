package ru.cloudapp.dbmanagerservice.repository;

import ru.cloudapp.dbmanagerservice.entity.Tree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeRepository extends JpaRepository<Tree, Long> {
    Tree findByPath(String path);
}