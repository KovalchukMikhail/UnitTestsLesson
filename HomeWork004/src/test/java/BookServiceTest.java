import book.BookRepository;
import book.BookService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookServiceTest {
    BookRepository bookRepository;
    BookService service;
    @BeforeEach
    void init(){
        bookRepository = mock(BookRepository.class);
        service = new BookService(bookRepository);
    }
    @AfterEach
    void tearDown(){
        bookRepository = null;
        service = null;
    }
    @Test
    void findBookByIdTest(){
        service.findBookById("1");
        verify(bookRepository).findById("1");
    }
    @Test
    void findAllBooksTest(){
        service.findAllBooks();
        verify(bookRepository).findAll();
    }
}
