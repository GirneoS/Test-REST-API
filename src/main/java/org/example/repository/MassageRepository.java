package org.example.repository;

import org.example.model.Massage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MassageRepository extends JpaRepository<Massage, Long> {
    List<Massage> findByTopicId(Long topicId);
}
