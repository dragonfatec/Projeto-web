package com.RP.ControleDeJornada.controller;

import com.RP.ControleDeJornada.domain.dto.BudgetDTO;
import com.RP.ControleDeJornada.domain.dto.ChartDataDTO;
import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import com.RP.ControleDeJornada.domain.repository.RcRepository;
import com.RP.ControleDeJornada.domain.repository.SendTimeRepository;
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
    SendTimeRepository str;

    @Autowired
    UserRepository ur;
    @Autowired
    RcRepository rcRepository;

//    @GetMapping("/{idUser}")
//    public ResponseEntity<List<ChartDataDTO>> findHourToDashboard(@PathVariable Integer idUser) {
//        User userSelection = ur.findByRegistration(idUser);
//        if (userSelection == null) {
//            return ResponseEntity.notFound().build();
//        }
//        List<Object[]> queryResults = str.findSendTimesByUser(userSelection);
//        List<ChartDataDTO> chartDataList = mapToChartDataDTO(queryResults);
//
//        if (chartDataList.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.ok(chartDataList);
//        }
//    }

//    private List<ChartDataDTO> mapToChartDataDTO(List<Object[]> results) {
//        List<ChartDataDTO> chartDataList = new ArrayList<>();
//
//        for (Object[] result : results) {
//            String label = (String) result[0];
//            Double value = (Double) result[1];
//            chartDataList.add(new ChartDataDTO(label, value));
//        }
//
//        return chartDataList;
//    }

    @GetMapping("/{idUser}")
    private ResponseEntity<BudgetDTO> hourToDashTest(@PathVariable Integer idUser) {
        User userSelection = ur.findByRegistration(idUser);
        if (userSelection == null) {
            return ResponseEntity.notFound().build();
        }
        List<SendTime> queryResults = str.findByUser(userSelection);
        Double budget1601 = 0d;
        Double budget1602 = 0d;
        Double budget1809 = 0d;
        Double budget3000 = 0d;
        Double budget3001 = 0d;
        for (SendTime sd : queryResults) {
            budget1601 += sd.getBudget1601();
            budget1602 += sd.getBudget1602();
            budget1809 += sd.getBudget1809();
            budget3000 += sd.getBudget3000();
            budget3001 += sd.getBudget3001();
        }

        BudgetDTO budget = new BudgetDTO(budget1601, budget1602, budget1809, budget3000, budget3001);

        return ResponseEntity.ok().body(budget);
    }
}

//    public ResponseEntity<List<SendTime>> rcHourToDashboard(String idResultCenter){
//        List<User> peopleOfRC = rcRepository.
//    }

