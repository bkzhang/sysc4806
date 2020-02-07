package App.Models;

import org.junit.Test;

import javax.persistence.*;
import java.util.List;

public class BuddyInfoPersistenceTest {

    @Test
    public void testBuddyInfoPersistence() {
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

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(buddyInfo1);
        em.persist(buddyInfo2);

        tx.commit();

        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of buddy infos\n-------------");

        for (BuddyInfo bi : results) {
            System.out.println(bi.getName() + " (id=" + bi.getId() + ")");
        }

        em.close();
        emf.close();
    }
}