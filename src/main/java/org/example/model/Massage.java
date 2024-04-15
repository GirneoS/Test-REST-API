package org.example.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "massage")
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
