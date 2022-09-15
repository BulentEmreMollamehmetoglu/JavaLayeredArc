package nLayeredDemo.business.concretes;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.core.LoggerService;
import nLayeredDemo.dataAccess.abstracts.ProductDao;

import nLayeredDemo.entities.concretes.Product;

import java.util.List;

public class ProductManager implements ProductService {

    private ProductDao productDao; // hibernate referansı tutabilir. //
    //j logger injection edilmeyecek bağlı olmamak adına zaten interfacei de yok
    // kendi interface imizi yazıcaz logger servisini kullanmak için
    // adaptasyon kullanıcaz
    private LoggerService loggerService;
    public ProductManager(ProductDao productDao,LoggerService loggerService) {
        this.productDao = productDao;
        this.loggerService = loggerService;
    }

    @Override
    public void add(Product product) {
        // iş kodları
        if(product.getCategoryId() == 1){
            System.out.println("Product is not accessed in this category");
            return;
        }
        this.productDao.add(product);
        this.loggerService.logToSystem("Product has been added " + product.getName());
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
