package com.RP.ControleDeJornada.domain.entitys.user;

import com.RP.ControleDeJornada.domain.entitys.ResultCenter.ResultCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomResponse {
    private List<User> user;
    private List<ResultCenter> rcs;
}
