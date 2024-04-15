package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Builder
@Data
public class MassageDTO {

    private String author;
    private String textMassage;
    private LocalDate date;
}
