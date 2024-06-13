package com.group_eight.website_quan_li_hoat_dong_tu_thien.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class MomoPaymentService {

    @Value("${momo.partnerCode}")
    private String partnerCode;

    @Value("${momo.accessKey}")
    private String accessKey;

    @Value("${momo.secretKey}")
    private String secretKey;

    @Value("${momo.endpoint}")
    private String endpoint;

    public String createPaymentRequest(double amount, String orderId, String orderInfo, String returnUrl) throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("partnerCode", partnerCode);
        params.put("accessKey", accessKey);
        params.put("requestId", orderId);
        params.put("amount", String.valueOf(amount));
        params.put("orderId", orderId);
        params.put("orderInfo", orderInfo);
        params.put("returnUrl", returnUrl);
        params.put("notifyUrl", returnUrl);
        params.put("extraData", "");

        String rawData = "partnerCode=" + partnerCode +
                "&accessKey=" + accessKey +
                "&requestId=" + orderId +
                "&amount=" + amount +
                "&orderId=" + orderId +
                "&orderInfo=" + orderInfo +
                "&returnUrl=" + returnUrl +
                "&notifyUrl=" + returnUrl +
                "&extraData=";

        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        String signature = Base64.getEncoder().encodeToString(sha256_HMAC.doFinal(rawData.getBytes()));
        params.put("signature", signature);

        // TODO: Send request to Momo endpoint and handle response
        // Example: return HttpClient.post(endpoint, params);

        return null;
    }
}