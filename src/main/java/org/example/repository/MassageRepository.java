package org.example.repository;

import org.example.dto.MassageDTO;
import org.example.model.Massage;
import org.example.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MassageRepository extends JpaRepository<Massage, Long> {
    List<Massage> findByTopicId(Long topicId);
}
