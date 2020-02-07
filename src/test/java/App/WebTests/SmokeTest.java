package App.WebTests;

import static org.assertj.core.api.Assertions.assertThat;

import App.Controllers.AddressBookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private AddressBookController addressBookController;

    @Test
    public void contexLoads() throws Exception {
        assertThat(addressBookController).isNotNull();
    }
}