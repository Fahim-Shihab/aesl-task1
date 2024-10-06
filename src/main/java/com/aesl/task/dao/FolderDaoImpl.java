package com.aesl.task.dao;

import com.aesl.task.dto.GetIdByFolderIdResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FolderDaoImpl implements FolderDao {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public GetIdByFolderIdResponse getIdByFolderId(Integer folderId) {
        List<Integer> list = new ArrayList<>();
        try {
            String s = "WITH RECURSIVE cte AS (\n" +
                    "    SELECT id, parent_id\n" +
                    "    FROM folder\n" +
                    "    WHERE parent_id = " + folderId + "\n" +
                    "    UNION ALL\n" +
                    "    SELECT f.id, f.parent_id\n" +
                    "    FROM folder f\n" +
                    "             INNER JOIN cte fh ON f.parent_id = fh.id\n" +
                    ")" +
                    "SELECT id FROM cte";

            list = entityManager.createNativeQuery(s).getResultList();
        } catch (Exception ex) {
            System.out.println("Error returning ids by folder id\n"+ex.toString());
            throw ex;
        }
        GetIdByFolderIdResponse response = new GetIdByFolderIdResponse();
        if (list != null && !list.isEmpty()) {
            list.add(0, folderId);
        }
        response.setFolderids(list);
        return response;
    }
}
