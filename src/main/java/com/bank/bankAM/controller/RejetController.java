package com.bank.bankAM.controller;

import com.bank.bankAM.dto.model.RejetDTO;
import com.bank.bankAM.rejetST.StatistiqueByDate;
import com.bank.bankAM.rejetST.StatistiqueRejetByTakenBy;
import com.bank.bankAM.service.user.RejetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "/api/rejet")
@RequiredArgsConstructor
@Api(tags = "Users", description = "Users Collection")
public class RejetController {

    private final RejetService rejetService;

    @ApiOperation(
            value = "Get List Of Rejets ",
            notes = "Show list of rejets from BankMA database"
    )
    @GetMapping
    public List<RejetDTO> getAllRejet(){
        return  rejetService.getAllRejet();
    }

    @ApiOperation(
            value = "Get Rejet ",
            notes = "Provide an ID to look a specific rejet from BankMA database"
    )
    @GetMapping(path = "{id}")
    public RejetDTO getRejet(@PathVariable("id") Long id){
        return rejetService.getRejet(id);
    }

    @ApiOperation(
            value = "Add new rejet ",
            notes = "Add new rejet to BankMA database"
    )
    @PostMapping(path = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<RejetDTO> addNewRejet(@RequestPart RejetDTO rejet, @RequestPart("file") MultipartFile file){
        RejetDTO newRejet =  rejetService.addNewRejet(rejet,file);
        if(newRejet != null)
            return ResponseEntity.ok().body(newRejet);
        return ResponseEntity.status(400).build();
    }

    @ApiOperation(
            value = "Delete user by ID",
            notes = "Provide an ID to delete a specific user from BankMA database"
    )
    @DeleteMapping(path = "/delete/{id}")
    public void deleteRejet(@PathVariable("id") Long id){
        rejetService.deleteRejet(id);
    }

    @ApiOperation(
            value = "Update Rejet ",
            notes = "Update a specific rejet "
    )

    @PutMapping("/update")
    public RejetDTO updtaeRejet(@RequestBody RejetDTO rejetDTO){
        return rejetService.updateRejet(rejetDTO);
    }

    @GetMapping(path = "/rejet-statistique")
    public List<StatistiqueByDate> getStatistiqueByDate(){
        return rejetService.rejetByDate();
    }

    @GetMapping(path = "/rejet-statistique-takenby")
    public List<StatistiqueRejetByTakenBy> getStatistiqueByTakenBy(){
        return rejetService.rejetByTakenBy();
    }
}
