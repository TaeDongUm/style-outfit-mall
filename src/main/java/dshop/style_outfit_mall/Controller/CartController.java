package dshop.style_outfit_mall.Controller;

import dshop.style_outfit_mall.domain.Cart;
import dshop.style_outfit_mall.Service.CartService;
import dshop.style_outfit_mall.domain.CartItem;
import dshop.style_outfit_mall.dto.CartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable String userId) {
        Cart cart = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/{userId}/items")
    public ResponseEntity<Void> addItemToCart(@PathVariable String userId, @RequestBody CartItemRequest cartItemRequest) {
        cartService.addItemToCart(userId, cartItemRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/items/{itemId}")
    public ResponseEntity<Void> removeItemFromCart(@PathVariable String userId, @PathVariable CartItem itemId) {
        cartService.removeItemFromCart(userId, itemId);
        return ResponseEntity.noContent().build();
    }
}
