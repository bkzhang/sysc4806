package App.WebTests;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import App.App;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class WebApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnAddressBookView() throws Exception {
        this.mockMvc.perform(post("/newAddressBook"));
        this.mockMvc.perform(get("/addressBook?id=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("AddressBook")));
    }
}
