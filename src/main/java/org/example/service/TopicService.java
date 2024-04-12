package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.TopicDTO;
import org.example.model.Topic;
import org.example.repository.MassageRepository;
import org.example.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicService {
    private TopicRepository topicRepository;
    private MassageRepository massageRepository;

    public org.example.model.Topic createTopic(TopicDTO dto){
        return topicRepository.save(
                org.example.model.Topic.builder()
                        .title(dto.getTitle())
                        .build());
    }

    public List<org.example.model.Topic> findTopics(){
        return topicRepository.findAll();
    }

    public void deleteTopic(Long id){
        topicRepository.deleteById(id);
    }
    public Topic findTopicById(Long id){
        return topicRepository.getReferenceById(id);
    }
}
