package ua.kryha.timetrack.service;


import ua.kryha.timetrack.payload.response.AllUserPersistenceResponse;

import java.util.List;

public class AdminPageService {


    private PersistenceChoiсeService persistenceChoiceService;

    public AdminPageService(PersistenceChoiсeService persistenceChoiceService) {

        this.persistenceChoiceService = persistenceChoiceService;
    }


}
