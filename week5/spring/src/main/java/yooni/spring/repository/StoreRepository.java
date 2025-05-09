package yooni.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yooni.spring.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}