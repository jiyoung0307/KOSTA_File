package com.example.fileup_ex.controller;

import com.example.fileup_ex.entity.Product;
import com.example.fileup_ex.entity.ProductDTO;
import com.example.fileup_ex.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/** 타입리프로 할 경우 Controller 작성 */
@Controller
@RequestMapping("/files")
@Slf4j
@RequiredArgsConstructor
public class FileUploadController {
    private final ProductRepository productRepository;

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/upload")
    public String upload() {
        return "FileUploadForm";
    }

    @PostMapping("/upload")
    public String upload(@ModelAttribute ProductDTO productDTO){
        /** 파일을 들고와보자 */
        log.info("product name {} ==> ", productDTO.getName());
        List<MultipartFile> imageFiles = productDTO.getImageFiles();
        log.info("file {} ==> ", productDTO.getImageFiles());

        /** 여러 개의 파일을 들고오는지 보자 */
        for(MultipartFile imageFile : imageFiles) {
            log.info("file {} ==> ", imageFile.getOriginalFilename());
        }

//        if (!file.isEmpty()) {
//            file.transferTo(new File(fileDir + file.getOriginalFilename()));
//        }
        return "FileUploadForm";
    }
}
