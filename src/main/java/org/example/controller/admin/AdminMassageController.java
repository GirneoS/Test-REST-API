package org.example.controller.admin;

import lombok.AllArgsConstructor;
import org.example.dto.MassageDTO;
import org.example.model.Massage;
import org.example.service.MassageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/api/v1/topic")
@AllArgsConstructor
public class AdminMassageController {
    MassageService massageService;
    @PutMapping("/{id}/massages/{massageId}")
    public HttpStatus updateMassage(@RequestBody MassageDTO dto, @PathVariable Long massageId){
        return massageService.updateMassage(dto, massageId);
    }

    @DeleteMapping("/{id}/massages/{massageId}")
    public HttpStatus deleteMassage(@PathVariable Long massageId){
        return massageService.deleteMassage(massageId);
    }

    @GetMapping("/{topicId}/massages")
    public Page<Massage> getMessagesInTopic(@PathVariable Long topicId,
                                            @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                            @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        return massageService.getMessagesInTopic(topicId, PageRequest.of(offset,limit));
    }
}
