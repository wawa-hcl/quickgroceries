package com.quickgroceries.wallet.entityDto;

import com.quickgroceries.wallet.entity.WalletEntity;
import org.springframework.core.convert.converter.Converter;

public class WalletEntityRequest implements Converter<WalletEntity,WalletEntityDto> {

    WalletEntityDto walletEntityDto;

    @Override
    public WalletEntityDto convert(WalletEntity walletEntity) {
        return null;
    }
}
