package MysqlTest;

import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 项目名称：数据库的操作
 * 类名称：Main
 * 类描述：Mysql数据库操作类
 * 创建人：吴海董
 */

public class Main {

    public static final String url = "jdbc:mysql://127.0.0.1/vge_whu?serverTimezone=UTC";
    public static final String name = "com.mysql.cj.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "whd619...";

    public Connection coon = null;
    public PreparedStatement pst = null;
    static ResultSet ret = null;

    //数据库连接

    public Connection dBConnection() {
        try {
            Class.forName(name);
            coon = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coon;
    }

    // 查询记录，并把查询结果放在list中

    public List<Student> selectAllStudent() {
        List<Student> studentList = new ArrayList<Student>(); //存放查询结果
        String sql = "select*from user";

        try {
            Statement statement = coon.createStatement();
            ret = statement.executeQuery(sql);
            while (ret.next()) {
                Student stu = new Student();
                stu.setAge(ret.getInt("age"));
                stu.setName(ret.getString("name"));
                stu.setId(ret.getInt("Id"));
                stu.setScore(ret.getInt("score"));
                stu.setSex(ret.getString("sex"));
                studentList.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentList;
    }

    // 插入学生记录，如果成功，返回true
    public boolean insertStudent(Student stud) {
        int i = 0;
        String sqlInsert = "insert into `user` (Id,name,score,sex,age) values(?,?,?,?,?)";


        try {
            pst = coon.prepareStatement(sqlInsert);
            pst.setInt(1, stud.getId());
            pst.setString(2, stud.getName());
            pst.setInt(3, stud.getScore());
            pst.setString(4, stud.getSex());
            pst.setInt(5, stud.getAge());
            i = pst.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteStudent(int nn) {
        int i=0;

        String sqlDelete = String.format("delete from `user` where Id = \"%s\"", nn);
        try {
            pst = coon.prepareStatement(sqlDelete);
            i = pst.executeUpdate();
            Logger.getGlobal().warning(String.format("删除成功，影响了 %d 行", i));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStudent(String name,int age){
        String sqlUpdate=String.format("update user set `age`= ? where `name`= ?",age,name);
        try {
            int i=0;
            pst=coon.prepareStatement(sqlUpdate);
            pst.setInt(1,age);
            pst.setString(2,name);
            i=pst.executeUpdate();
            if(i==1){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}