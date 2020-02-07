package App.Models;

import org.junit.Test;

import javax.persistence.*;
import java.util.List;

public class AddressBookPersistenceTest {

    @Test
    public void testAddressBookPersistenceTest() {
        String name1 = "Baby Yoda";
        String phoneNum1 = "838-292-4949";
        BuddyInfo buddyInfo1 = new BuddyInfo();
        buddyInfo1.setName(name1);
        buddyInfo1.setPhoneNum(phoneNum1);

        String name2 = "Han Dual";
        String phoneNum2 = "392-493-4503";
        BuddyInfo buddyInfo2 = new BuddyInfo();
        buddyInfo2.setName(name2);
        buddyInfo2.setPhoneNum(phoneNum2);

        AddressBook addressBook = new AddressBook();
        addressBook.addBuddyInfo(buddyInfo1);
        addressBook.addBuddyInfo(buddyInfo2);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(addressBook);

        tx.commit();

        Query q = em.createQuery("SELECT a FROM AddressBook a");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        System.out.println("List of buddy infos\n-------------");

        for (AddressBook ab : results) {
            for (BuddyInfo bi : ab.getAddressBook())
                System.out.println(bi.getName() + " (id=" + bi.getId() + ")");
        }

        em.close();
        emf.close();
    }
}