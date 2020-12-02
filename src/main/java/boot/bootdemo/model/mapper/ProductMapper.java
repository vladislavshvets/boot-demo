package boot.bootdemo.model.mapper;

import boot.bootdemo.model.Product;
import boot.bootdemo.model.dto.ProductResponseDto;
import boot.bootdemo.model.dto.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product mapReviewDtoToProduct(ReviewDto dto) {
        return Product.builder()
                .productId(dto.getProductId())
                .build();
    }

    public ProductResponseDto mapProductToResponseDto(Product product) {
        return ProductResponseDto.builder()
                .productId(product.getProductId())
                .build();
    }
}
