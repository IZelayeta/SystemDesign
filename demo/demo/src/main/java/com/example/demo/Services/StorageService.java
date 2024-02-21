package com.example.demo.Services;


import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void init() throws IOException;

    String store(MultipartFile file);
    
    Resource loadAsResources(String filename);
}
