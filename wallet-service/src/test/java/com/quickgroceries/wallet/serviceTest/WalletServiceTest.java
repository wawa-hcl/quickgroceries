package com.quickgroceries.wallet.serviceTest;

import com.quickgroceries.wallet.entity.WalletEntity;
import com.quickgroceries.wallet.entityDto.WalletRequestDto;
import com.quickgroceries.wallet.entityDto.WalletResponseDto;
import com.quickgroceries.wallet.repository.WalletRepository;
import com.quickgroceries.wallet.serviceImpl.WalletServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WalletServiceTest {

    @Mock
    WalletRepository walletRepository;
    @InjectMocks
    WalletServiceImpl walletService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void findWalletById() throws Exception {

        WalletEntity wallet = new WalletEntity();
        WalletResponseDto walletResponseDto = new WalletResponseDto();
        wallet.setUidpk(0);
        wallet.setCustomerUid(6);
        wallet.setAmount(675);
        wallet.setCurrency("INR");
        Optional<WalletEntity> walletRepositoryById = walletRepository.findById(6l);
        if (walletRepositoryById.isPresent()) {
            walletRepositoryById.get();
            walletResponseDto.setAmount(wallet.getAmount());
            walletResponseDto.setCurrency(wallet.getCurrency());
            Mockito.when(walletRepository.save(wallet)).thenReturn(wallet);
            assertThat(walletService.getWalletAmount(6l)).isEqualTo(wallet);

        }
    }
    @Test
    public void addWalletTest(){
        WalletEntity walletEntity = new WalletEntity();
        WalletRequestDto walletRequestDto = new WalletRequestDto();
        Mockito.when(walletRepository.save(walletEntity)).thenReturn(walletEntity);
        walletEntity.setCustomerUid(6l);
        walletEntity.setAmount(2344);
        walletEntity.setCurrency("INR");
        walletRequestDto.setAmount(walletEntity.getAmount());
        walletRequestDto.setCurrency(walletEntity.getCurrency());
        assertThat(walletService.addWallet(6l,walletRequestDto)).isEqualTo(walletRequestDto);

    }
    public void updateWallet(){

    }
}
