import InfoStuCou.util.ConfigManage;

import java.sql.*;

public class Main {
    public static void main(String[] args){
        try{
            //查询课程表中的课程
            //连接到数据库
            Connection con = DriverManager.getConnection(ConfigManage.getProp("url"),ConfigManage.getProp("user"),ConfigManage.getProp("password"));
            //将添加命令发送到数据库
            Statement statement =con.createStatement();
            String sql ="select * from CouInfo";
            //使数据库执行所发送的命令
            ResultSet rs =statement.executeQuery(sql);
            //输出课程表中的信息
            while(rs.next()){
                System.out.print("课程号"+rs.getString("CouCode"));
                System.out.print(",");
                System.out.print("课程名"+rs.getString("CouName"));
                System.out.print(",");
                System.out.print("学分"+rs.getString("CouPri"));
                System.out.print(",");
                System.out.print("学时"+rs.getString("CouHour"));
                System.out.print(",");
            }
            System.out.println("查询课程成功！");
            rs.close();
            statement.close();
            //向课程表中插入信息
            String sql3="insert into CouInfo(CouCode,CouName,CouPri,CouHour) value(?,?,?,?)";
            PreparedStatement preparedStatement=con.prepareStatement(sql3);
            preparedStatement.setString(1,"003");
            preparedStatement.setString(2,"java");
            preparedStatement.setString(3,"5");
            preparedStatement.setString(4,"60");
            int result1=preparedStatement.executeUpdate();
            if(result1!=0){
                System.out.println("插入课表成功！");
            }
            preparedStatement.close();
            //删除课表中的信息
            Statement stmt=con.createStatement();
            String sql4 = "delete from couinfo where CouCode='001'";
            stmt.executeUpdate(sql4);
            stmt.close();
            System.out.println("delete success ! ");
            //更改课表中的信息
            Statement statement1=con.createStatement();
            String sql5="Update couinfo set CouHour=70 where CouName='C'";
            statement1.executeUpdate(sql5);
            statement1.close();
            System.out.println("updata success !");
            //查询学生信息
            //添加命令发送到数据库
            Statement statement =con.createStatement();
            String sql_1 ="select * from stuinfo";
            //使数据库执行所发送的命令
            ResultSet rs =statement.executeQuery(sql_1);
            //输出学生信息
            while(rs.next()){
                System.out.print("学号"+rs.getString("StuNum"));
                System.out.print(",");
                System.out.print("姓名"+rs.getString("StuName"));
                System.out.print(",");
                System.out.print("年龄"+rs.getString("StuAge"));
                System.out.print(",");
                System.out.print("性别"+rs.getString("StuSex"));
                System.out.print(",");
            }
            System.out.println("查询学生信息成功！");
            rs.close();
            statement.close();
            //删除学生表中的信息
            Statement stmt_1=con.createStatement();
            String sql_4 = "delete from stuinfo where StuNum='20201060001'";
            stmt_1.executeUpdate(sql_4);
            stmt_1.close();
            System.out.println("delete success ! ");
            //更改学生表中的信息
            Statement statement_1=con.createStatement();
            String sql_5="Update stuinfo set StuAge=19 where StuName='小壮'";
            statement_1.executeUpdate(sql_5);
            statement_1.close();
            System.out.println("updata success !");
            //向学生表中进行增加操作
            String sql2="insert into StuInfo(StuNum,StuName,StuAge,StuSex) value(?,?,?,?)";
            PreparedStatement pst =con.prepareStatement(sql2);
            pst.setString(1,"20201060005");
            pst.setString(2,"张三");
            pst.setString(3,"20");
            pst.setString(4,"1");
            int result=pst.executeUpdate();
            if(result!=0){
                System.out.println("插入学生信息成功！");
            }
            pst.close();
            con.close();//断开与数据库的连接

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
