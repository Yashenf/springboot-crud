package com.yashe.pos.HelloPos.repo;

import com.yashe.pos.HelloPos.entity.Customer;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {
    Customer findCustomerById(int id);

    @Query(value = "SELECT * FROM customer WHERE name LIKE %?1% OR address LIKE %?1%", nativeQuery = true)
    List<Customer> findAllByNameOrAddress(String name, Pageable pageable);

    @Query(value = "SELECT COUNT(id) FROM customer WHERE name LIKE %?1% OR address LIKE %?1%", nativeQuery = true)
    int countDataWithSearchText(String searchText);
}
