package com.taxiService.taxi.models.data;

import com.taxiService.taxi.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RequestDao extends JpaRepository<Request,Long> {
}
