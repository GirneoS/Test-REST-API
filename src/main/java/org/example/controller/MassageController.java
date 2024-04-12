package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.MassageDTO;
import org.example.model.Massage;
import org.example.model.Topic;
import org.example.repository.MassageRepository;
import org.example.repository.TopicRepository;
import org.example.service.MassageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/topic/massage")
public class MassageController {
    private MassageService massageService;
    private TopicRepository topicRepository;

    @GetMapping("/{id}")
    public ResponseEntity<List<Massage>> findAllMassagesByTopic(@PathVariable Long id){
        return new ResponseEntity<>(massageService.findMassages(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Massage> createMassage(@RequestBody MassageDTO dto){
        return new ResponseEntity<>(massageService.createMassage(dto), HttpStatus.OK);
    }

    @PutMapping
    public  ResponseEntity<Massage> updateMassage(@RequestBody Massage massage){
        return new ResponseEntity<>(massageService.updateMassage(massage),HttpStatus.OK);
    }

    @DeleteMapping("/massage")
    public void deleteMassage(@PathVariable Long id){
        massageService.deleteMassage(id);
    }
}
