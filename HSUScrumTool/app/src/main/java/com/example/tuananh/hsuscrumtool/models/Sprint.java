package com.example.tuananh.hsuscrumtool.models;

import java.util.Date;

/**
 * Created by Tuan Anh on 06/10/2017.
 */

public class Sprint {
    private int SprintID;
    private Date StartDate;
    private Date EndDate;
    private String SprintStatus;
    private String SprintConclude;

    public Sprint(int sprintID, Date startDate, Date endDate, String sprintStatus, String sprintConclude) {
        SprintID = sprintID;
        StartDate = startDate;
        EndDate = endDate;
        SprintStatus = sprintStatus;
        SprintConclude = sprintConclude;
    }

    public int getSprintID() {
        return SprintID;
    }

    public void setSprintID(int sprintID) {
        SprintID = sprintID;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getSprintStatus() {
        return SprintStatus;
    }

    public void setSprintStatus(String sprintStatus) {
        SprintStatus = sprintStatus;
    }

    public String getSprintConclude() {
        return SprintConclude;
    }

    public void setSprintConclude(String sprintConclude) {
        SprintConclude = sprintConclude;
    }


}
