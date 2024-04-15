package org.example.controller.admin;

import org.example.dto.TopicDTO;
import org.example.model.Topic;
import org.example.service.TopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController("admin/api/v1")
public class AdminTopicController {
    private TopicService topicService;

    @DeleteMapping("/topic/{topicId}")
    public HttpStatus deleteTopic(@PathVariable Long topicId){
        topicService.deleteTopic(topicId);
        return HttpStatus.OK;
    }
    @PutMapping("/topic")
    public Topic updateTopic(@RequestBody TopicDTO dto){
        return topicService.updateTopic(dto);
    }
}
