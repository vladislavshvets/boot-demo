package boot.bootdemo.model.mapper;

import boot.bootdemo.model.Role;
import boot.bootdemo.model.User;
import boot.bootdemo.model.dto.ReviewDto;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserMapperTest {
    private static final String DEFAULT_PASSWORD = "1111";
    private static final String ROLE_NAME = "USER";
    private static final UserMapper userMapper = new UserMapper();
    private static ReviewDto emptyDto = new ReviewDto();
    private static ReviewDto reviewDtoOk;
    private static ReviewDto reviewDtoWithoutUser;

    @BeforeAll
    public static void beforeAll() throws Exception {
        reviewDtoOk = new ReviewDto();
        reviewDtoOk.setId(1L);
        reviewDtoOk.setProductId("B001E4KFG0");
        reviewDtoOk.setUserId("A3SGXH7AUHU8GW");
        reviewDtoOk.setProfileName("delmartian");
        reviewDtoOk.setHelpfulnessNumerator(1);
        reviewDtoOk.setHelpfulnessDenominator(1);
        reviewDtoOk.setScore(5);
        reviewDtoOk.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(
                1346976000L), ZoneId.systemDefault()));
        reviewDtoOk.setSummary("Good Quality Dog Food");
        reviewDtoOk.setText("I have bought several of the Vitality canned dog food products");

        reviewDtoWithoutUser = new ReviewDto();
        reviewDtoWithoutUser.setId(2L);
        reviewDtoWithoutUser.setProductId("B001E4KFG0");
        reviewDtoWithoutUser.setHelpfulnessNumerator(0);
        reviewDtoWithoutUser.setHelpfulnessDenominator(0);
        reviewDtoWithoutUser.setScore(1);
        reviewDtoWithoutUser.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(
                1346976000L), ZoneId.systemDefault()));
        reviewDtoWithoutUser.setSummary("Not as Advertised");
        reviewDtoWithoutUser.setText("Product arrived labeled as Jumbo Salted Peanuts...");
    }

    @Test
    public void mapOk() {
        User expected = new User();
        expected.setExternalId("A3SGXH7AUHU8GW");
        expected.setProfileName("delmartian");
        expected.setPassword(DEFAULT_PASSWORD);
        expected.setRoles(Set.of(Role.of(ROLE_NAME)));
        User actual = userMapper.map(reviewDtoOk);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mapEmptyDto() {
        User expected = new User();
        expected.setPassword(DEFAULT_PASSWORD);
        expected.setRoles(Set.of(Role.of(ROLE_NAME)));
        User actual = userMapper.map(emptyDto);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mapDtoWithoutUser() {
        User expected = new User();
        expected.setPassword(DEFAULT_PASSWORD);
        expected.setRoles(Set.of(Role.of(ROLE_NAME)));
        User actual = userMapper.map(reviewDtoWithoutUser);
        Assert.assertEquals(expected, actual);
    }

}
