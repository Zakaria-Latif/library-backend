package com.example.library.user;

import com.example.library.book.Book;
import com.example.library.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private final BookRepository bookRepository;


    public UserService(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public void assignUserToBook(int userId, int bookId) {
        Book book = bookRepository.findById(bookId).get();
        User user = userRepository.findById(userId).get();

        book.setUser(user);
        bookRepository.save(book);
    }

    public List<Book> getAllBooksByUserId(int userId){
        return bookRepository.findByUserId(userId);
    }


    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
