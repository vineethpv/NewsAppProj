# NewsAppProj
A simple android app that displays news feed in a list.

Language - Java
Design pattern - MVP(Model-View-Presenter)

#FrameWorks used
Retrofit for networking
Dagger2 for dependency injection
Mockito, Espresso & MockWebServer for unit testing, UI testing and api response mocking respectively
ConstraintLayout for UI xml rendering

# Test coverage
Unit testing - com.demo.newsfeedapp.presenter.HomeScreenPresenterTest
  Success and sad path covered
  
UI testing - com.demo.newsfeedapp.ui.activities.HomeScreenActivityTest
  Success path - List visibility checked
  Sad path - Error message view visibility checked
