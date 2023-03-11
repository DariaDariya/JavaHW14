public class Smartphone extends Product {
    private String phoneBrand;

    public Smartphone(int id, String name, int price, String phoneBrand) {
        super(id, name, price);
        this.phoneBrand = phoneBrand;
    }
}