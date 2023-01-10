package com.example.library.user;

import com.example.library.admin.Admin;
import com.example.library.admin.AdminService;
import com.example.library.book.Book;
import com.example.library.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

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

//        book.setUser(user);
        bookRepository.save(book);
    }

    public List<Book> getAllBooksByUserId(int userId){
        return bookRepository.findByUserId(userId);
    }

    public String addUser(UserRequest request) {
        userRepository.save(
                new User(
                        request.getName(),
                        request.getEmail(),
                        request.getCin()
                ));
        return "user has been created successfully";
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
//        users.stream().map(user -> new User(user.getName(),user.getEmail(),user.getCin()));
//        System.out.println("Users===>" + users);
        return users;
    }
}
