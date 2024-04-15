package org.example.controller.user;

import lombok.AllArgsConstructor;
import org.example.dto.TopicDTO;
import org.example.model.Topic;
import org.example.service.TopicService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/topic")
public class TopicController {
    private TopicService topicService;

    @PostMapping()
    public ResponseEntity<Topic> createTopic(@RequestBody TopicDTO dto){
        return new ResponseEntity<>(topicService.createTopic(dto), HttpStatus.OK);
    }

    @GetMapping
    public Page<Topic> getPageOfTopics(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        return topicService.findPageOfTopics(PageRequest.of(offset, limit));
    }

}
