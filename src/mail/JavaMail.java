/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

public class JavaMail {
    public void accept(String mail,String msg) 
    {
        try
        {
            Send.SendMail(mail,msg);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void reject(String mail,String msg) 
    {
        try
        {
            Send.SendMail(mail,msg);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

