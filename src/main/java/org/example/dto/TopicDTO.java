package org.example.dto;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class TopicDTO {
    @NonNull
    String title;
    String authorFirstMassage;
    @NonNull
    String textFirstMassage;
    @NonNull
    LocalDate dateFirstMassage;
}
