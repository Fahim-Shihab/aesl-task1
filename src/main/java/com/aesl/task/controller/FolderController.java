package com.aesl.task.controller;

import com.aesl.task.dto.GetIdByFolderIdResponse;
import com.aesl.task.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FolderController {

    private final FolderService folderService;

    @PostMapping("/getidbyfolderid/{folderid}")
    @ResponseBody
    public GetIdByFolderIdResponse getIdByFolderId(@PathVariable Integer folderid){
        return folderService.getIdByFolderId(folderid);
    }
}
