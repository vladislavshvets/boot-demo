package boot.bootdemo.model.mapper;

import boot.bootdemo.model.Product;
import boot.bootdemo.model.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product map(ReviewDto reviewDto) {
        Product product = new Product();
        product.setExternalId(reviewDto.getProductId());
        return product;
    }
}
