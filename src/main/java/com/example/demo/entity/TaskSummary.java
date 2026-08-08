package com.example.demo.entity;

import java.sql.Date;

public record TaskSummary(Integer taskId, String taskName, Date limitDate, String statusCode) {}
