package yooni.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yooni.spring.domain.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}