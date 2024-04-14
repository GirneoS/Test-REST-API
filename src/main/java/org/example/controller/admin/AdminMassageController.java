package org.example.controller.admin;

import org.example.model.Massage;
import org.example.service.MassageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController("admin/api/v1/topic")
public class AdminMassageController {
    MassageService massageService;
    @PutMapping("/{topicId}/massages/{massageId}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Massage> updateMassage(@RequestBody String text, @PathVariable Long massageId){
        return new ResponseEntity<>(massageService.updateMassage(text, massageId), HttpStatus.OK);
    }

    @DeleteMapping("/{topicId}/massages/{massageId}")
    @Secured("ROLE_ADMIN")
    public HttpStatus deleteMassage(@PathVariable Long massageId){
        return massageService.deleteMassage(massageId);
    }
}
