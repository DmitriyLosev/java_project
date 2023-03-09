import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static class Product {
        private String name;
        private double price;
        private int rating;

        public Product(String name, double price, int rating) {
            this.name = name;
            this.price = price;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getRating() {
            return rating;
        }
    }

    static class Category {
        private String name;
        private List<Product> products;

        public Category(String name, Product[] products) {
            this.name = name;
            this.products = new ArrayList<>(Arrays.asList(products));
        }

        public String getName() {
            return name;
        }

        public List<Product> getProducts() {
            return products;
        }

        public void removeProduct(Product product) {
            products.remove(product);
        }
    }

    static class Basket {
        private List<Product> products;

        public Basket() {
            products = new ArrayList<>();
        }

        public void addProduct(Product product) {
            products.add(product);
        }

        public List<Product> getProducts() {
            return products;
        }
    }

    static class User {
        private String login;
        private String password;
        private Basket basket;

        public User(String login, String password) {
            this.login = login;
            this.password = password;
            basket = new Basket();
        }

        public Basket getBasket() {
            return basket;
        }

        public String getLogin() {
            return login;
        }
    }

    public static void main(String[] args) {
        Product[] products = new Product[]{
                new Product("LG", 1000, 4),
                new Product("Sony", 2000, 2),
                new Product("Panasonik", 1500, 3),
                new Product("HP", 100, 2),
                new Product("Canon", 1500, 1)
        };

        Category[] categories = new Category[]{
                new Category("Мониторы", new Product[]{products[0], products[1], products[2]}),
                new Category("Принтеры", new Product[]{products[3]}),
                new Category("Сканеры", new Product[]{products[4]})
        };

        System.out.println("Каталог техники:");
        for (Product p : products) {
            System.out.println("- " + p.getName() + " - " + p.getPrice() + " руб. - рейтинг: " + p.getRating());
        }

        User[] users = new User[]{
                new User("user1", "password123"),
                new User("user2", "password234"),
                new User("user3", "password345")
        };
        // Добавление товаров в корзину и удаление из категорий
        for (User u : users) {
            // Получаем первый продукт из первой категории
            Product product = categories[0].getProducts().get(0);
            // Удаляем продукт из категории
            categories[0].removeProduct(product);
            // Добавляем продукт в корзину пользователя
            u.getBasket().addProduct(product);
            // Выводим содержимое корзины
            System.out.print("Корзина пользователя " + u.getLogin() + ": ");
            List<Product> basketProducts = u.getBasket().getProducts();
            if (basketProducts.isEmpty()) {
                System.out.println("пуста");
            } else {
                for (Product p : basketProducts) {
                    System.out.print(p.getName() + ", ");
                }
                System.out.println();
            };
        }

            // Вывод покупок каждого пользователя
            for (User u : users) {
                System.out.println("Покупки пользователя " + u.getLogin() + ":");
                List<Product> purchasedProducts = u.getBasket().getProducts();
                if (purchasedProducts.isEmpty()) {
                    System.out.println("Корзина пуста");
                } else {
                    for (Product p : purchasedProducts) {
                        System.out.println("- " + p.getName() + " - " + p.getPrice() + " руб.");
                    }
                }
            }
        }
    }
