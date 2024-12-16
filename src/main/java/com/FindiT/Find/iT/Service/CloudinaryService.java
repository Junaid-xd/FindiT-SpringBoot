package com.FindiT.Find.iT.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface CloudinaryService {
    String uploadFile(MultipartFile multipartFile) throws IOException;
}
