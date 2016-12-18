
import com.blinfosoft.feedback.db.IssueEntityManagerFactory;
import com.blinfosoft.feedback.entity.App;
import com.blinfosoft.feedback.entity.Issue;
import com.blinfosoft.feedback.entity.Admin;
import com.blinfosoft.feedback.entity.User;
import com.blinfosoft.feedback.service.AppService;
import com.blinfosoft.feedback.service.IssueService;
import com.blinfosoft.feedback.service.AdminService;
import com.blinfosoft.feedback.service.UserService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author js
 */
public class Main {

    public static void main(String[] args) {
        // User u = new User();
        // List<Admin> admin = new ArrayList<>();
        // App app = new App();
        //   List<App> apps = new ArrayList<>();
          List<Issue> issues = new ArrayList<>();
        //  Issue issue = new Issue();
        // issue.setTitle("i am a issue");
        //   u.setEmail("jorawar@hoSDtmaiadsdl.com");
        //   u.setUserName("jssdffingh");
        //issue.setUser(u);
        // issue.setApp(app);
        // admin.setName("Madhu Singh");
        // app.setAdmin(admin);
        // app.setName("madhu app");
        // apps.add(app);
        //     issues.add(issue);
        //   admin.setApp(apps);
        // AdminService adminService = new AdminService(IssueEntityManagerFactory.getEmf());
        // admin = adminService.getUsers();
        //  AppService appService = new AppService(IssueEntityManagerFactory.getEmf());
        //   apps = appService.getAppsByAdmin(2);
        // apps.forEach(app -> System.out.println(app.getName()));
        IssueService issueService = new IssueService(IssueEntityManagerFactory.getEmf());
        issues = issueService.getIssueByUserId(1);
        issues.forEach(issue -> System.out.println(issue.getTitle()));
        // UserService userService = new UserService(IssueEntityManagerFactory.getEmf());
        //  userService.createUser(u);
        //   issueService.createIssueAndUser(issue,1,u);
        //   app.setUser(u);
        // app.setName("My App test App"); 
        // aapService.createAppByUser(app, 1);
        //  user.deleteUser(8);
        // List<User> users = user.getUsers();
        //admin.forEach(item -> {
        //  item.getApp().forEach(app -> System.out.println(app.getName()));
        // });
        //  aapService.createApp(app);
    }
}
