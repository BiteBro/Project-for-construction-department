package ru.edu.skynet_cd.dao;

import java.util.List;

public interface MaterialDAO<T> {
    /**
     * Adds list materials in database to task by id.
     * @param taskId
     * @param listMaterials
     * @return number of inserted rows
     */
    int insertList(long taskId, List<T> listMaterials);
    /**
     * Delete materials issued to task by id.
     * @param taskId
     * @return number of deleted rows
     */
    int deleteMaterials(long taskId);
    /**
     * Receiving list materials to task by id.
     * @param taskId
     * @return list material to task by id
     */
    List<T> getByTaskId(long taskId);
}
