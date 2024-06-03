package com.group_eight.website_quan_li_hoat_dong_tu_thien.controller;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.service.MomoPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private MomoPaymentService momoPaymentService;

    @PostMapping("/momo")
    public String createMomoPayment(@RequestParam double amount, @RequestParam String orderId, @RequestParam String orderInfo) {
        try {
            String paymentUrl = momoPaymentService.createPaymentRequest(amount, orderId, orderInfo, "http://localhost:8080/payment/return");
            return "redirect:" + paymentUrl;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/return")
    public String paymentReturn() {
        // TODO: Handle payment return
        return "payment_return";
    }
}