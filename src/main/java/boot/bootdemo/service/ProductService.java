package boot.bootdemo.service;

import boot.bootdemo.model.Product;
import boot.bootdemo.model.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    void saveAll(List<Product> products);

    List<ProductResponseDto> findMostCommented(int quantity);
}
