// src/test/java/LibraryManagement/LibraryTest.java

package LibraryManagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    // borrow book test case
    @Test
    void shouldBorrowBookFromLibrary() {
        Book book = new Book("12345", "1984", "George Orwell", 1949);
        library.addBook(book);
        library.borrowBook("12345");
        assertFalse(book.isAvailable());
    }


    // Add book test case
    @Test
    void shouldAddNewBookToLibrary() {
        Book book = new Book("12345", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.addBook(book);
        assertTrue(library.getBooks().contains(book));
    }
}
