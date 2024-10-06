package com.aesl.task.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GetIdByFolderIdResponse {
    private List<Integer> folderids;
}
