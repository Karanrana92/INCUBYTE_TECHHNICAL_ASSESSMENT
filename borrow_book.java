@Test
void shouldBorrowBookFromLibrary() {
    Book book = new Book("12345", "1984", "George Orwell", 1949);
    library.addBook(book);
    library.borrowBook("12345");
    assertFalse(book.isAvailable());
}
