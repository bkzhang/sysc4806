package App.Models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "buddyinfo", path = "buddyinfos")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByName(@Param("name") String name);
    List<BuddyInfo> findByPhoneNum(@Param("phonenum") String phoneNum);

    BuddyInfo findById(@Param("id") long id);

    void deleteById(Integer id);
}
