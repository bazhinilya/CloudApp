package org.cloudapp.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.cloudapp.backend.entity.FileData;
import org.cloudapp.backend.service.CloudAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "api/data")
public class CloudAppController {
    @Autowired
    private CloudAppService service;

    @GetMapping("{pageNumber}")
    public List<FileData> getData(@RequestParam int pageNumber) {
        return service.getFileDataByPage(pageNumber);
    }

    // @PostMapping("path")
    // public FileData postData(@RequestBody FileData entity) {
    //     return entity;
    // }

    // @PutMapping("path/{id}")
    // public FileData putData(@PathVariable String id, @RequestBody FileData entity) {
    //     return entity;
    // }
}