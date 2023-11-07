package com.RP.ControleDeJornada.domain.entitys.sendTime;

import java.time.*;
import lombok.Getter;

@Getter
public class Parameterization {
    private LocalDateTime startDate, endDate;
    private int minutesDayTime, minutesNightTime;
    private int startWorkTime = 8;
    private int endWorkTime = 17;

    private double budget1601, budget1602, budget3000, budget3001, budget1809;

    public Parameterization(LocalDateTime startDate, LocalDateTime endDate){
        this.startDate = takeWorkPeriod(startDate, true);
        this.endDate = takeWorkPeriod(endDate, false);
        calculateMinutes();
    }

    private void calculateMinutes(){
        LocalDateTime dayTime = LocalDateTime.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), 6, 0);
        LocalDateTime nightTime = LocalDateTime.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), 22, 0);

        if(isDayTime(startDate)){
            if(isDayTime(endDate) & startDate.getDayOfMonth() == endDate.getDayOfMonth()){
                this.minutesDayTime = getDifferenceInMinutes(startDate, endDate);
                this.minutesNightTime = getDifferenceInMinutes(nightTime, isDayTime(endDate)?dayTime:endDate);
            }
            else{
                this.minutesDayTime = getDifferenceInMinutes(startDate, nightTime);
                this.minutesNightTime = getDifferenceInMinutes(nightTime, isDayTime(endDate)?dayTime.plusDays(1):endDate);
            }
            if(isDayTime(endDate)){
                this.minutesDayTime += getDifferenceInMinutes(dayTime.plusDays(1), endDate);
            }
        }
        else{
            this.minutesDayTime = getDifferenceInMinutes(dayTime, endDate);
            this.minutesNightTime = getDifferenceInMinutes(startDate, isDayTime(endDate)?dayTime:endDate);
        }
        splitMinutes(true, this.minutesDayTime);
        splitMinutes(false, this.minutesNightTime);
    }

    private void splitMinutes(boolean isDayTime, int allTimeWorkingInMinutes){
        // 120 min = 2h
        int min = 120;
        double nightHour = 1.1429;
        double hours = (double) Math.min(allTimeWorkingInMinutes, min) / 60;
        double hoursLeft = (double) (allTimeWorkingInMinutes > min ? allTimeWorkingInMinutes - min : 0) / 60;

        if(isDayTime){
            this.budget1601 = hours;
            this.budget1602 = hoursLeft;
        }
        else{
            this.budget3000 = hours * nightHour;
            this.budget3001 = hoursLeft * nightHour;
//            this.budget1809 = (hours + hoursLeft) * nightHour;
        }
    }

    private boolean isDayTime(LocalDateTime date){
        return date.getHour() > 6 & date.getHour() <= 22;
    }

    private LocalDateTime takeWorkPeriod(LocalDateTime date, boolean isStartDate){
        int hr = date.getHour();
        int min = date.getMinute();
        if(isStartDate){
            if(hr > startWorkTime & hr < endWorkTime){
                hr = 17;
                min = 0;
            }
        }
        else{
            if(hr > startWorkTime & hr < endWorkTime){
                hr = 8;
                min = 0;
            }
        }
        date = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), hr, min);
        return date;
    }

    private int getDifferenceInMinutes(LocalDateTime startDate, LocalDateTime endDate){
        int minutes = (int)Duration.between(startDate, endDate).toMinutes();
        return Math.max(minutes, 0);
    }

    public void setStartWorkTime(int startWorkTime) {
        this.startWorkTime = startWorkTime;
    }

    public void setEndWorkTime(int endWorkTime) {
        this.endWorkTime = endWorkTime;
    }
}
