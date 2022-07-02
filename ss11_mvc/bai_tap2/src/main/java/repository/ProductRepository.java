package repository;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    List<Product> products = new ArrayList<>();
    BaseRepositoryProduct baseRepositoryProduct = new BaseRepositoryProduct();

    private static final String FIND_ALL = "select * from product";
    private static final String CREATE_PRODUCT = "insert into product(name,price,production) " +
            " values(?,?,?)";
    private static final String EDIT_PRODUCT = "update product set name = ?, price = ?, production = ? where id = ?";
    private static final String FIND_ID = "select * from product where id = ?";
    private static final String FIND_NAME = "select * from product where name like ?";
    private static final String DELETE_PRODUCT = "delete from product where id = ?";
    private static final String SORT_BY_NAME = "select * from product order by name";

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();

        try {
            Connection connection = baseRepositoryProduct.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getInt("price");
                String production = resultSet.getString("production");

                Product product = new Product(id, name, price, production);

                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void create(Product product) {

        try {
            Connection connection = baseRepositoryProduct.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setInt(2, (int) product.getPriceProduct());
            preparedStatement.setString(3, product.getProduction());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Product product) {

        try {
            Connection connection = baseRepositoryProduct.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_PRODUCT);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setInt(2, (int) product.getPriceProduct());
            preparedStatement.setString(3, product.getProduction());
            preparedStatement.setInt(4, product.getIdProduct());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = baseRepositoryProduct.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Product findById(int id) {

        Product product = null;
        try {
            Connection connection = baseRepositoryProduct.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idS = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getInt("price");
                String production = resultSet.getString("production");

                product = new Product(idS, name, price, production);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findByName(String name) {
        products.clear();
        try {
            Connection connection = baseRepositoryProduct.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String nameS = resultSet.getString("name");
                double price = Double.parseDouble(resultSet.getString("price"));
                String production = resultSet.getString("production");

                Product product = new Product(id, nameS, price, production);

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> sortByName(String name) {
        products.clear();
        try {
            Connection connection = baseRepositoryProduct.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SORT_BY_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameS = resultSet.getString("name");
                double price = resultSet.getInt("price");
                String production = resultSet.getString("production");

                Product product = new Product(id, nameS, price, production);

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
