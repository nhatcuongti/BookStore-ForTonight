package com.example.bookstore.models;

/**
 * Author : Hao
 * Describe : Report which used for process report
 */
public class Report {
    private String Sender, reportedUser, Tittle;

    public Report(String sender, String reportedUser, String tittle) {
        Sender = sender;
        this.reportedUser = reportedUser;
        Tittle = tittle;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public String getReportedUser() {
        return reportedUser;
    }

    public void setReportedUser(String reportedUser) {
        this.reportedUser = reportedUser;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }
}
