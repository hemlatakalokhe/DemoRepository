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
    }
    public String getName() {
        return this.name;
    }
    public void setName(final String name) {
        this.name = name;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(final double price) {
        this.price = price;

        System.out.println("Hello World");

    }



}
