
import com.blinfosoft.feedback.dao.DaoFactory;
import com.blinfosoft.feedback.dao.FeedbackEntityManagerFactory;
import com.blinfosoft.feedback.entity.impl.Account;
import com.blinfosoft.feedback.service.AccountService;
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

    public static void main(String[] args) {
        AccountService accountService = new AccountService(new DaoFactory(FeedbackEntityManagerFactory.getInstance()));
        List<Account> accountList = accountService.getAccounts();
        accountList.forEach(account -> System.err.println(account.getAccountName()));
    }
}
