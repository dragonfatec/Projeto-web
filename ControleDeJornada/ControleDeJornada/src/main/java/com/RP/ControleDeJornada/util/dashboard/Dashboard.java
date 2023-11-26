package com.RP.ControleDeJornada.util.dashboard;

import com.RP.ControleDeJornada.domain.entitys.sendTime.SendTime;
import com.RP.ControleDeJornada.domain.entitys.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Dashboard {

    private List<SendTime> timeList;
    private User user;

    public Dashboard(){
    }

    public Dashboard(List<SendTime> timeList, User user) {
        this.timeList = timeList;
        this.user = user;
    }
}
