package com.d288.demo.services;

import com.d288.demo.dao.CartItemRepository;
import com.d288.demo.dao.CartRepository;
import com.d288.demo.dao.CustomerRepository;
import com.d288.demo.entities.Cart;
import com.d288.demo.entities.CartItem;
import com.d288.demo.entities.Customer;
import com.d288.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CartRepository cartRepository;

    public CheckoutServiceImpl (CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse checkout (Purchase purchase) {
        Cart cart = purchase.getCart();
        Set<CartItem> cartItems = purchase.getCartItems();

        cartItems.forEach(item -> {
            cart.add(item);
        });

        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty");
            return new PurchaseResponse("Cart cannot be empty");
        }

        if (cart.getParty_size() <1) {
            System.out.println("Party size is less than 1");
            return new PurchaseResponse("Please enter at least 1 party");
        }

        cart.setStatus(StatusType.ordered);

        Customer customer = purchase.getCustomer();
        cart.setCustomer(customer);

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cartRepository.save(cart);
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }

}
