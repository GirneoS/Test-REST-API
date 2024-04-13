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

    @GetMapping("/{id}/massage")
    public ResponseEntity<List<Massage>> getMessagesInTopic(@PathVariable Long id) {
        List<Massage> messages = massageService.getMessagesInTopic(id);
        return ResponseEntity.ok(messages);
    }
    @GetMapping("/{id}/massage/all")
    public ResponseEntity<List<Massage>> findAllMassages(){
        return new ResponseEntity<>(massageService.findAllMassages(),HttpStatus.OK);
    }

    @PostMapping("/{id}/massage")
    public ResponseEntity<Massage> createMassage(@RequestBody MassageDTO dto, @PathVariable Long id){
        return new ResponseEntity<>(massageService.createMassage(dto, id), HttpStatus.OK);
    }

    @PutMapping("/{id}/massage")
    public  ResponseEntity<Massage> updateMassage(@RequestBody Massage massage){
        return new ResponseEntity<>(massageService.updateMassage(massage),HttpStatus.OK);
    }

    @DeleteMapping("/{id}/massage{id}")
    public HttpStatus deleteMassage(@PathVariable Long id){
        return massageService.deleteMassage(id);
    }
}
