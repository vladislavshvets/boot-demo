package boot.bootdemo.repository;

import boot.bootdemo.model.Product;
import boot.bootdemo.model.dto.ProductResponseDto;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT new boot.bootdemo.model.dto.ProductResponseDto(p.productId) "
            + "FROM Review r "
            + "JOIN r.product p "
            + "GROUP BY p.id "
            + "ORDER BY COUNT(p) DESC, p.id DESC")
    List<ProductResponseDto> findMostCommented(Pageable pageable);
}
