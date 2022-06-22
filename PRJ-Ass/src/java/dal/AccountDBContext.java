/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Asus
 */
public class AccountDBContext extends DBContext {
    
    public Account getAccount(String usename , String password){
        Account account = null;
        String sql = "SELECT * from Account WHERE username = ? AND password = ?";
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, usename);
            preparedStmt.setString(2, password);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                account = new Account();
                account.setUserName(rs.getString("username"));
                account.setPassWord(rs.getString("password"));
                account.setRole(rs.getInt("role"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }
    
    public Account getAccount(String usename){
        Account account = null;
        String sql = "SELECT * from Account WHERE username = ?";
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, usename);
            ResultSet rs = preparedStmt.executeQuery();
            while(rs.next()){
                account = new Account();
                account.setUserName(rs.getString("username"));
                account.setPassWord(rs.getString("password"));
                account.setRole(rs.getInt("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return account;
    }

    public ArrayList<Account> getAccs() {
        ArrayList<Account> accs = new ArrayList<>();
        try {
            String sql = "select Username, Password from Account";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            Account acc;
            while (rs.next()) {
                acc = new Account();
                acc.setUserName(rs.getString("Username"));
                acc.setPassWord(rs.getString("Password"));
                accs.add(acc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accs;
    }

    @Override
    public ArrayList list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
