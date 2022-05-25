package me.matamor.backend.upload;

import lombok.RequiredArgsConstructor;
import me.matamor.backend.configs.ConfiguracionServidor;
import me.matamor.backend.models.image.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository repository;
    private final ConfiguracionServidor config;

    private File getFolder(boolean create) throws ImageStorageException {
        File folder = new File(this.config.storageDir);
        if (!folder.exists()) {
            if (create) {
                if (!folder.mkdir()) {
                    throw new ImageStorageException("Couldn't create storage folder for img!");
                }
            } else {
                throw new ImageStorageException("Storage folder not found!");
            }
        }

        return folder;
    }


    private File getFile(Image reference, boolean create) throws ImageStorageException {
        File folder = getFolder(create);
        File file = new File(folder, String.valueOf(reference.getId()));
        if (!file.exists()) {
            if (create) {
                try {
                    if (!file.createNewFile()) {
                        throw new ImageStorageException("Couldn't create file to store img!");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ImageStorageException("Couldn't create file to store img!");
                }
            } else {
                throw new ImageStorageException("Couldn't find file from reference!");
            }
        }

        return file;
    }

    public Image storeImage(MultipartFile request) throws ImageStorageException {
        Image reference = this.repository.save(Image.builder()
                .name(request.getOriginalFilename())
                .type(request.getContentType()).build());

        File file = getFile(reference, true);

        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            byte[] compressedImage = ImageUtility.compressImage(request.getBytes());
            outputStream.write(compressedImage);
        } catch (IOException e) {
            this.repository.delete(reference);
            throw new ImageStorageException("Couldn't write img to file!");
        }

        return reference;
    }

    public Image getReference(long id) {
        return this.repository.findById(id).orElse(null);
    }

    public byte[] readImg(Image image) throws ImageStorageException {
        File file = getFile(image, false);
        try (FileInputStream inputStream = new FileInputStream(file)) {
            System.out.println("Reading file: " + file);
            return ImageUtility.decompressImage(inputStream.readAllBytes());
        } catch (IOException e) {
            throw new ImageStorageException("Couldn't read img from file!");
        }
    }
}
