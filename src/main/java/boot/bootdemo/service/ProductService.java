package boot.bootdemo.service;

import boot.bootdemo.model.Product;
import java.util.List;

public interface ProductService {
    void saveAll(List<Product> products);
}
