package ua.kryha.timetrack.service;

import ua.kryha.timetrack.dao.ActivityDao;
import ua.kryha.timetrack.dao.CategoryDao;
import ua.kryha.timetrack.dao.UserDao;
import ua.kryha.timetrack.exception.UsernameNotFoundException;
import ua.kryha.timetrack.model.Activity;
import ua.kryha.timetrack.model.DailyStatistic;
import ua.kryha.timetrack.model.PersistenseChoice;
import ua.kryha.timetrack.model.User;
import ua.kryha.timetrack.payload.request.AdminActionRequest;
import ua.kryha.timetrack.payload.response.ActivityResponse;
import ua.kryha.timetrack.payload.response.UserActivityCategResponse;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserPageService {


    private UserDao userDao;


    private ActivityService activityService;


    private CategoryService categoryService;


    private PersistenceChoiсeService persistenceChoiceService;

    public UserPageService(UserDao userDao, ActivityService activityService, CategoryService categoryService) {

        this.userDao = userDao;
        this.activityService = activityService;
        this.categoryService = categoryService;

    }

    public User getUserByName(String name) {

        return userDao.findByUsername(name)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + name));

    }


    private List<ActivityResponse> filterActivityByUser(String name) {

        List<Integer> listActivityid = activityService.getActivitiesIdByUser(name);
        List<ActivityResponse> activityList = activityService.getAllActivity();
        activityList.forEach(activityResponse ->
                listActivityid.forEach(activityId -> {
                            if (activityResponse.getId().equals(activityId))
                                activityResponse.setUserHas(true);
                        }
                )
        );

        return activityList;
    }

    private List<ActivityResponse> filterActivityByStatus(String name, List<ActivityResponse> activityList) {
        List<PersistenseChoice> userPersistenceChoice = persistenceChoiceService.getPersistenceResponseByUser(name);

        activityList.forEach(activityResponse ->
                userPersistenceChoice.forEach(persistenceChoice -> {
                            if (activityResponse.getNameAct().equals(persistenceChoice.getActivity().getName()))
                                activityResponse.setStatus("WAIT");
                        }
                )
        );

        return activityList;
    }

    public List<UserActivityCategResponse> getAllActivityByUser(String name) {

        List<UserActivityCategResponse> responseList = new ArrayList<>();

        List<ActivityResponse> activityList = filterActivityByStatus(name, filterActivityByUser(name));

        categoryService.getAllCategory().forEach(category -> {
                  responseList.add(new UserActivityCategResponse(category.getName(),
                          activityList.stream()
                                         .filter(activity -> activity.getNameCateg().equals(category.getName()))
                                            .collect(Collectors.toList())));
        });

        return responseList;
    }


    //TODO extract duplicate
    public void addActivityToUser(AdminActionRequest adminActionRequest) {

        //TODO getUserID only and AvtivityID only
        User user = userDao.findByUsername(adminActionRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Activity activity = activityService.getActivityByName(adminActionRequest.getNameActivity());
        Integer userId = user.getId();
        Integer activityId = activity.getId();
        activityService.addActivityToUser(userId, activityId);

        persistenceChoiceService.deletePerChoice(adminActionRequest.getId());


    }

    //TODO extract duplicate
    public void deleteActivityToUser(AdminActionRequest adminActionRequest) {

        User user = userDao.findByUsername(adminActionRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + adminActionRequest.getUsername()));
        Activity activity = activityService.getActivityByName(adminActionRequest.getNameActivity());

        Integer userId = user.getId();
        Integer activityId = activity.getId();

        activityService.deleteActivityFromUser(userId, activityId);

        persistenceChoiceService.deletePerChoice(adminActionRequest.getId());

    }


    public List<User> getAllUser() {
        return userDao.findAll();
    }

    public void setPersistenceChoiceService(PersistenceChoiсeService persistenceChoiceService) {
        this.persistenceChoiceService = persistenceChoiceService;
    }
}
