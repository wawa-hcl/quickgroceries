package com.quickgroceries.wallet.service;

import com.quickgroceries.wallet.entityDto.WalletRequestDto;
import com.quickgroceries.wallet.entityDto.WalletResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface WalletService {

    public WalletRequestDto addWallet(long customerUid, WalletRequestDto walletRequestDto);
    public WalletResponseDto getWalletAmount(long customerUid);
    public WalletResponseDto updateWallet(long customerUid);



}
