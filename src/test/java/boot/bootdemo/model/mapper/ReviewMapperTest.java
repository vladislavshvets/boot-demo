package boot.bootdemo.model.mapper;

import boot.bootdemo.model.Review;
import boot.bootdemo.model.dto.ReviewDto;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReviewMapperTest {
    private static ReviewMapper reviewMapper = new ReviewMapper();
    private static ReviewDto emptyDto = new ReviewDto();
    private static ReviewDto reviewDtoOk = new ReviewDto();

    @BeforeAll
    public static void beforeAll() throws Exception {
        reviewMapper = new ReviewMapper();
        reviewDtoOk = new ReviewDto();
        reviewDtoOk.setId(1L);
        reviewDtoOk.setProductId("B001E4KFG0");
        reviewDtoOk.setUserId("A3SGXH7AUHU8GW");
        reviewDtoOk.setProfileName("delmartian");
        reviewDtoOk.setHelpfulnessNumerator(1);
        reviewDtoOk.setHelpfulnessDenominator(1);
        reviewDtoOk.setScore(5);
        reviewDtoOk.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(
                1303862400L), ZoneId.systemDefault()));
        reviewDtoOk.setSummary("Good Quality Dog Food");
        reviewDtoOk.setText("I have bought several of the Vitality canned dog food products");
    }

    @Test
    public void mapDtoOk() {
        Review expected = new Review();
        expected.setHelpfulnessNumerator(1L);
        expected.setHelpfulnessDenominator(1L);
        expected.setScore(5L);
        expected.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(
                1303862400L), ZoneId.systemDefault()));
        expected.setSummary("Good Quality Dog Food");
        expected.setText("I have bought several of the Vitality canned dog food products");
        Review actual = reviewMapper.map(reviewDtoOk);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mapEmptyOk() {
        Review expected = new Review();
        Review actual = reviewMapper.map(emptyDto);
        Assert.assertEquals(expected, actual);
    }

}
