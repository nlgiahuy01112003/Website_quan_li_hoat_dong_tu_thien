package com.example.website_quan_li_hoat_dong_tu_thien.service;

import com.example.website_quan_li_hoat_dong_tu_thien.model.CartItem;
import com.example.website_quan_li_hoat_dong_tu_thien.model.Event;
import com.example.website_quan_li_hoat_dong_tu_thien.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class CartService {
    private List<CartItem> cartItems = new ArrayList<>();

    @Autowired
    private EventRepository eventRepository;

    public List<CartItem> getCartItems() {
        return new ArrayList<>(cartItems);
    }

    public void addToCart(String link, int quantity) {
        Event event = eventRepository.findByLink(link)
                .orElseThrow(() -> new IllegalArgumentException("Event not found: " + link));
        cartItems.add(new CartItem(event, quantity));
    }

    public void removeFromCart(int eventId) {
        cartItems.removeIf(item -> item.getEvent().getId() == eventId);
    }

    public void clearCart() {
        cartItems.clear();
    }
}
