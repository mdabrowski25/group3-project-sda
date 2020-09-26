import org.junit.jupiter.api.Test;
import pl.sdacademy.ApiDataProvider;
import pl.sdacademy.WorldCoronaPeople;


public class ApiDataProviderTest {

    @Test
    void apiDataProviderTest(){
        ApiDataProvider apiDataProvider = new ApiDataProvider();
        WorldCoronaPeople worldCoronaPeople = apiDataProvider.get();
        System.out.println(worldCoronaPeople.getResult().toString());
    }

}
