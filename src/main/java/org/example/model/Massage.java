package org.example.model;


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
    @NonNull
    private Topic topic;
}
