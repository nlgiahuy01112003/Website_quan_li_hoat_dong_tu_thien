package com.example.website_quan_li_hoat_dong_tu_thien.repository;

import com.example.website_quan_li_hoat_dong_tu_thien.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}