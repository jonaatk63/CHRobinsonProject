import com.atkinson.CHRobinsonProject.CountryService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryServiceTest {

    private final CountryService service = new CountryService();

    @Test
    void TestReturnsPathToGuatemala() {
        List<String> result = service.returnRoute("GTM");
        assertEquals(List.of("USA", "MEX", "GTM"), result);
    }
    @Test
    void TestRemoveWhiteSpaceSuccessfully() {
        String string= " GTM ";
        List<String> result = service.returnRoute(string);
        assertEquals(List.of("USA", "MEX", "GTM"), result);
    }
    @Test
    void TestMakeStringUpperCaseSuccessfully() {
        String string = "gtm";
        List<String> result = service.returnRoute(string);
        assertEquals(List.of("USA", "MEX", "GTM"), result);
    }

    @Test
    void TestUsaPathShouldReturnSingleValue() {
        String string = "USA";
        List<String> result = service.returnRoute(string);
        assertEquals(List.of("USA"), result);
    }

}
