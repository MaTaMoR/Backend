package me.matamor.backend.models.book.type;

import lombok.Getter;

public enum BookType {

    INDEPENDIENTE,
    BILOGIA,
    TRILOGIA,
    SAGA,
    SERIE;

    @Getter
    private final String name;

    BookType() {
        String rawName = name();
        this.name = Character.toUpperCase(rawName.charAt(0)) + rawName.substring(1).toLowerCase();
    }

    public static BookType getByName(String nombre) {
        for (BookType bookType : values()) {
            if (bookType.getName().equalsIgnoreCase(nombre)) {
                return bookType;
            }
        }

        return null;
    }
}