package service;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository repository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(Product product) {
        repository.create(product);
    }

    @Override
    public void edit(Product product) {
        repository.edit(product);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Product> sortByName(String name) {
        return repository.sortByName(name);
    }
}
