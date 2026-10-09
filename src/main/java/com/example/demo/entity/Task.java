package com.example.demo.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class Task {
    private Integer taskId;
    private String taskName;
    private Date limitDate;
    private String statusCode;
    private String remarks;

    /**
     * Builderクラス
     */
    public static class Builder {
        private Integer taskId;
        private String taskName;
        private Date limitDate;
        private String statusCode;
        private String remarks;

        /**
         * taskIdを設定する
         *
         * @param taskId
         * @return
         */
        public Builder taskId(Integer taskId) {
            this.taskId = taskId;
            return this;
        }

        /**
         * taskNameを設定する
         *
         * @param taskName
         * @return
         */
        public Builder taskName(String taskName) {
            this.taskName = taskName;
            return this;
        }

        /**
         * limitDateを設定する
         *
         * @param limitDate
         * @return
         */
        public Builder limitDate(Date limitDate) {
            this.limitDate = limitDate;
            return this;
        }

        /**
         * statusCodeを設定する
         *
         * @param statusCode
         * @return
         */
        public Builder statusCode(String statusCode) {
            this.statusCode = statusCode;
            return this;
        }


        /**
         * remarksを設定する
         *
         * @param remarks
         * @return
         */
        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        /**
         * Taskオブジェクトを生成する
         *
         * @return Task
         */
        public Task build() {
            Task task = new Task();
            task.setTaskId(taskId);
            task.setTaskName(taskName);
            task.setLimitDate(limitDate);
            task.setStatusCode(statusCode);
            task.setRemarks(remarks);
            return task;
        }
    }
}
