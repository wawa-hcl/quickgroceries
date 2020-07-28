package com.quickgroceries.cart.service.impl;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.quickgroceries.cart.entity.Cart;
import com.quickgroceries.cart.entity.CartItem;
import com.quickgroceries.cart.entity.State;
import com.quickgroceries.cart.model.Action;
import com.quickgroceries.cart.model.CartItemsDto;
import com.quickgroceries.cart.model.RequestDto;
import com.quickgroceries.cart.model.ResponseDto;
import com.quickgroceries.cart.repository.CartItemRepository;
import com.quickgroceries.cart.repository.CartRepository;
import com.quickgroceries.cart.service.CartService;




@RunWith(SpringRunner.class)
@WebMvcTest(CartServiceImpl.class)
class CartServiceImplTest {
	
	@MockBean
	CartService cartService;
	
	@MockBean
	CartRepository cartRepository;
	
	@MockBean
	CartItemRepository cartItemRepository;

	@Test
	void testAddCartAndItemsBycustomerUid_newItemAdded() {
		
		RequestDto mockDto = new RequestDto();
		mockDto.setProduct_id(1l);
		mockDto.setQuantity(2);
		mockDto.setAction(Action.ADD);
		
		CartItem cartItem=new CartItem();
		cartItem.setUidpk(1l);
		cartItem.setProductUid(1l);
		cartItem.setQuantity(2);
		
		Mockito.when(cartItemRepository.save(cartItem)).thenReturn(cartItem);
		
		assertThat(cartService.addCartAndItemsBycustomerUid(Mockito.anyLong(), mockDto)).isEqualTo(1);
		
	}
	
	
	@Test
	void testAddCartAndItemsBycustomerUid_newCartAdded() {
		
		RequestDto mockDto = new RequestDto();
		Cart cart=new Cart();
		cart.setCartUidpk(1l);
		cart.setCustomerUid(11l);
		cart.setState(State.OPEN);
		
		CartItem cartItem=new CartItem();
		cartItem.setUidpk(1l);
		cartItem.setProductUid(1l);
		cartItem.setQuantity(2);
		cartItem.setCart(cart);
		List<CartItem> l=new ArrayList<CartItem>();
		cart.setCartItem(l);
		
		Mockito.when(cartRepository.save(cart)).thenReturn(cart);
		assertThat(cartService.addCartAndItemsBycustomerUid(11l, mockDto)).isEqualTo(1);
	}
	
	
	@Test
	void testUpdateCartAndItemsBycustomerUid_addQuantity() {
		
		RequestDto mockDto = new RequestDto();
		mockDto.setProduct_id(1l);
		mockDto.setQuantity(2);
		mockDto.setAction(Action.UPDATE);
		
		CartItem cartItem=new CartItem();
		
		cartItem.setQuantity(4);
		
		Mockito.when(cartItemRepository.save(cartItem)).thenReturn(cartItem);
		assertThat(cartService.updateCartAndItemsBycustomerUid(Mockito.anyLong(), mockDto)).isEqualTo(1);
		
	}
	
	
	@Test
	void testUpdateCartAndItemsBycustomerUid_deleteQuantity() {
		
		RequestDto mockDto = new RequestDto();
		mockDto.setProduct_id(1l);
		mockDto.setQuantity(1);
		mockDto.setAction(Action.DELETE);
		
		CartItem cartItem=new CartItem();
		
		cartItem.setQuantity(1);
		
		Mockito.when(cartItemRepository.save(cartItem)).thenReturn(cartItem);
		assertThat(cartService.updateCartAndItemsBycustomerUid(Mockito.anyLong(), mockDto)).isEqualTo(1);
		
	}
	
	/*
	 * @Test void testClearCartIemsByCustomerId() {
	 * 
	 * Mockito.when(cartRepository.delete(Mockito.any(Cart.class))).thenReturn();
	 * assertThat(cartService.clearCartIemsByCustomerId(Mockito.anyLong())).
	 * isEqualTo(1); }
	 */

	
	@Test
	void testGetCustomerCartByCustomerId() {
		
		List<CartItemsDto> list=new ArrayList<CartItemsDto>();
		ResponseDto mockResponse=new ResponseDto();
		CartItemsDto cartItemsDto=new CartItemsDto();
		mockResponse.setCart_amount(2200.0);
		cartItemsDto.setProductID(1l);
		cartItemsDto.setQuantity(2);
		
		CartItemsDto cartItemsDto1=new CartItemsDto();
		cartItemsDto1.setProductID(3l);
		cartItemsDto1.setQuantity(2);
		
		list.add(cartItemsDto);
		list.add(cartItemsDto1);
		
		mockResponse.setCartItems(list);
		
		Cart mockCart=new Cart();
		mockCart.setCartUidpk(1l);
		mockCart.setCustomerUid(11l);
		mockCart.setState(State.OPEN);
		List<CartItem> l=new ArrayList<CartItem>();
		
		CartItem cartItem=new CartItem();
		cartItem.setUidpk(1l);
		cartItem.setProductUid(1l);
		cartItem.setQuantity(2);
		cartItem.setCart(mockCart);
		
		CartItem cartItem1=new CartItem();
		cartItem1.setUidpk(2l);
		cartItem1.setProductUid(3l);
		cartItem1.setQuantity(2);
		cartItem1.setCart(mockCart);
		
		l.add(cartItem);
		l.add(cartItem1);
		
		mockCart.setCartItem(l);
		
		
		Optional<Cart> ocart = Optional.of((Cart) mockCart);
		
		Mockito.when(cartRepository.findByCustomerUid(11l)).thenReturn(ocart);
		assertThat(cartService.getCustomerCartByCustomerId(11l)).isEqualTo(mockResponse);
	}
}
