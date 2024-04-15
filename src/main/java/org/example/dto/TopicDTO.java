package org.example.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@Builder
public class TopicDTO {
    @NonNull
    String title;
    String authorFirstMassage;
    @NonNull
    String textFirstMassage;
    LocalDate dateFirstMassage;
}
