package model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double priceProduct;
    private String production;

    public Product() {
    }

    public Product(String nameProduct, double priceProduct, String production) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.production = production;
    }

    public Product(int idProduct, String nameProduct, double priceProduct, String production) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.production = production;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }
}
