package com.bakey.currencyservice.repositories;

import com.bakey.currencyservice.models.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LimitRepository extends JpaRepository<Limit, Long> {
}