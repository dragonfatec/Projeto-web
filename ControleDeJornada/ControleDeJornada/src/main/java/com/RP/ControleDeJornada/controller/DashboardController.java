package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.ChartDataDTO;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.repository.SendTypeRepository;
import com.RP.ControleDeJornada.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    SendTypeRepository str;
    @Autowired
    UserRepository ur;

    @GetMapping("/{idUser}")
    public ResponseEntity<List<ChartDataDTO>> findHourToDashboard(@PathVariable Integer idUser) {
        User userSelection = ur.findByRegistration(idUser);
        if (userSelection == null) {
            return ResponseEntity.notFound().build();
        }
        List<Object[]> queryResults = str.findSendTimesByUser(userSelection);
        List<ChartDataDTO> chartDataList = mapToChartDataDTO(queryResults);

        if (chartDataList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(chartDataList);
        }
    }

    private List<ChartDataDTO> mapToChartDataDTO(List<Object[]> results) {
        List<ChartDataDTO> chartDataList = new ArrayList<>();

        for (Object[] result : results) {
            String label = (String) result[0];
            Double value = (Double) result[1];
            chartDataList.add(new ChartDataDTO(label, value));
        }

        return chartDataList;
    }
}
