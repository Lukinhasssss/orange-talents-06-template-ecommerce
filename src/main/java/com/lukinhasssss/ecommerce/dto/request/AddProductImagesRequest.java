package com.lukinhasssss.ecommerce.dto.request;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class AddProductImagesRequest {

    @Size(min = 1) @NotNull
    private List<MultipartFile> images = new ArrayList<>();

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }

    public List<MultipartFile> getImages() {
        return images;
    }
}
