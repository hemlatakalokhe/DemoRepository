package biz.dss.dao;

/*@Component*/
public class Product {
    private int id;
    private String name;
    private double price;
    public int getId() {

        return this.id;
    }

    public void setId(final int id) {
        System.out.println("Hello World");
        this.id = id;
        System.out.println("Hello World");
    }
    public String getName() {
        System.out.println("Hello World");
        return this.name;
    }
    public void setName(final String name) {
        System.out.println("Hello World");
        this.name = name;
    }
    public double getPrice() {
        System.out.println("Hello World");
        return this.price;
    }
    public void setPrice(final double price) {
        System.out.println("Hello World");
        this.price = price;
    }
}
