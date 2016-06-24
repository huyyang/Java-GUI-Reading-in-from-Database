import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private String to_do[], progress[], done[];
    private String getName, getPass, getUser;
    private ArrayList<String> toDoList, progressList, doneList, nameList;
    private int openAccess;


    public Database(){
        to_do = new String[5];
        progress = new String[5];
        done = new String[5];
        getUser = new String();
        getPass = new String();
        toDoList = new ArrayList<String>(5);
        progressList = new ArrayList<String>(5);
        doneList = new ArrayList<String>(5);
        nameList = new ArrayList<String>(40);
    }
    public String returnName()  {   return getName; }
    public String getGetPass() {
        return getPass;
    }

    public String getGetUser(){
        return getUser;
    }

    public int getOpenAccess(){
        return openAccess;
    }

    ArrayList<String> returnNames(){
        Connection conn = null;
        Statement stmt = null;
        ArrayList <String> lists = new ArrayList();


        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/TestExample", "root", "password");

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT name, to_do, to_do2, to_do3, to_do4, to_do5," +
                    "progress, progress2, progress3, progress4, progress5," +
                    "done, done2, done3, done4, done5 FROM personSchedule";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                String getCurrentName = rs.getString("name");
                to_do[0] = rs.getString("to_do");
                to_do[1] = rs.getString("to_do2");
                to_do[2] = rs.getString("to_do3");
                to_do[3] = rs.getString("to_do4");
                to_do[4] = rs.getString("to_do5");
                progress[0] = rs.getString("progress");
                progress[1] = rs.getString("progress2");
                progress[2] = rs.getString("progress3");
                progress[3] = rs.getString("progress4");
                progress[4] = rs.getString("progress5");
                done[0] = rs.getString("done");
                done[1] = rs.getString("done2");
                done[2] = rs.getString("done3");
                done[3] = rs.getString("done4");
                done[4] = rs.getString("done5");
                lists.add(getCurrentName);
                /*
                for (int i = 0; i < 5; i++) {
                    if(to_do[i] != " ")
                        lists.add(to_do[i]);
                    if(progress[i] != " ")
                        lists.add(progress[i]);
                    if(done[i] != " ")
                        lists.add(done[i]);
                }
                */
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {

            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return lists;
    }

    public boolean access(String username, String password) {

        Connection conn = null;
        Statement stmt = null;
        boolean chooseToReturn = false;
        int flag2 = 1;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/TestExample", "root", "password");

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT password, username, name, to_do, to_do2, to_do3, to_do4, to_do5," +
                    "progress, progress2, progress3, progress4, progress5," +
                    "done, done2, done3, done4, done5 FROM personSchedule";
            ResultSet rs = stmt.executeQuery(sql);


            int flag = 1;
            String getUserInfo = " ";
            String getPassInfo = " ";

            while (rs.next()) {

                getUserInfo = rs.getString("username");
                getPassInfo = rs.getString("password");
                if (getUserInfo.equals(username) && getPassInfo.equals(password)) {
                    getName = rs.getString("name");
                    to_do[0] = rs.getString("to_do");
                    to_do[1] = rs.getString("to_do2");
                    to_do[2] = rs.getString("to_do3");
                    to_do[3] = rs.getString("to_do4");
                    to_do[4] = rs.getString("to_do5");
                    progress[0] = rs.getString("progress");
                    progress[1] = rs.getString("progress2");
                    progress[2] = rs.getString("progress3");
                    progress[3] = rs.getString("progress4");
                    progress[4] = rs.getString("progress5");
                    done[0] = rs.getString("done");
                    done[1] = rs.getString("done2");
                    done[2] = rs.getString("done3");
                    done[3] = rs.getString("done4");
                    done[4] = rs.getString("done5");
                    flag2 = 0;

                }
                else
                    flag = 0;

            }
            this.getUser = getUserInfo;
            this.getPass = getPassInfo;

            if(flag == 0 && flag2 == 1) {
                return false;
            }
            else {
                for (int i = 0; i < 5; i++) {
                    if(!to_do[i].equals(" "))
                        toDoList.add(to_do[i]);
                    if(!progress[i].equals(" "))
                        progressList.add(progress[i]);
                    if(!done[i].equals(" "))
                        doneList.add(done[i]);
                }

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {

            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        if(flag2 == 0)
            return true;
        else
            return false;

    }
    public boolean accessName(String name) {

        Connection conn = null;
        Statement stmt = null;
        boolean chooseToReturn = false;
        int flag2 = 1;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/TestExample", "root", "password");

            stmt = conn.createStatement();
            String sql;
            sql = "SELECT password, username, name, to_do, to_do2, to_do3, to_do4, to_do5," +
                    "progress, progress2, progress3, progress4, progress5," +
                    "done, done2, done3, done4, done5 FROM personSchedule";
            ResultSet rs = stmt.executeQuery(sql);


            int flag = 1;
            String getUserInfo = " ";
            String getPassInfo = " ";

            while (rs.next()) {
                getName = rs.getString("name");
                if (getUserInfo.equals(name)){
                    to_do[0] = rs.getString("to_do");
                    to_do[1] = rs.getString("to_do2");
                    to_do[2] = rs.getString("to_do3");
                    to_do[3] = rs.getString("to_do4");
                    to_do[4] = rs.getString("to_do5");
                    progress[0] = rs.getString("progress");
                    progress[1] = rs.getString("progress2");
                    progress[2] = rs.getString("progress3");
                    progress[3] = rs.getString("progress4");
                    progress[4] = rs.getString("progress5");
                    done[0] = rs.getString("done");
                    done[1] = rs.getString("done2");
                    done[2] = rs.getString("done3");
                    done[3] = rs.getString("done4");
                    done[4] = rs.getString("done5");
                    flag2 = 0;

                }
                else
                    flag = 0;

            }
            this.getUser = getUserInfo;
            this.getPass = getPassInfo;

            if(flag == 0 && flag2 == 1) {
                return false;
            }
            else {
                for (int i = 0; i < 5; i++) {
                    if(!to_do[i].equals(" "))
                        toDoList.add(to_do[i]);
                    if(!progress[i].equals(" "))
                        progressList.add(progress[i]);
                    if(!done[i].equals(" "))
                        doneList.add(done[i]);
                }

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {

            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        if(flag2 == 0)
            return true;
        else
            return false;

    }
    public int addAcccount(String user, String pass, String name, ArrayList<String> toDo) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/TestExample", "root", "password");

            stmt = conn.createStatement();

            int toDoInt = toDo.size();
            int index2 = 0;
            if (toDoInt != 5) {
                index2 = toDoInt;
                while (index2 != 5) {
                    toDo.add(" ");
                    ++index2;
                }
            }
            String getUserInfo, getPassInfo;
            String sql;
            sql = "SELECT password, username, name, to_do, to_do2, to_do3, to_do4, to_do5," +
                    "progress, progress2, progress3, progress4, progress5," +
                    "done, done2, done3, done4, done5 FROM personSchedule";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                getUserInfo = rs.getString("username");
                getPassInfo = rs.getString("password");
                if (getUserInfo.equals(user) || getPassInfo.equals(pass)) {
                    System.out.println("NOPE!");
                    stmt.close();
                    conn.close();
                    return 0;
                }
            }
            String addInto = "INSERT INTO personSchedule " +
                    "VALUES (" + "'" + user + "'" + ", " + "'" + pass +
                    "'" + ", " + "'" + name + "'" + "," + "'" + toDo.get(0) +
                    "'" + "," + "'" + toDo.get(1) + "'" + "," + "'" + toDo.get(2) +
                    "'" + "," + "'" + toDo.get(3) + "'" + ", " + "'" + toDo.get(4) +
                    "'" + "," + "' ',' ',' ',' ',' ',' ',' ',' ',' ',' ');";
            stmt.executeUpdate(addInto);

            stmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {

            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return 1;
    }
    public int addToDo(String add){
        if(progressList.size() == 5){
            return 0;
        }
        else{
            //for (int i = 0; i < 5; i++) {
                if(toDoList.contains(add)) {
                    toDoList.remove(add);
                    progressList.add(add);
                }

            //}
        }
        int to_do_int = toDoList.size();
        int progress_int = progressList.size();
        int done_int = doneList.size();

        int index = 1;
        if(to_do_int != 5) {
            index = to_do_int;
            while (index != 5) {
                toDoList.add(" ");
                ++index;
            }
        }
        index = 1;
        if(progress_int != 5){
            index = progress_int;
            while(index != 5){
                progressList.add(" ");
                ++index;
            }
        }
        index = 1;
        if(done_int != 5){
            index = done_int;
            while(index != 5){
                doneList.add(" ");
                ++index;
            }
        }
        return 1;
    }
    public int addInProgress(String add) {
        if (doneList.size() == 5) {
            return 0;
        } else {
            //for (int i = 0; i < 5; i++) {
                if (progressList.contains(add)) {
                    progressList.remove(add);
                    doneList.add(add);
                }

            //}
            int to_do_int = toDoList.size();
            int progress_int = progressList.size();
            int done_int = doneList.size();

            int index = 1;
            if(to_do_int != 5) {
                index = to_do_int;
                while (index != 5) {
                    toDoList.add(" ");
                    ++index;
                }
            }
            index = 1;
            if(progress_int != 5){
                index = progress_int;
                while(index != 5){
                    progressList.add(" ");
                    ++index;
                }
            }
            index = 1;
            if(done_int != 5){
                index = done_int;
                while(index != 5){
                    doneList.add(" ");
                    ++index;
                }
            }

            return 1;
        }
    }
    public int addMoreToDo(String add){
        if(toDoList.size() == 5){
            return 0;
        }
        else{
                    toDoList.add(add);
        }
        int to_do_int = toDoList.size();
        int progress_int = progressList.size();
        int done_int = doneList.size();

        int index = 1;
        if(to_do_int != 5) {
            index = to_do_int;
            while (index != 5) {
                toDoList.add(" ");
                ++index;
            }
        }
        index = 1;
        if(progress_int != 5){
            index = progress_int;
            while(index != 5){
                progressList.add(" ");
                ++index;
            }
        }
        index = 1;
        if(done_int != 5){
            index = done_int;
            while(index != 5){
                doneList.add(" ");
                ++index;
            }
        }
        return 1;
    }
    public int addToDone(String add){
        if(doneList.size() == 0){
            return 0;
        }
        else{
            if(doneList.contains(add)){
                doneList.remove(add);
            }
        }

        int to_do_int = toDoList.size();
        int progress_int = progressList.size();
        int done_int = doneList.size();

        int index = 1;
        if(to_do_int != 5) {
            index = to_do_int;
            while (index != 5) {
                toDoList.add(" ");
                ++index;
            }
        }
        index = 1;
        if(progress_int != 5){
            index = progress_int;
            while(index != 5){
                progressList.add(" ");
                ++index;
            }
        }
        index = 1;
        if(done_int != 5){
            index = done_int;
            while(index != 5){
                doneList.add(" ");
                ++index;
            }
        }
        return 1;
    }


    public ArrayList<String> getDoneList() {
        return doneList;
    }

    public ArrayList<String> getProgressList() {
        return progressList;
    }

    public ArrayList<String> getToDoList() {
        return toDoList;
    }

    public void update(String username, String password){

        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/TestExample","root","password");
            stmt = conn.createStatement();

            //UPDATE table name
            String updateSomething = "UPDATE personSchedule " +
                    "SET to_do = ?, to_do2 = ?, to_do3 = ?, to_do4 = ?, to_do5 = ?," +
                    "progress = ?, progress2 = ?, progress3 = ?, progress4 = ?, progress5 = ?," +
                    "done = ?, done2 = ?, done3 = ?, done4 = ?, done5 = ? WHERE username = ? ";
            PreparedStatement updateStatement = conn.prepareStatement(updateSomething);

            for (int i = 0; i < 5; ++i) {
                updateStatement.setString(i+1, toDoList.get(i));
                updateStatement.setString(i+6, progressList.get(i));
                updateStatement.setString(i+11, doneList.get(i));
            }

            updateStatement.setString(16, username);
            int rowAffected = updateStatement.executeUpdate();

            //FROM table name
            String sql;
            sql = "SELECT password, username, name, to_do, to_do2, to_do3, to_do4, to_do5," +
                    "progress, progress2, progress3, progress4, progress5," +
                    "done, done2, done3, done4, done5 FROM personSchedule";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                String getUser = rs.getString("username");
                String getPass = rs.getString("password");

                if (getUser.equals(username) && getPass.equals(password)) {

                    getName = rs.getString("name");
                    to_do[0] = rs.getString("to_do");
                    to_do[1] = rs.getString("to_do2");
                    to_do[2] = rs.getString("to_do3");
                    to_do[3] = rs.getString("to_do4");
                    to_do[4] = rs.getString("to_do5");
                    progress[0] = rs.getString("progress");
                    progress[1] = rs.getString("progress2");
                    progress[2] = rs.getString("progress3");
                    progress[3] = rs.getString("progress4");
                    progress[4] = rs.getString("progress5");
                    done[0] = rs.getString("done");
                    done[1] = rs.getString("done2");
                    done[2] = rs.getString("done3");
                    done[3] = rs.getString("done4");
                    done[4] = rs.getString("done5");
                }

            }

            rs.close();
            stmt.close();
            conn.close();

        }
        catch(SQLException se){
            se.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(stmt != null)
                    stmt.close();
            }
            catch(SQLException se2){

            }
            try{
                if(conn != null)
                    conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
        }

    }

}
