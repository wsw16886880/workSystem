package com.worksystem.service;

import org.springframework.stereotype.Service;

/**
 * @author wsw16
 */
@Service
public class FileService {

    private final WorkService service;

    private final LateService lateService;

    public FileService(WorkService service, LateService lateService) {
        this.service = service;
        this.lateService = lateService;
    }

    public int fileLoad() {
        return 0    ;
    }
}
