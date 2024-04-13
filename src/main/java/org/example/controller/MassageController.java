package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.MassageDTO;
import org.example.model.Massage;
import org.example.service.MassageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<Massage> getMessagesInTopic(@PathVariable Long id,
                                            @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                            @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        return massageService.getMessagesInTopic(id, PageRequest.of(offset,limit));
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
