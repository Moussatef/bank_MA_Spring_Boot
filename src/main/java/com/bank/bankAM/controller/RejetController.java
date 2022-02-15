package com.bank.bankAM.controller;

import com.bank.bankAM.dto.model.RejetDTO;
import com.bank.bankAM.entity.Rejet;
import com.bank.bankAM.service.user.RejetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/rejet")
@RequiredArgsConstructor
public class RejetController {

    private final RejetService rejetService;

    @GetMapping
    public List<RejetDTO> getAllRejet(){
        return  rejetService.getAllRejet();
    }

    @GetMapping(path = "{id}")
    public RejetDTO getRejet(@PathVariable("id") Long id){
        return rejetService.getRejet(id);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<RejetDTO> addNewRejet(@RequestBody RejetDTO rejet){
        RejetDTO newRejet =  rejetService.addNewRejet(rejet);
        if(newRejet != null)
            return ResponseEntity.ok().body(newRejet);
        return ResponseEntity.status(400).build();
    }

}
