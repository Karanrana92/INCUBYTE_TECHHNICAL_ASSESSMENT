// src/main/java/LibraryManagement/Library.java

package LibraryManagement;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Add book
    public void addBook(Book book) {
        if (books.stream().noneMatch(b -> b.getIsbn().equals(book.getIsbn()))) {
            books.add(book);
        } else {
            throw new IllegalArgumentException("Book with this ISBN already exists.");
        }
    }

    // Borrow book 
    public void borrowBook(String isbn) {
        Book book = books.stream()
                .filter(b -> b.getIsbn().equals(isbn) && b.isAvailable())
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Book is not available or does not exist."));
        book.setAvailable(false);
    }


    public List<Book> getBooks() {
        return books;
    }
}
