package com.group_eight.website_quan_li_hoat_dong_tu_thien.service;

import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.Campaign;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.model.Expense;
import com.group_eight.website_quan_li_hoat_dong_tu_thien.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> findByCampaign(Campaign campaign) {
        return expenseRepository.findByCampaign(campaign);
    }

    public void save(Expense expense) {
        expenseRepository.save(expense);
    }
}