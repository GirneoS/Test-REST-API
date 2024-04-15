package org.example.controller.admin;

import org.example.dto.MassageDTO;
import org.example.model.Massage;
import org.example.service.MassageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController("admin/api/v1/topic")
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
}
