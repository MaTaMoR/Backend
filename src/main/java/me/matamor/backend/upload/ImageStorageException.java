package me.matamor.backend.upload;

public class ImageStorageException extends RuntimeException {

    public ImageStorageException(String message) {
        super(message);
    }

    public ImageStorageException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
