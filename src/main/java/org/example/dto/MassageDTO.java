package org.example.dto;

import lombok.Data;
import org.example.model.Topic;

import java.time.LocalDate;

@Data
public class MassageDTO {

    private String author;
    private String textMassage;
    private LocalDate date;
    private Topic topic;
}
