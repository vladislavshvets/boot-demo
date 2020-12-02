package boot.bootdemo.controller;

import boot.bootdemo.model.dto.ProductResponseDto;
import boot.bootdemo.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static final String PAGE_SIZE = "1000";
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/most-commented")
    public List<ProductResponseDto> getMostCommented(
            @RequestParam(defaultValue = PAGE_SIZE) int quantity) {
        return productService.findMostCommented(quantity);
    }
}
