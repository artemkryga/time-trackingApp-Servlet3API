package ua.kryha.timetrack.service;

import ua.kryha.timetrack.dao.PersistenseChoiceDao;
import ua.kryha.timetrack.model.EUserAction;
import ua.kryha.timetrack.model.PersistenseChoice;
import ua.kryha.timetrack.payload.request.ActivityRequest;
import ua.kryha.timetrack.payload.response.AllUserPersistenceResponse;
import ua.kryha.timetrack.payload.response.PersistenceResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersistenceChoiсeService {


    private PersistenseChoiceDao persistenseChoiceDao;

    private ActivityService activityService;

    private UserPageService userService;

    public PersistenceChoiсeService(PersistenseChoiceDao persistenseChoiceDao, ActivityService activityService, UserPageService userService) {

        this.persistenseChoiceDao = persistenseChoiceDao;
        this.activityService = activityService;
        this.userService = userService;

    }

    public void deletePerChoice(Integer id) {
        persistenseChoiceDao.delete(id);
    }

    public void save(ActivityRequest activityRequest) {

        PersistenseChoice persistenceChoice = new PersistenseChoice();

        persistenceChoice.setActivity(activityService.getActivityByName(activityRequest.getNameAct()));

        persistenceChoice.setUser(userService.getUserByName(activityRequest.getUserName()));

        persistenceChoice.setAction(EUserAction.valueOf(activityRequest.getAction()));

        persistenseChoiceDao.save(persistenceChoice);
    }

    public List<AllUserPersistenceResponse> getAllUserChoice() {

        List<AllUserPersistenceResponse> listResponse = new ArrayList<>();

        List<PersistenseChoice> persistenceChoices = persistenseChoiceDao.findAll();

        userService.getAllUser().forEach(user ->
                listResponse.add(new AllUserPersistenceResponse(user.getUsername(), new ArrayList<PersistenceResponse>() {{
                    persistenceChoices.stream()
                                       .filter(persistenceChoice -> persistenceChoice
                                         .getUser().getUsername().equals(user.getUsername()))
                                           .collect(Collectors.toList()).forEach(pChoice -> add(new PersistenceResponse(
                                                   pChoice.getId(),
                                                   pChoice.getActivity().getName(),
                                                   pChoice.getAction()))
                    );
                }}
                ))
        );
        return listResponse;
    }

    public List<PersistenseChoice> getPersistenceResponseByUser(String name) {

        return persistenseChoiceDao.findAll()
                .stream()
                    .filter(persistenceChoice -> persistenceChoice
                                                   .getUser()
                                                    .getUsername().equals(name))
                        .collect(Collectors.toList());
    }


    public void deletePersistenceChoice(Integer id) {

        persistenseChoiceDao.delete(id);

    }

}
