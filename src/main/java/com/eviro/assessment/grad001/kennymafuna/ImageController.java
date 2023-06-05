package com.eviro.assessment.grad001.kennymafuna;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/v1/api/image")
public class ImageController {

    @GetMapping(value = "/{name}/{surname}")
    public ResponseEntity<Resource> getHttpImageLink(
            @PathVariable String name,
            @PathVariable String surname){
        name = name.replace(" ","");
        surname = surname.replace(" ","");


        String imageFilePathJpg = "images/" + name +"_"+ surname + ".jpeg";
        String imageFilePathPng = "images/" + name +"_"+ surname + ".png";

        File imageFileJpg = new File(imageFilePathJpg);
        File imageFilePng = new File(imageFilePathPng);

        if (imageFileJpg.exists()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new FileSystemResource(imageFileJpg));
        } else if (imageFilePng.exists()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(new FileSystemResource(imageFilePng));
        } else {
            // When no image file is found, return a not found response
            return ResponseEntity.notFound().build();
        }
    }
}

