package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.TopicDTO;
import org.example.service.TopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarController {
    private TopicService topicService;

    @PostMapping()
    public ResponseEntity<org.example.model.Topic> createTopic(@RequestBody TopicDTO dto){
        return new ResponseEntity<>(topicService.createTopic(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<org.example.model.Topic>> findAllTopics(){
        return new ResponseEntity<>(topicService.findTopics(), HttpStatus.OK);
    }
}
