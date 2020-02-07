package App.Models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    public BuddyInfo buddyInfo;
    public String name;
    public String phoneNum;

    @Before
    public void BeforeEachTest() {
        name = "Baby Yoda";
        phoneNum = "838-292-4949";
        buddyInfo = new BuddyInfo();
        buddyInfo.setName(name);
        buddyInfo.setPhoneNum(phoneNum);
    }

    @Test
    public void getName() {
        assertEquals(name, buddyInfo.getName());
    }

    @Test
    public void getPhoneNum() {
        assertEquals(phoneNum, buddyInfo.getPhoneNum());
    }

    @Test
    public void setName() {
        String newName = "Grandmaster Yoda";
        buddyInfo.setName(newName);

        assertEquals(newName, buddyInfo.getName());
    }

    @Test
    public void setPhoneNum() {
        String newPhoneNum = "120-2093-2939";
        buddyInfo.setPhoneNum(newPhoneNum);

        assertEquals(newPhoneNum, buddyInfo.getPhoneNum());
    }

    @Test
    public void testToString() {
        String expected = "Name: " + name + ", Phone Number: " + phoneNum;

        assertEquals(expected, buddyInfo.toString());
    }
}