package com.aesl.task.service;

import com.aesl.task.dto.GetIdByFolderIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.aesl.task.dao.FolderDao;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {
    private final FolderDao folderDao;
    @Override
    public GetIdByFolderIdResponse getIdByFolderId(Integer folderId) {
        return folderDao.getIdByFolderId(folderId);
    }
}
