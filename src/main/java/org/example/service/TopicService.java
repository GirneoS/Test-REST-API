package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.TopicDTO;
import org.example.model.Massage;
import org.example.model.Topic;
import org.example.repository.MassageRepository;
import org.example.repository.TopicRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicService {
    private TopicRepository topicRepository;
    private MassageRepository massageRepository;

    public org.example.model.Topic createTopic(TopicDTO dto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Topic createdTopic =  topicRepository.save(
                org.example.model.Topic.builder()
                        .title(dto.getTitle())
                        .build());
        massageRepository.save(Massage.builder()
                        .author(authentication.getName())
                        .textMassage(dto.getTextFirstMassage())
                        .date(dto.getDateFirstMassage())
                        .topic(createdTopic)
                .build());
        return createdTopic;
    }

    public List<org.example.model.Topic> findTopics(){
        return topicRepository.findAll();
    }
    public Topic findTopicById(Long id){
        return topicRepository.getReferenceById(id);
    }
}
