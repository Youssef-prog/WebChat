package com.agent.chat;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

class FileOperation
{ 
    static FileOperation filework;
    BufferedReader reader = null;
    private final String profile = ".cache/profile.private";
    private final String userlist = ".cache/userlist";
    private final String sessionfile = ".cache/sessions";
    private final String networkfile = ".cache/networkConfig";
    
    private String email;
    private String username;
    private String receivemessage;
    private String sendmessage;
    private List<String> IPC;
    private String password;
    private String profileimagepath;
    private List<String> session = new ArrayList<String>();
    private Util util = new Util();
    private String iparea;

    public void readFile() throws Exception  {
        this.reader= new BufferedReader(new FileReader(profile));
        this.username = reader.readLine();
        this.email = reader.readLine();
        this.password = reader.readLine();
        this.profileimagepath = reader.readLine();
        this.iparea = reader.readLine();
        reader.close();
    }
    
     public void readUserFile() throws Exception  {
        this.reader= new BufferedReader(new FileReader(userlist));
        String temp = reader.readLine();
        if (temp != null) {
            this.IPC = util.transform2IPC(temp);
        }
        else {
            this.IPC = null;
        }
        reader.close();
    }
     
     public void readSessionFile() throws Exception  {
        this.reader= new BufferedReader(new FileReader(sessionfile));
        String temp = reader.readLine();
        this.session = util.transform2Session(temp);
        reader.close();
    }
     

    public boolean checkIsProfileOkay() throws Exception {
        try { 
            readFile(); 
        }
        catch (Exception e) {
            return false;
        }

        return (!(this.username == null || this.password == null || this.email == null));

    }

    public String getUsername() {
        try { 
            readFile(); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return this.username;
    }
    
    public String getPath() {
        try { 
            readFile(); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return this.profileimagepath;
    }

    public String getPassword() {
        try { 
            readFile(); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return this.password;
    }
    
    public List<String> getSessions() {
        try { 
            readSessionFile(); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return this.session;
    }
    
    public String getIpArea() {
        try { 
            readFile(); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return this.iparea;
    }
    


    public void createNewProfile(String username,String password,String email, String profileimagepath, String iparea) throws Exception {
        PrintWriter writer = new PrintWriter(profile);
        writer.println(username);
        writer.println(email);
        writer.println(password.hashCode());
        writer.println(profileimagepath);
        writer.println(iparea);
        writer.close();
    }
    
    public void saveUser(List<String> IPC) throws Exception {
        PrintWriter writer = new PrintWriter(userlist);
        writer.println(IPC);
        writer.close();
    }
    
    public void saveChatSession(String xsource, String xsender, int sessionId) throws Exception {
        this.reader= new BufferedReader(new FileReader(sessionfile));
        String temp = reader.readLine();
        if (!(temp == null || temp.equals(""))) {
            this.session = util.transform2Session(temp);
        }
        
        reader.close();
        String toAdd = xsource + ":" + xsender + ":" + sessionId;
        System.out.println("[DEBUG] toAdd : "+ toAdd);
        this.session.add(toAdd);
        PrintWriter writer = new PrintWriter(sessionfile);
        writer.println(this.session);
        writer.close();
    }
    
    public List<String> getuser() throws Exception {
        try { 
            readUserFile(); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return this.IPC;
    }
        
   
}