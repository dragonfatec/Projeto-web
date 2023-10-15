package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.DataListingTime;
import com.RP.ControleDeJornada.domain.service.HoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hours")
public class HoursController {
    @Autowired
    private HoursService hoursService;
    @GetMapping("collaborator/{id}") // mostrar a lista de horas com o id do usuario.
    public ResponseEntity<List<DataListingTime>> viewHoursForCollaborator(@PathVariable Integer id) {
        return hoursService.viewHoursForCollaborator(id);

    }
    

}
