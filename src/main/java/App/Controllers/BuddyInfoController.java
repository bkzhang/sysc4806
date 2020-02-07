package App.Controllers;

import App.App;
import App.Models.AddressBook;
import App.Models.AddressBookRepository;
import App.Models.BuddyInfo;
import App.Models.BuddyInfoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BuddyInfoController {
    private AddressBookRepository addressBookRepository;
    private BuddyInfoRepository buddyInfoRepository;

    public BuddyInfoController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @ResponseBody
    @PostMapping(value = "/add_buddyinfo", produces = "application/json")
    public AddressBook addBuddy(@RequestParam("id") long id, @RequestParam(value = "name") String name, @RequestParam(value = "phonenum") String phoneNum) {
        AddressBook addressBook = this.addressBookRepository.findById(id);
        BuddyInfo buddyInfo = new BuddyInfo(name, phoneNum);
        addressBook.addBuddyInfo(buddyInfo);
        this.addressBookRepository.save(addressBook);

        return addressBook;
    }

    @ResponseBody
    @PostMapping(value = "/delete_buddyinfo", produces = "application/json")
    @Transactional
    public void deleteBuddyInfo(@RequestParam("id") long id) {
        BuddyInfo buddy = this.buddyInfoRepository.findById(id);
        AddressBook addressBook = buddy.getAddressBook();
        addressBook.removeBuddyInfo(id);
        this.buddyInfoRepository.deleteById(id);
        this.addressBookRepository.save(addressBook);
    }
}
