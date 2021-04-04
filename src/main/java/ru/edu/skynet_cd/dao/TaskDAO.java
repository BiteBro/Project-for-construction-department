package ru.edu.skynet_cd.dao;

import java.util.List;
import ru.edu.skynet_cd.domain.Task;

public interface TaskDAO<T> {
    Task getTask(long id);
    Long insert(T task);
    Long delete(long id);
    Long update(T task);
    Long updateStatus(T task);
    List<T> getAll();
    List<T> getAllToExecutor(long idExecutor);
}
