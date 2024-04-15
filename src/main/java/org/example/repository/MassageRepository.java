package org.example.repository;

import org.example.model.Massage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MassageRepository extends JpaRepository<Massage, Long> {
    Page<Massage> findByTopicId(Long topicId, Pageable pageable);
}
