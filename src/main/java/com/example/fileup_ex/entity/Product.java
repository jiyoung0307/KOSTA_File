package com.example.fileup_ex.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/** 여러 개의 파일을 업로드할 엔티티 */
@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    private Integer quantity;
//    저장할때는 이름만 있으면 됨
    private List<ProductImage> imageFiles; /** 원래이름과 다른 이름이 저장됨 서로 다른 이름을 가진 파일 */
}
