package com.example.fileup_ex.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * 타입리프로 할 경우 Controller 작성
 */
@Controller
@RequestMapping("/files")
@Slf4j
public class FileUploadController {
    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/upload")
    public String upload() {
        return "FileUploadForm";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam String name,
                         @RequestParam Integer price,
                         @RequestParam Integer quantity,
                         @RequestParam MultipartFile file,
                         HttpServletRequest req) throws ServletException, IOException {
        System.out.println(name);

        /** 파일을 들고와보자 */
        log.info("product name {} ==> ", name);
        log.info("file {} ==> ", file);

        if (!file.isEmpty()) {
            file.transferTo(new File(fileDir + file.getOriginalFilename()));
        }
        return "FileUploadForm";
    }
}
