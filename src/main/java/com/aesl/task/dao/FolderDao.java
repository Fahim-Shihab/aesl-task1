package com.aesl.task.dao;

import com.aesl.task.dto.GetIdByFolderIdResponse;

import java.util.List;

public interface FolderDao {
    public GetIdByFolderIdResponse getIdByFolderId(Integer folderId);
}
