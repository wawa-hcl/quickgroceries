package com.quickgroceries.wallet.serviceImpl;
import com.quickgroceries.wallet.entity.WalletEntity;
import com.quickgroceries.wallet.entityDto.CartResponseDto;
import com.quickgroceries.wallet.entityDto.WalletRequestDto;
import com.quickgroceries.wallet.entityDto.WalletResponseDto;
import com.quickgroceries.wallet.repository.WalletRepository;
import com.quickgroceries.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;

    public WalletRequestDto addWallet(long customerUid, WalletRequestDto walletRequestDto)  {

        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setCustomerUid(customerUid);
        double balance = walletEntity.getAmount();
        balance = balance + walletRequestDto.getAmount();
        walletEntity.setAmount(walletRequestDto.getAmount());
        walletEntity.setCurrency(walletRequestDto.getCurrency());
        walletRepository.save(walletEntity);
        return walletRequestDto;
    }

    public WalletEntity getWalletAmount(long customerUid) {
        WalletResponseDto walletResponseDto = new WalletResponseDto();
        return walletRepository.findByCustomerUid(customerUid);
    }

    public WalletResponseDto updateWallet(long customerUid) {
        WalletEntity walletEntity = new WalletEntity();
        WalletResponseDto walletResponseDto = new WalletResponseDto();
        CartResponseDto cartResponseDto = new CartResponseDto();
        walletRepository.findByCustomerUid(customerUid);
        if (cartResponseDto.getAmount() > 0) {
            double updatedWallet = walletEntity.getAmount() - cartResponseDto.getAmount();
            walletResponseDto.setAmount(updatedWallet);
            walletResponseDto.setCurrency(walletEntity.getCurrency());
        }
        return walletResponseDto;


    }

}
