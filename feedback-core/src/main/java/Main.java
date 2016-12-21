
import com.blinfosoft.feedback.dao.DaoFactory;
import com.blinfosoft.feedback.dao.FeedbackEntityManagerFactory;
import com.blinfosoft.feedback.entity.impl.Account;
import com.blinfosoft.feedback.exception.AccountNotFoundException;
import com.blinfosoft.feedback.service.AccountService;
import com.blinfosoft.feedback.service.AppService;
import java.util.List;

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

    public static void main(String[] args) throws AccountNotFoundException {
        AppService appService = new AppService(new DaoFactory(FeedbackEntityManagerFactory.getInstance()));
        appService.getApps();
       /* AccountService accountService = new AccountService(new DaoFactory(FeedbackEntityManagerFactory.getInstance()));
        Account account = accountService.getAccount(1);
       System.out.println(account.getLicense());*/
    }
}
