package org.example.model;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

import javax.annotation.processing.Generated;
import java.security.PrivateKey;
import java.time.LocalDate;
import java.util.Optional;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Massage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String author;
    private String textMassage;
    private LocalDate date;

    @ManyToOne
    private Topic topic;
}
