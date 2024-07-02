package com.example.community.Controller;


import com.example.community.Entity.Order;
import com.example.community.Services.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;


    @GetMapping("/checkout")
    public String checkout() {
        return "/cart/checkout";
    }
    @PostMapping("/submit")
    public String submitOrder(String customerName, String phone, String address,String email, String note, RedirectAttributes redirectAttributes) {



        Order newOrder = orderService.createOrder(customerName, phone, address, email,note);

        redirectAttributes.addFlashAttribute("order", newOrder);
        return "redirect:/order/confirmation";
    }
    @GetMapping("/confirmation")
    public String orderConfirmation(Model model, @ModelAttribute("order") Order order) {
        model.addAttribute("message", "Your order has been successfully placed.");
        model.addAttribute("order", order);


        return "cart/order-confirmation";
    }
}
