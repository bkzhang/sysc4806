package App.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {

    public AddressBook addressBook;
    public String name;
    public String phoneNum;
    public String address;

    @Before
    public void BeforeEachTest() {
        addressBook = new AddressBook();
        name = "Baby Yoda";
        phoneNum = "838-292-4949";
        address = "3 Tatooine Drive";
    }

    @Test
    public void getAddressBook() {
        addressBook.addBuddyInfo(name, phoneNum);

        assertEquals(1, addressBook.size());
        assertEquals(name, addressBook.getAddressBook().get(0).getName());
        assertEquals(phoneNum, addressBook.getAddressBook().get(0).getPhoneNum());
    }

    @Test
    public void addBuddyInfo() {
        assertEquals(0, addressBook.size());

        BuddyInfo buddyInfo = new BuddyInfo();
        buddyInfo.setName("Sky Lukewalker");
        buddyInfo.setPhoneNum("392-493-2030");
        addressBook.addBuddyInfo(buddyInfo);
        addressBook.addBuddyInfo("Baby Yoda", "838-292-4949");

        assertEquals(2, addressBook.size());
    }
}