package com.quickgroceries.delivery.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.quickgroceries.delivery.entity.Delivery;
import com.quickgroceries.delivery.model.CartItemsDto;
import com.quickgroceries.delivery.model.Order;
import com.quickgroceries.delivery.model.ResponseDto;
import com.quickgroceries.delivery.repository.DeliveryRepository;




@RunWith(SpringRunner.class)
@SpringBootTest
class DeliveryServiceImplTest {
	
	@Autowired
	private DeliveryService deliveryService;

	@MockBean
	private DeliveryRepository deliveryRepository;


	@Test
	public void testCreateDelivery() {
		Delivery mockDelivery= new Delivery();
		List<Order> mockOrder= (List<Order>) new Order();
		((Order) mockOrder).setOrderId("uo787798hlp");
		ResponseDto mockResponseDto=  new ResponseDto();
		CartItemsDto mockCartItemsDto= new CartItemsDto();
		List <CartItemsDto> mockCartItems= new ArrayList<>();
		mockResponseDto.setCartID(1l);
		mockResponseDto.setCustomerID(2l);
		mockResponseDto.setCart_amount(20.45);
		mockCartItemsDto.setProductID(1l);
		mockCartItemsDto.setQuantity(10);
		mockCartItems.add(mockCartItemsDto);
		mockResponseDto.setCartItems(mockCartItems);
		((Order) mockOrder).setOrderDetails(mockResponseDto);
		com.quickgroceries.delivery.model.State state=com.quickgroceries.delivery.model.State.READYFORFULLFILLMENT;
		((Order) mockOrder).setOrderState(state);
		mockDelivery.setDeliveryId("gh78549kpky");
		mockDelivery.setDeliveryDetails( (Order) mockOrder);
		Mockito.when(deliveryRepository.save(mockDelivery)).thenReturn(mockDelivery);

	    assertThat(deliveryService.createDelivery(mockDelivery)).isEqualTo(mockDelivery);
		
	}

}
