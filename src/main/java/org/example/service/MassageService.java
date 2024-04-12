package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.MassageDTO;
import org.example.model.Massage;
import org.example.model.Topic;
import org.example.repository.MassageRepository;
import org.example.repository.TopicRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MassageService {
    private MassageRepository massageRepository;

    public Massage createMassage(MassageDTO dto){
        return massageRepository.save(Massage.builder()
                .author(dto.getAuthor())
                .textMassage(dto.getTextMassage())
                .date(dto.getDate())
                .topic(dto.getTopic())
                .build());
    }

    public List<Massage> findMassages(Long topicId){
        return massageRepository.findByTopicId(topicId);
    }

    public Massage updateMassage(Massage massage){
        return massageRepository.save(massage);
    }

    public HttpStatus deleteMassage(Long id){
        massageRepository.deleteById(id);
        return HttpStatus.OK;
    }
}
