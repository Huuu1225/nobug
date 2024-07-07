package com.cqdx.nobug.controller;

import com.cqdx.nobug.entity.UserPhoto;
import com.cqdx.nobug.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FileUploadController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/upload-avatar/{userId}")
    public ResponseEntity<UserPhoto> uploadAvatar(@PathVariable Long userId, @RequestParam("file") MultipartFile file) {
        String uploadDir = "D:/tmp/";
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName = userId + "_" + file.getOriginalFilename();

        try {
            file.transferTo(new File(uploadDir + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Optional<UserPhoto> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            UserPhoto user = userOptional.get();
            user.setAvatar(uploadDir + fileName);
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/avatar/{userId}")
    public ResponseEntity<byte[]> getAvatar(@PathVariable Long userId) {
        Optional<UserPhoto> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            UserPhoto user = userOptional.get();
            try {
                // 读取头像文件数据
                Path imagePath = Paths.get(user.getAvatar());
                byte[] imageBytes = Files.readAllBytes(imagePath);

                // 设置HTTP头部信息
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.IMAGE_JPEG); // 根据实际情况设置图片类型

                return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
