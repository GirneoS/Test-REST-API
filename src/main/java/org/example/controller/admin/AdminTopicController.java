package org.example.controller.admin;

import lombok.AllArgsConstructor;
import org.example.model.Topic;
import org.example.service.TopicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/api/v1")
@AllArgsConstructor
public class AdminTopicController {
    private TopicService topicService;

    @DeleteMapping("/topic/{topicId}")
    public HttpStatus deleteTopic(@PathVariable Long topicId){
        topicService.deleteTopic(topicId);
        return HttpStatus.OK;
    }

    @PutMapping("/topic")
    public Topic updateTopic(@RequestBody Topic topic){
        return topicService.updateTopic(topic);
    }

    @GetMapping("/topic")
    public Page<Topic> getPageOfTopics(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        return topicService.findPageOfTopics(PageRequest.of(offset, limit));
    }
}
