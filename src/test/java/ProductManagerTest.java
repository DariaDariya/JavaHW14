import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);
    private Product book1 = new Book(1, "Eugeni Onegin", 400, "Pushkin");
    private Product book2 = new Book(2, "Harry Potter", 300, "Rowling");
    private Product book3 = new Book(3, "Dog's heart", 200, "Bulgakov");

    private Product smartphone1 = new Smartphone(5, "Iphone 13 Pro Max", 10_000, "Apple");
    private Product smartphone2 = new Smartphone(6, "Galaxy 23 Ultra", 20_000, "Samsung");
    private Product smartphone3 = new Smartphone(7, "13 Light", 30_000, "Xiaomi");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }
    @Test
    public void shouldAddNewProduct() {
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchBySmartphoneName() {
        Product[] expected = new Product[] {smartphone3};
        Product[] actual = manager.searchBy("Light");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByUnknowSmartphoneName() {
        Product[] expected = new Product[] {};
        Product[] actual = manager.searchBy("Iphone 14");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByTwoSmartphoneNames() {
        Product[] expected = new Product[] {smartphone1, smartphone3};
        Product[] actual = manager.searchBy("13");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindSmartphoneByTwoOptions() {
        Product[] expected = new Product[] {smartphone1};
        Product[] actual = manager.searchBy("Iphone 13 Pro Max");
        Product[] actual2 = manager.searchBy("Apple");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookName() {
        Product[] expected = new Product[] {book2};
        Product[] actual = manager.searchBy("Harry");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindUnknowBookName() {
        Product[] expected = new Product[] {};
        Product[] actual = manager.searchBy("Captain Daughter");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindBookByTwoOptions() {
        Product[] expected = new Product[] {book2};
        Product[] actual = manager.searchBy("Harry");
        Product[] actual2 = manager.searchBy("Rowling");
        Assertions.assertArrayEquals(expected, actual);
    }



}