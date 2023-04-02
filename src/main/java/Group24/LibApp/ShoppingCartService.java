package Group24.LibApp.Services;

import java.util.List;

public class ShoppingCartService {
    public void createShopCart(ShoppingCart sc) {
        if (UserController.getUserByUserEmail(sc.getCart_username())!=null) {
            Connection connection;
            String user = "root";
            String password = "JumpM@n!";
            String database = "jdbc:mysql://localhost:3306/bookstore";

            try {
                connection = DriverManager.getConnection(database, user, password);
                String test = "INSERT INTO shopcart(cart_name,cart_username) VALUES (?,?)";
                PreparedStatement prep = connection.prepareStatement(test);

                prep.setString(1, sc.getCart_name());
                prep.setString(2, sc.getCart_username());

                prep.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Could not open database.");
                System.exit(1);
            }
        }
    }

    public void addBook(String cart_name, String ISBN) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            connection = DriverManager.getConnection(database, user, password);
            String test = "INSERT into contains_cart(b_isbn,shop_name) VALUES (?,?)";
            PreparedStatement prep = connection.prepareStatement(test);

            prep.setString(1,ISBN);
            prep.setString(2,cart_name);
            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }

    public void deleteBook(String ISBN, String userName) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            connection = DriverManager.getConnection(database, user, password);


            String test = "delete from contains_cart where b_isbn = (?) and shop_name = (select cart_name from shopcart where cart_username=(?))";
            PreparedStatement prep = connection.prepareStatement(test);

            prep.setString(1,ISBN);
            prep.setString(2,userName);
            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }
}
