import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ShoppingCartController {
    private ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {this.shoppingCartService=shoppingCartService;}

    @PostMapping ("/shoppingcart/create")
    public void createShopCart(@RequestBody ShoppingCart sc) {
        shoppingCartService.createShopCart(sc);
    }

    @PatchMapping("/shoppingcart/add/{shop_name}")
    public void addBook(@RequestBody BookTemp temp, @PathVariable String shop_name) {
        shoppingCartService.addBook(shop_name,temp.getData());
    }

    @DeleteMapping("/shoppingcart/{user}")
    public void deleteCourse(@RequestBody BookTemp temp, @PathVariable String user) {
        shoppingCartService.deleteBook(temp.getData(),user);
    }
}
