package com.quickgroceries.wallet.service;

import com.quickgroceries.wallet.entity.WalletEntity;
import com.quickgroceries.wallet.entityDto.CartResponseDto;
import com.quickgroceries.wallet.entityDto.WalletRequestDto;
import com.quickgroceries.wallet.entityDto.WalletResponseDto;
import com.quickgroceries.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface WalletService {

    public WalletRequestDto addWallet(long customerUid, WalletRequestDto walletRequestDto);
    public WalletEntity getWalletAmount(long customerUid);
    public WalletResponseDto updateWallet(long customerUid);



}
