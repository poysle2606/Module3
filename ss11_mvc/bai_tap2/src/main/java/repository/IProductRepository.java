package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void create(Product product);

    void edit(Product product);

    void delete(int id);

    Product findById(int id);

    List<Product> findByName(String name);

    List<Product> sortByName(String name);
}
