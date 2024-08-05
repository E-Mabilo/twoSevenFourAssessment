package com._fourassessment.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com._fourassessment.service.FileImport;

@RestController
@RequestMapping("/data")
public class FileController {
    @Autowired
    private FileImport dataImporter;

    @PostMapping("/import")
    public ResponseEntity<String> importData(@RequestParam("file") MultipartFile file) {
        try {
            File tempFile = File.createTempFile("upload", null);
            file.transferTo(tempFile);
            dataImporter.importData(tempFile);
            return ResponseEntity.ok("Data imported successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error importing data: " + e.getMessage());
        }
    }
}

