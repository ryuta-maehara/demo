package com.example.demo.entity;

import java.sql.Date;

public class TaskSummary {
    private Integer taskId;
    private String taskName;
    private Date limitDate;
    private Integer memoCount;
    private Status status;

    public TaskSummary() {
    }

    public TaskSummary(Integer taskId, String taskName, Date limitDate, Integer memoCount, Status status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.limitDate = limitDate;
        this.memoCount = memoCount;
        this.status = status;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }

    public Integer getMemoCount() {
        return memoCount;
    }

    public void setMemoCount(Integer memoCount) {
        this.memoCount = memoCount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
