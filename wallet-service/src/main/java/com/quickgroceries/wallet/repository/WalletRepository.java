package com.quickgroceries.wallet.repository;

import com.quickgroceries.wallet.entity.WalletEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends CrudRepository<WalletEntity,Long> {
    public WalletEntity findByCustomerUid(long customerUid);


}
