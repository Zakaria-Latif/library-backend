package com.example.library.user;

import com.example.library.book.Book;
import com.example.library.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService, BookRepository bookRepository) {
        this.userService = userService;
    }

    @GetMapping("/users/{userId}/books")
    public ResponseEntity<List<Book>> getAllBooksByUserId(@PathVariable(value = "userId") int userId) {

        return new ResponseEntity<>(userService.getAllBooksByUserId(userId), HttpStatus.OK);
    }

    @PutMapping("/users/{userId}/books/{bookId}")
    public void assignBookToUser(@PathVariable(value = "userId") int userId,
                                 @PathVariable(value = "bookId") int bookId) {

        userService.assignUserToBook(userId, bookId);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/users/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
}