//package com.rent.read.controller;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.rent.read.entity.Books;
//import com.rent.read.entity.Rentals;
//import com.rent.read.entity.Users;
//import com.rent.read.repository.BookRepository;
//import com.rent.read.repository.RentalRepository;
//import com.rent.read.repository.UserRepository;
//
//@RestController
//@RequestMapping("/user")
//public class RentalController {
//	
//	@Autowired
//    private RentalRepository rentalRepository;
//
//    @Autowired
//    private BookRepository bookRepository;
//    
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping("/books/{bookId}/rent")
//    @PreAuthorize("hasRole('USER')")
//    public ResponseEntity<String> rentBook(@PathVariable Long bookId, @AuthenticationPrincipal UserDetails userDetails) {
//        Optional<Users> user = userRepository.findByEmail(userDetails.getUsername());
//        
//        // Check if the user already has 2 rentals
//        long activeRentals = rentalRepository.countByUserIdAndReturnDateIsNull(user.get());
//        if (activeRentals >= 2) {
//            return new ResponseEntity<>("User already has 2 active rentals", HttpStatus.BAD_REQUEST);
//        }
//        
//        // Check if the book is available
//        Books book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
//        if (!book.isAvailable()) {
//            return new ResponseEntity<>("Book is not available", HttpStatus.BAD_REQUEST);
//        }
//
//        // Rent the book
//        Rentals rental = new Rentals(user, book, LocalDate.now());
//        rentalRepository.save(rental);
//        book.setAvailable(false);
//        bookRepository.save(book);
//
//        return ResponseEntity.ok("Book rented successfully");
//    }
//
//}
