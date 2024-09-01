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

    
    // test case : 1 Add book test case
    @Test
    void add_newBook() {
        Book book = new Book("12345", "The Great Gatsby", "F. Scott Fitzgerald", 1925);
        library.addBook(book);
        assertTrue(library.getBooks().contains(book));
    }

    //test case : 2 Borrow book test case
    @Test
    void borrow_book() {
        Book book = new Book("12345", "1984", "George Orwell", 1949);
        library.addBook(book);
        library.borrowBook("12345");
        assertFalse(book.isAvailable());
    }

    // test : 3 Return book
    @Test
    void return_book() {
        Book book = new Book("12345", "1984", "George Orwell", 1949);
        library.addBook(book);
        library.borrowBook("12345");
        library.returnBook("12345");
        assertTrue(book.isAvailable());
    }
    // test : 4  View Available Book
     @Test
    void view_available_booksInLibrary() {
        Book book1 = new Book("12345", "1984", "George Orwell", 1949);
        Book book2 = new Book("67890", "Brave New World", "Aldous Huxley", 1932);
        library.addBook(book1);
        library.addBook(book2);
        library.borrowBook("12345");
        List<Book> availableBooks = library.viewAvailableBooks();
        assertTrue(availableBooks.contains(book2));
        assertFalse(availableBooks.contains(book1));
    }

}
