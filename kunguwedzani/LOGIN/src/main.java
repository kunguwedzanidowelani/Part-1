/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 import java.util.Scanner;

 /**
  *
  * @ST10242023
  */
 public class Main {
 
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         Login lgn = new Login();
 
         //Login
         String uSERname;
         String passWORD;
 
         // Registration
         String fname;
         String l_name;
         String r_pass;
         String r_uname;
         String response;
 
         boolean exit = false;
 
         try {
             do {
                 System.out.println();
                 System.out.println("Press \t1. to Login \n\t2. Register\n\t0. to Exit");
                 int choice = input.nextInt();
                 switch (choice) {
                     case 1:
                         System.out.print("Username: ");
                         uSERname = input.next();
                         System.out.print("Password: ");
                         passWORD = input.next();
 
                         lgn.setUsername(uSERname);
                         lgn.setPassword(passWORD);
 
                         response = lgn.registerUser();
                         if (!response.isEmpty()) {
                             System.out.println(response);
                         } else if (response.isEmpty()) {
                             // Compare user and password
                             boolean success = lgn.loginUser(uSERname, passWORD);
                             System.out.println(lgn.returnLoginStatus(success));
                         }
                         
                         break;
                     case 2:
                         System.out.print("First Name: ");
                         fname = input.next();
                         System.out.print("Last Name: ");
                         l_name = input.next();
                         System.out.print("Username: ");
                         r_uname = input.next();
                         System.out.print("Password: ");
                         r_pass = input.next();
 
                         lgn.setFirstname(fname);
                         lgn.setLastname(l_name);
                         lgn.setUsername(r_uname);
                         lgn.setPassword(r_pass);
 
                         response = lgn.registerUser();
                         if (fname.equals("")) {
                             System.out.println("First name cannot be empty");
                         } else if (l_name.equals("")) {
                             System.out.println("Last name cannot be empty");
                         } else if (!response.equals("")) {
                             System.out.println(response);
                         } else {
                             System.out.println("User has been registered successfully");
                         }
                         break;
                     case 0:
                         exit = true;
                         break;
                 }
 
             } while (!exit);
         } catch (Exception ex) {
             System.out.println(ex.getMessage());
         } finally {
             if (input != null) {
                 input.close();
             }
         }
     }
 
 }