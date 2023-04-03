package Group24.LibApp.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import Group24.LibApp.Models.Book;

@Service
public interface ShoppingCartItemService {
    public abstract List<Book> getShoppingCartItemsForUser(Integer userId);
    public abstract void addShoppingCartItem(Integer userId, Integer bookId);
    public abstract void removeShoppingCartItem(Integer userId, Integer bookId);
    public abstract Double getShoppingCartTotalPrice(Integer userId);
}