package App.WebTests;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        this.mockMvc.perform(post("/newaddressbook"));
        this.mockMvc.perform(get("/addressbook")
                .param("id", "1")).andExpect(status().isOk())
                .andExpect(content().string(containsString("AddressBook")));
    }

    @Test
    public void shouldAddAndRemoveBuddies() throws Exception {
        this.mockMvc.perform(post("/newaddressbook"));
        this.mockMvc.perform(post("/addbuddyinfo")
                .param("bookid", "1")
                .param("name", "john")
                .param("phonenum", "1234567890")
        ).andExpect(status().isOk());
        this.mockMvc.perform(post("/addbuddyinfo")
                .param("bookid", "1")
                .param("name", "nhoj")
                .param("phonenum", "0987654321"))
                .andExpect(status().isOk());
        this.mockMvc.perform(get("/addressbook").param("id", "1"))
                .andExpect(content().string(containsString("john")))
                .andExpect(content().string(containsString("nhoj")));
        this.mockMvc.perform(post("/deletebuddyinfo")
                .param("id", "3"))
                .andExpect(status().isOk());
        this.mockMvc.perform(get("/addressbook?id=1")).andExpect(status().isOk())
                .andExpect(content().string(not(containsString("john"))))
                .andExpect(content().string(containsString("nhoj")));
    }
}
