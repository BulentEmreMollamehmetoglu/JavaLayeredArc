package nLayeredDemo;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.business.concretes.ProductManager;
import nLayeredDemo.core.jLoggerManagerAdapter;
import nLayeredDemo.dataAccess.concretes.AbcProductDao;
import nLayeredDemo.dataAccess.concretes.HibernateProductDao;
import nLayeredDemo.entities.concretes.Product;

public class Main {
    public static void main(String[] args) {
        // entitiler hariç newliyosak bir yerde problem yaşayacağız
        // ToDo : Spring IoC ile çözülecek
        ProductService productService = new ProductManager(new AbcProductDao(),new jLoggerManagerAdapter()); // product manager doğal olarak manager olduğu için oluşturuyoruz
        // sonra db bağlantısı için AbcProductDao veya Hibernate ekleniyo. ProductManager business içinde doğal olarak business kodlarını kontrol ediyor
        // sonra db(abc veya hibernate) için add fonksiyonunu çağırıyor.
        // Obviously product manager is because product manager we created initially and then for the dc connection we have just created new abc or hibernate
        // object in product manager object. Product manager controls business codes and inside the business packet so that's because it controls business part and
        // as the last thing we are just doing for abc or hibernate it calls their functions.
        Product product = new Product(1,2,"Elma",12,50);
        productService.add(product);
    }
}
