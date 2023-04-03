package Group24.LibApp.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Group24.LibApp.Models.Book;
import Group24.LibApp.Models.ShoppingCartItem;
import Group24.LibApp.Repositories.BookRepository;
import Group24.LibApp.Repositories.ShoppingCartItemRepository;

@Service
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService{

    @Autowired
    BookRepository bookRepository;
    @Autowired
    ShoppingCartItemRepository shoppingCartItemRepository;


    @Override
    public List<Book> getShoppingCartItemsForUser(Integer userId) {
        List<ShoppingCartItem> sc = shoppingCartItemRepository.findByUserId(userId);
        List<Book> books = new ArrayList<Book>();
        for (ShoppingCartItem sci : sc) {
            books.add(bookRepository.findById(sci.getBookId()));
        }

        return books;
    }
    @Override
    public void addShoppingCartItem(Integer userId, Integer bookId) {
        List<ShoppingCartItem> sc = shoppingCartItemRepository.findByOrderByIdDesc();
        int lastIndex = sc.size() > 0 ? sc.get(0).getId() : 0;
        ShoppingCartItem sci = new ShoppingCartItem(lastIndex+1, userId, bookId);
        System.err.println(sci.toString());
        shoppingCartItemRepository.save(sci);
    }
    @Override
    public void removeShoppingCartItem(Integer userId, Integer bookId) {
        List<ShoppingCartItem> sci = shoppingCartItemRepository.findByUserIdAndBookId(userId, bookId);
        shoppingCartItemRepository.deleteAll(sci);
    }
    @Override
    public Double getShoppingCartTotalPrice(Integer userId) {
        List<Book> books = getShoppingCartItemsForUser(userId);
        Double price = 0.0;
        for (Book b : books){
            price += b.getPrice();
        }

        return price;
    }

    
}
