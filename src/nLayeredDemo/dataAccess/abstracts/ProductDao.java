package nLayeredDemo.dataAccess.abstracts;

import nLayeredDemo.entities.concretes.Product;

import java.util.List;

public interface ProductDao {
    void add(Product product);
    void update(Product product);
    void delete(Product product);
    Product get(int id);// geriye ürün döndürüyor
    List<Product> getAll();
}
