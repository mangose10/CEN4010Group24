package Group24.LibApp.Controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Group24.LibApp.Models.Book;
import Group24.LibApp.Services.ShoppingCartItemServiceImpl;


@RestController
public class ShoppingCartController {
    @Autowired
    ShoppingCartItemServiceImpl shoppingCartService;

    @GetMapping ("/shoppingcart/getFromUser")
    public ResponseEntity<List<Book>> getBookByRating(@RequestParam(required = true) Integer user) {

		try {
            List<Book> sc = new ArrayList<Book>();
			sc = shoppingCartService.getShoppingCartItemsForUser(user);

			return new ResponseEntity<>(sc, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @PostMapping("/shoppingcart/add")
    public ResponseEntity<String> addToShoppingCart(@RequestParam(required = true) Integer user, @RequestParam(required = true) Integer book) {

		try {
            shoppingCartService.addShoppingCartItem(user, book);

			return new ResponseEntity<>("Added", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @DeleteMapping("/shoppingcart/delete")
    public ResponseEntity<String> deleteFromShoppingCart(@RequestParam(required = true) Integer user, @RequestParam(required = true) Integer book) {

		try {
			shoppingCartService.removeShoppingCartItem(user, book);

			return new ResponseEntity<>("Deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/shoppingcart/getPrice")
    public ResponseEntity<Double> getPrice(@RequestParam(required = true) Integer user) {

		try {
			Double price = shoppingCartService.getShoppingCartTotalPrice(user);

			return new ResponseEntity<>(price, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
