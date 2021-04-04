package ru.edu.skynet_cd.dao;

public interface ReportDAO<T> {
    Long insertReport(long task_id, T entity);
    Long updateReport(long task_id, T entity);
    int deleteReport(long task_id);
    T ReportGetByTaskId(long task_id);
}
