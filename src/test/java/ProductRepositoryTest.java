import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    Product book1 = new Book(1, "Eugeni Onegin", 400, "Pushkin");
    Product book2 = new Book(2, "Harry Potter", 300, "Rowling");
    Product book3 = new Book(3, "Dog's heart", 200, "Bulgakov");

    Product smartphone1 = new Smartphone(5, "Iphone 14 Pro Max", 10_000, "Apple");
    Product smartphone2 = new Smartphone(6, "Galaxy 23 Ultra", 20_000, "Samsung");
    Product smartphone3 = new Smartphone(7, "13 Light", 30_000, "Xiaomi");


    @BeforeEach
    public void setup() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
    }


    @Test
    public void test() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);


        Product[] expected = {book1, book2};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testRemoveNotExistedId() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });
    }
    @Test
    public void testRemoveId() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(2);



        Product[] expected = {book1, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findAll() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);



        Product[] expected = {book1, book2, book3, smartphone1, smartphone2,smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void setItems() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.setItems(repo.getItems());



        Product[] expected = {book1, book2, book3, smartphone1, smartphone2,smartphone3};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }


}