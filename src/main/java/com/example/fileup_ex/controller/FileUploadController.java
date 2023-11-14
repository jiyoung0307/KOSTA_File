package com.example.fileup_ex.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;

/** 타입리프로 할 경우 Controller 작성 */
@Controller
@RequestMapping("/files")
public class FileUploadController {
    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/upload")
    public String upload() {
        return "FileUploadForm";
    }

    @PostMapping("/upload")
    public String upload(HttpServletRequest req) throws ServletException, IOException {
        System.out.println(req.getParameter("name"));
        req.getParameter("price");
        req.getParameter("quantity");
        Collection<Part> parts = req.getParts();
        for(Part part : parts) {
            System.out.println(part.getName());
            System.out.println(part.getSize());
            System.out.println(part.getContentType());
            System.out.println(part.getSubmittedFileName());
            part.write(fileDir + part.getSubmittedFileName());  /** images에 null이 생기는 이유 */
        }
        return "FileUploadForm";
    }
}
