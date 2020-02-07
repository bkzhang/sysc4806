package App.Controllers;

import App.App;
import App.Models.AddressBook;
import App.Models.AddressBookRepository;
import App.Models.BuddyInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AddressBookController {

    private AddressBookRepository addressBookRepository;

    public AddressBookController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/addressBook")
    public String addressBook(@RequestParam("id") long id, Model model) {
        AddressBook addressBook = this.addressBookRepository.findById(id);

        model.addAttribute("addressBook", addressBook);
        return "addressBook";
    }

    @ResponseBody
    @PostMapping(value = "/newAddressBook", produces = "application/json")
    public AddressBook newAddressBook(Model model) {
        AddressBook addressBook = new AddressBook();
        this.addressBookRepository.save(addressBook);
        return addressBook;
    }
}
