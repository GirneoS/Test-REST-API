package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.MassageDTO;
import org.example.model.Massage;
import org.example.repository.MassageRepository;
import org.example.service.MassageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/massage")
@AllArgsConstructor
public class MassageController {
    private MassageService massageService;

    @GetMapping("/massage")
    public ResponseEntity<List<Massage>> findAllMassages(){
        return new ResponseEntity<>(massageService.findMassages(), HttpStatus.OK);
    }

    @PostMapping("/massage")
    public ResponseEntity<Massage> createMassage(@RequestBody MassageDTO dto){
        return new ResponseEntity<>(massageService.createMassage(dto), HttpStatus.OK);
    }

    @DeleteMapping("/massage")
    public void deleteMassage(@PathVariable Long id){
        massageService.deleteMassage(id);
    }
}
