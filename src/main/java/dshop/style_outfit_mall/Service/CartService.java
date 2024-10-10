package dshop.style_outfit_mall.Service;

import dshop.style_outfit_mall.domain.Cart;
import dshop.style_outfit_mall.Repository.CartRepository;
import dshop.style_outfit_mall.domain.CartItem;
import dshop.style_outfit_mall.dto.CartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart getCartByUserId(String userId) {
        return cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    public void addItemToCart(String userId, CartItemRequest cartItem) {
        Cart cart = getCartByUserId(userId);
        cart.addItem(cartItem);
        cartRepository.save(cart);
    }

    public void removeItemFromCart(String userId, CartItem itemId) {
        Cart cart = getCartByUserId(userId);
        cart.removeItem(itemId);
        cartRepository.save(cart);
    }
}

