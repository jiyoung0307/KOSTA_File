package com.example.fileup_ex.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ProductDTO {
    private String name;
    private Integer price;
    private Integer quantity;
    /** 여기서는 모든 정보를 가져와야 함!! Product와 다른!! 주의!! */
    private List<MultipartFile> imageFiles;
}
