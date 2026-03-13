package com.example.shortlink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.shortlink.model.Links;

public interface LinkRepository extends JpaRepository<Links, Long> {

    Links findByShortCode(String shortCode);

}