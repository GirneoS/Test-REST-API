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

@Service
@AllArgsConstructor
public class MassageService {
    private MassageRepository massageRepository;
    private TopicRepository topicRepository;

    public Massage createMassage(MassageDTO dto, Long topicId){
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found with id: " + topicId));

        return massageRepository.save(Massage.builder()
                .author(dto.getAuthor())
                .textMassage(dto.getTextMassage())
                .date(dto.getDate())
                .topic(topic)
                .build());
    }

    public List<Massage> getMessagesInTopic(Long topicId) {
        return massageRepository.findByTopicId(topicId);
    }

    public Massage updateMassage(String text, Long id){
        Massage updatedMassage = massageRepository.findById(id).orElseThrow(()->new RuntimeException("Не удалось найти сообщение с указанным id!"));
        updatedMassage.setTextMassage(text);
        return massageRepository.save(updatedMassage);
    }

    public HttpStatus deleteMassage(Long massageId){
        massageRepository.deleteById(massageId);
        return HttpStatus.OK;
    }
}
