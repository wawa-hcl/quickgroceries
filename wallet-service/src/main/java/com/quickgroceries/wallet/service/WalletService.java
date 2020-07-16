package com.quickgroceries.wallet.service;
import com.quickgroceries.wallet.exceptions.WalletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quickgroceries.wallet.entity.WalletEntity;
import com.quickgroceries.wallet.repository.WalletRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class WalletService {
	
	@Autowired
	WalletRepository walletRepository;
	
	@Transactional
	public WalletEntity addMoney(WalletEntity walletEntity) throws WalletException {
		
		WalletEntity wallet = walletRepository.save(walletEntity);
		return wallet;
	}
	@Transactional
	public WalletEntity getWalletById (int uidpk) {
		 return walletRepository.findById(uidpk)
				 .orElseThrow(()-> new WalletException("Please enter Valid userId", 404));
   
	}
	
	
	 @Transactional public double updateWallet(double orderAmount,WalletEntity walletEntity) throws
	  WalletException { double updatedWallet = 0; try { updatedWallet =
	 walletEntity.getAmount()-orderAmount; } catch (WalletException e) {
	 e.setMessage("Please enter valid amount"); } return updatedWallet; }
	 
}
