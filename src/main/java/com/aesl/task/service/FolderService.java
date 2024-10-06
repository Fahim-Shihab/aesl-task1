package com.aesl.task.service;

import com.aesl.task.dto.GetIdByFolderIdResponse;

import java.util.List;

public interface FolderService {
    public GetIdByFolderIdResponse getIdByFolderId(Integer folderId);
}
