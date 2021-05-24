package com.navdeventerprise.nevdev.data.repository;

import com.navdeventerprise.nevdev.data.entity.AccountEntity;
import com.navdeventerprise.nevdev.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {


    @Query(value = "SELECT * FROM accounts_jsonb.account b WHERE b.accountdata->'widget'->'window'->>'title'  ILIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    List<AccountEntity> findByAccountTitle(String title);


}