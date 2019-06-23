package MysqlTest;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 类名称；Test
 * 类描述：java连接Mysql
 * 创建人：吴海董
 */
public class Test {

    static String sql = null;
    static Main db1 = null;
    static ResultSet ret = null;
    static Connection coon = null;

    public static void main(String[] args) {

        Main main = new Main();
        coon = main.dBConnection();

        /*Student student = new Student(6, "www", 88, "男", 23);
        if (main.insertStudent(student)) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }*/

      /* if(main.deleteStudent("6")){
            System.out.println("删除成功");
       }else{
           System.out.println("删除失败");
       }*/

      if(main.updateStudent("www",10)){
          System.out.println("更新成功");
      }else {
          System.out.println("更新失败");
      }

        List<Student> studentList = main.selectAllStudent();
        for (Student stu : studentList) {
            System.out.println(stu.toString());
        }
    }
}



