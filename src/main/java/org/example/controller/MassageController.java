package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.MassageDTO;
import org.example.model.Massage;
import org.example.service.MassageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/topic")
public class MassageController {
    private MassageService massageService;

    @GetMapping("/{topicId}/massages")
    public Page<Massage> getMessagesInTopic(@PathVariable Long topicId,
                                            @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                            @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        return massageService.getMessagesInTopic(topicId, PageRequest.of(offset,limit));
    }

    @PostMapping("/{topicId}/massages")
    public ResponseEntity<Massage> createMassage(@RequestBody MassageDTO dto, @PathVariable Long topicId){
        return new ResponseEntity<>(massageService.createMassage(dto, topicId), HttpStatus.OK);
    }

    @PutMapping("/{topicId}/massages/{massageId}")
    public ResponseEntity<?> updateMassage(@RequestBody String text, @PathVariable Long massageId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();

        Massage massage = massageService.findById(massageId);
        if(currentUser.equals(massage.getAuthor())){
            massageService.updateMassage(text, massageId);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Вы не можете редактировать сообщение другого пользователя!");
        }
    }

    @DeleteMapping("/{topicId}/massages/{massageId}")
    public ResponseEntity<?> deleteMassage(@PathVariable Long massageId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();

        Massage massage = massageService.findById(massageId);
        if(currentUser.equals(massage.getAuthor())){
            massageService.deleteMassage(massageId);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Вы не можете редактировать сообщение другого пользователя!");
        }
    }
}
