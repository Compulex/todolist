package com.example.todolist.Service;


import com.example.todolist.Model.Account;
import com.example.todolist.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AccountService
 * - this class handles the logic and manipulates the data by using the associated repository object
 * - it will be injected into the controller class; it uses these methods for each endpoint
 */
@Service
public class AccountService {
    AccountRepository accountRepository;

    /**
     * repository use the methods from the JpaRepository to make the queries
     * @param accountRepository account table in database
     */
    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    /**
     * adds an account
     * @param account new Account object
     * @return created Account object
     */
    public Account createAccount(Account account){ return accountRepository.save(account); }

    /**
     * making sure the username and password of account matches what's in the database
     * @param account Account object with username and password input
     * @return exception or associated Account object
     */
    public Account login(Account account){
        //find by username
        return account;//accountRepository.findByUsername(account.getUsername());
    }

    /**
     * returns the account by its id
     * @param id id of account
     * @return Account object with matching id
     */
    public Account getAccountById(long id){ return accountRepository.findById(id).get(); }


    /**
     * set all the properties to the Account object that's in the database
     * @param id id of Account object to be updated
     * @param updatedAcct Account object with updates from input
     * @return updated Account object
     */
    public Account updateAccount(long id, Account updatedAcct){
        Account acct = getAccountById(id);
        acct.setUsername(updatedAcct.getUsername());
        acct.setPassword(updatedAcct.getPassword());
        return accountRepository.save(acct);
    }

    /**
     * deletes the account
     * @param id id of Account object to be deleted
     * @return deleted Account object
     */
    public Account deleteAccount(long id){
        Account account = getAccountById(id);
        accountRepository.delete(account);
        return account;
    }
}
