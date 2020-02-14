package App.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BuddyInfo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phoneNum;
    private Long bookId;

    @JsonBackReference
    @ManyToOne
    private AddressBook addressBook;

    public BuddyInfo() {}

    public BuddyInfo(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return this.bookId;
    }

    public void setBookId(Long id) {
        this.bookId = id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNum;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }
}
