package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.MassageDTO;
import org.example.model.Massage;
import org.example.service.MassageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/topic")
public class MassageController {
    private MassageService massageService;

    @GetMapping("/{id}/massages")
    public ResponseEntity<List<Massage>> getMessagesInTopic(@PathVariable Long id) {
        List<Massage> messages = massageService.getMessagesInTopic(id);
        return ResponseEntity.ok(messages);
    }

    @PostMapping("/{id}/massages")
    public ResponseEntity<Massage> createMassage(@RequestBody MassageDTO dto, @PathVariable Long id){
        return new ResponseEntity<>(massageService.createMassage(dto, id), HttpStatus.OK);
    }

    @PutMapping("/{id}/massages/{massageId}")
    public  ResponseEntity<Massage> updateMassage(@RequestBody String text, @PathVariable Long massageId){
        return new ResponseEntity<>(massageService.updateMassage(text, massageId),HttpStatus.OK);
    }

    @DeleteMapping("/{topicId}/massages/{massageId}")
    public HttpStatus deleteMassage(@PathVariable Long massageId){
        return massageService.deleteMassage(massageId);
    }
}
