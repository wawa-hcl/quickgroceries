package com.quickgroceries.wallet.controllerTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quickgroceries.wallet.controller.WalletController;
import com.quickgroceries.wallet.entityDto.WalletRequestDto;
import com.quickgroceries.wallet.entityDto.WalletResponseDto;
import com.quickgroceries.wallet.service.WalletService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = WalletController.class)
public class WalletControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WalletService walletService;
    private ObjectMapper objectMapper= new ObjectMapper();
    @InjectMocks
    private WalletController walletController;
    @Mock
    private WalletRequestDto walletRequestDto;


    public static void setUp() throws Exception {

    }
    @Test
    @DisplayName("Test findWallet with valid customer UID")
    public void findWalletByUid() throws Exception {
       when(walletService.getWalletAmount(anyLong())).thenReturn(new WalletResponseDto());
        mockMvc.perform(get("/customer/wallet/1/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(walletService,times(1)).getWalletAmount(1);
    }

    @Test
    @DisplayName("Test findWallet with valid walletId but not present")
    public void findWalletByUId_WhenUIdIsNotPresent() throws Exception {
        WalletResponseDto wallet = walletService.getWalletAmount(anyLong());
        when(walletService.getWalletAmount(Mockito.anyLong())).thenReturn(new WalletResponseDto());
        mockMvc.perform(get("/customer/wallet/{customerUid}/","999")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }
    @Test
    @DisplayName("Test findWallet with invalid walletId")
    public void findWalletByUId_WhenIdIsInValid() throws Exception {
        when(walletService.getWalletAmount(Mockito.anyLong())).thenReturn(new WalletResponseDto());
        mockMvc.perform(get("/customer/wallet/{customerUid}/",233d)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
    @Test
    @DisplayName("Test findWallet with invalid walletId")
    public void testAddWallet() throws Exception{
        WalletRequestDto walletRequestDto = new WalletRequestDto();
        walletRequestDto.setAmount(3546);
        walletRequestDto.setCurrency("INR");
        String inputInJson = this.mapToJson(walletRequestDto);
        when(walletService.addWallet(23L,walletRequestDto)).thenReturn(walletRequestDto);
        mockMvc.perform(post("/customer/wallet/{customerUid}","23")
        .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(walletRequestDto))
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        verify(walletService).addWallet(23L,walletRequestDto);
}

    @Test
    @DisplayName("Test createUser with Invalid request")
    public void testWalletWithInvalidId() throws Exception{
        WalletRequestDto walletRequestDto = new WalletRequestDto();
        walletRequestDto.setAmount(3546);
        walletRequestDto.setCurrency("INR");
        String inputInJson = this.mapToJson(walletRequestDto);
        when(walletService.addWallet(23L,walletRequestDto)).thenReturn(walletRequestDto);
        mockMvc.perform(post("/customer/wallet/{customerUid}","23")
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .characterEncoding("utf-8")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        verify(walletService).addWallet(23L,walletRequestDto);

    }
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

}

