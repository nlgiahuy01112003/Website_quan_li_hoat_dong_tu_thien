package com.example.website_quan_li_hoat_dong_tu_thien.service;

import com.example.website_quan_li_hoat_dong_tu_thien.model.CartItem;
import com.example.website_quan_li_hoat_dong_tu_thien.model.OrderEvent;
import com.example.website_quan_li_hoat_dong_tu_thien.model.OrderEventDetail;
import com.example.website_quan_li_hoat_dong_tu_thien.repository.OrderEventDetailRepository;
import com.example.website_quan_li_hoat_dong_tu_thien.repository.OrderEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    @Autowired
    private final OrderEventRepository orderRepository;
    @Autowired
    private final OrderEventDetailRepository orderDetailRepository;
    @Autowired
    private final CartService cartService; // Assuming you have a CartService

    @Transactional
    public OrderEvent createOrder(String customerName, List<CartItem> cartItems) {
        OrderEvent order = new OrderEvent();
        order.setCustomerName(customerName); // Gọi phương thức setCustomerName

        // Lưu đơn hàng vào cơ sở dữ liệu
        order = orderRepository.save(order);

        // Lưu các chi tiết đơn hàng vào cơ sở dữ liệu
        for (CartItem item : cartItems) {
            OrderEventDetail detail = new OrderEventDetail();
            detail.setOrder(order);
            detail.setEvent(item.getEvent());
            detail.setQuantity(item.getQuantity());
            orderDetailRepository.save(detail);
        }

        // Xóa giỏ hàng sau khi đặt hàng (tùy chọn)
        cartService.clearCart();
        return order;
    }
}
