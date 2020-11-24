package boot.bootdemo.service.impl;

import boot.bootdemo.model.Product;
import boot.bootdemo.repository.ProductRepository;
import boot.bootdemo.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveAll(List<Product> products) {
        productRepository.saveAll(products);
    }
}
