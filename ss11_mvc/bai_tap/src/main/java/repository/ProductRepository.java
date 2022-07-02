package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Coconut", 12000, 3, "Ben Tre"));
        productList.add(new Product(2, "Watermelon", 5000, 5, "Gia Lai"));
        productList.add(new Product(3, "Bean", 7000, 12, "Ninh Thuan"));
        productList.add(new Product(4, "Dragon Green", 15000, 6, "Binh Thuan"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id - 1);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchProduct = new ArrayList<>();
        for (Product item : productList) {
            if (item.getName().contains(name)) {
                searchProduct.add(item);
            }
        }
        return searchProduct;
    }

    @Override
    public void update(int id, Product product) {
        productList.set(id - 1, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id-1);
    }
}
