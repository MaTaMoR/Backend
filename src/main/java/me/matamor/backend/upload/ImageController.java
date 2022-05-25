package me.matamor.backend.upload;

import lombok.RequiredArgsConstructor;
import me.matamor.backend.models.image.Image;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<Image> uploadImage(@RequestParam("image") MultipartFile file)
            throws IOException {

        try {
            Image image = this.imageService.storeImage(file);
            return ResponseEntity.ok(image);
        } catch (ImageStorageException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<Image> getImageDetails(@PathVariable("id") Long id) throws IOException {
        return ResponseEntity.ok(this.imageService.getReference(id));
    }

    @GetMapping(path = {"/get/{id}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
        Image image = this.imageService.getReference(id);
        if (image == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        byte[] imageBytes = this.imageService.readImg(image);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(image.getType()))
                .body(imageBytes);
    }
}
