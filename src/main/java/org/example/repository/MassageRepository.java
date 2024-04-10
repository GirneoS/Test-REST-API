package org.example.repository;

import org.example.dto.MassageDTO;
import org.example.model.Massage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MassageRepository extends JpaRepository<Massage, Long> {
}
