package boot.bootdemo.model.mapper;

import boot.bootdemo.model.Product;
import boot.bootdemo.model.dto.ReviewDto;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class ProductMapperTest {
    private static final ProductMapper productMapper =
            new ProductMapper();
    private static final String PRODUCT_ID = "B001E4KFG0";
    private static ReviewDto emptyDto = new ReviewDto();
    private static ReviewDto reviewDtoOk;
    private static ReviewDto reviewDtoWithoutProduct;

    @BeforeAll
    public static void beforeAll() throws Exception {
        reviewDtoOk = new ReviewDto();
        reviewDtoOk.setId(1L);
        reviewDtoOk.setProductId(PRODUCT_ID);
        reviewDtoOk.setUserId("A3SGXH7AUHU8GW");
        reviewDtoOk.setProfileName("delmartian");
        reviewDtoOk.setHelpfulnessNumerator(1);
        reviewDtoOk.setHelpfulnessDenominator(1);
        reviewDtoOk.setScore(5);
        reviewDtoOk.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(
                1346976000L), ZoneId.systemDefault()));
        reviewDtoOk.setSummary("Good Quality Dog Food");
        reviewDtoOk.setText("I have bought several of the Vitality canned dog food products");

        reviewDtoWithoutProduct = new ReviewDto();
        reviewDtoWithoutProduct.setId(2L);
        reviewDtoWithoutProduct.setUserId("A1D87F6ZCVE5NK");
        reviewDtoWithoutProduct.setProfileName("dll pa");
        reviewDtoWithoutProduct.setHelpfulnessNumerator(0);
        reviewDtoWithoutProduct.setHelpfulnessDenominator(0);
        reviewDtoWithoutProduct.setScore(1);
        reviewDtoWithoutProduct.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(
                1346976000L), ZoneId.systemDefault()));
        reviewDtoWithoutProduct.setSummary("Not as Advertised");
        reviewDtoWithoutProduct.setText("Product arrived labeled as Jumbo Salted Peanuts...");
    }

    @Test
    public void mapOk() {
        Product expected = new Product(PRODUCT_ID);
        Product actual = productMapper.map(reviewDtoOk);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mapEmptyDto() {
        Product expected = new Product();
        Product actual = productMapper.map(emptyDto);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mapDtoWithoutProduct() {
        Product expected = new Product();
        Product actual = productMapper.map(reviewDtoWithoutProduct);
        Assert.assertEquals(expected, actual);
    }
}
