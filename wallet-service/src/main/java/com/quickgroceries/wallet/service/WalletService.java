package com.quickgroceries.wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quickgroceries.wallet.entity.WalletEntity;
import com.quickgroceries.wallet.repository.WalletRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class WalletService {
  WalletRepository walletRepository;
	public WalletEntity addWallet (WalletEntity walletEntity){
		System.out.println(walletEntity);
		return walletRepository.save(walletEntity);
	}
}