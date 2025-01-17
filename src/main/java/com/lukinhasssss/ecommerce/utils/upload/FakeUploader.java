package com.lukinhasssss.ecommerce.utils.upload;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FakeUploader {

    public Set<String> send(List<MultipartFile> images) {
        return images.stream().map(image -> "https://linkdobucket.io/" + image.getOriginalFilename()).collect(Collectors.toSet());
    }

}
