package App.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "addressBook", cascade = CascadeType.ALL)
    private List<BuddyInfo> addressBook;

    public AddressBook() {
        addressBook = new ArrayList<BuddyInfo>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BuddyInfo> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(List<BuddyInfo> addressBook) {
        this.addressBook = addressBook;
    }

    public int size() {
        return addressBook.size();
    }

    public void addBuddyInfo(String name, String phoneNum) {
        BuddyInfo buddyInfo = new BuddyInfo();
        buddyInfo.setName(name);
        buddyInfo.setPhoneNum(phoneNum);
        addressBook.add(buddyInfo);
    }

    public void addBuddyInfo(BuddyInfo buddyInfo) {
        addressBook.add(buddyInfo);
    }

    public List<BuddyInfo> getBuddyInfo() {
        return this.getAddressBook();
    }

    public void removeBuddyInfo(Long id) {
        for (int i = 0; i < this.addressBook.size(); i++) {
            if (this.addressBook.get(i).getId() == id) {
                this.addressBook.remove(i);
            }
        }
    }

    public String toString() {
        String str = "";

        for (int i = 0; i < addressBook.size(); i++) {
            str += addressBook.get(i).toString() + "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddyInfo("John Smith", "123-456-7890");
        addressBook.addBuddyInfo("Renee Locke", "098-765-4321");

        System.out.println("The following buddy infos are in the address book:");
        System.out.println(addressBook.toString());
    }
}
