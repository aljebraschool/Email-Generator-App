/*An application to generate a random password and email for new worker */
package com.aljebraschool.emialapp; //package declaration

import java.util.Scanner; //import scanner class

//class declaration
public class Email {

private String firstName; //instance variable to get worker first name 
private String lastName;  // instance variable to get worker last name
private String myPassword; //instance variable to store random generated password
private String department; //instance variable to keep department type
private String alternateEmail;  //instance variable for any alternative email
private int mailboxCapacity = 500; //instance variable for mailbox capacity
private String email;               //instance variable for specified email for new worker
private String companyName = "aljebraschool.com"; //instance variable for company's name



//constructor to receive firstName and lastName

public Email (String first, String last)
{
    firstName = first; //set first name instance variable 
    lastName = last;   //set last name instance variable
    
    
    //call the setDepartment method to ask for department
    setDepartment();
    //call a getDepartment method to return the department
    getDepartment();
    //call a generatePassword method to authomatically get password
    generatePassword(10);
    
    email = firstName.toLowerCase() + "." + lastName + "@" + department + "." + companyName; //store the format of email in instance variable email
   
    

}//end constructor

//Ask for department then set it for instance variable department
private void setDepartment()
{
    Scanner input = new Scanner(System.in);  //create scanner object
    //prompt new worker for department code
    System.out.print("New worker: " + firstName + "." + " Department Code\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
    
    int option = input.nextInt(); //read worker input
    
    //use switch case to compare worker input code
    switch(option)  
    {
        case 1:department =  "Sales"; //if code is 1, set department to sales
        break;
        case 2: department = "Development"; //if code is 2, set department to Development
        break;
        case 3: department =  "Accounting"; //if code is 3, set department to Accounting
        break;
        default:department =  "";      //if code is none of the above, set department to empty string
        
    
    }//end switch
   
    
   
}//end setDepartment

//method to return value set in department
private String getDepartment()
{
    
    return department; 
    
}


//method to generate random password
private String generatePassword(int len)
{
    final String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789?/@"; //set all sets of possible letter, number and symbols to be used as password
    char[] password = new char[len];        //create a character array to store each string above in
    
    for(int i = 0; i < len; i++)  //loop throug the length of password
    {
        int rand = (int)(Math.random() * passwordSet.length());  //generate random string based on the length of passwordSet string
        password[i] = passwordSet.charAt(rand);         //store the character in each string at the index of character array called password
    
    }//end for
    
    myPassword = new String(password); //return the string format of randomize password, then store it in instance variable myPassword
    System.out.print("\nPassword: " + myPassword); //print password
    return myPassword;

}



//change the password
public void changePassword(String password)
{
    myPassword = password;
}

//set mailbox capacity
public void setMailboxCapacity(int capacity)
{
    mailboxCapacity = capacity;
}

//set alternate email
public void setAlternateEmail(String newEmail)
{
    email = newEmail;
}

public String getChangedPassword()
{
    return myPassword;
}

public int getMailboxCapacity()
{
    return mailboxCapacity;
}

public String getAlternateEmail()
{
    return email;
}

//method to summarize workers info
public String showInfo()
{
    return "\nDISPLAY NAME: " + firstName + " " + lastName + "\n" +
            "DISPALY EMAIL: " + email + "\n" +
            "MAILBOX CAPACITY: " + mailboxCapacity + "mb";
}


}//end class Email
