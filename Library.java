// src/main/java/LibraryManagement/Library.java

package LibraryManagement;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (books.stream().noneMatch(b -> b.getIsbn().equals(book.getIsbn()))) {
            books.add(book);
        } else {
            throw new IllegalArgumentException("Book with this ISBN already exists.");
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
