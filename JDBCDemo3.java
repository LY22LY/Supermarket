package SupermarketCashRegister;

/**
 * @Author: JinHe
 * @Date: 2020/7/1
 **/

import java.sql.*;
import java.util.Scanner;

/**
 * @Author: JinHe
 * @Date: 2020/6/29
 **/
public class JDBCDemo3 {
    // 数据库的基本信息
    static final String url="jdbc:mysql://localhost:3306/db_cashregister?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String root="root";
    static final String pwd ="123456";
    private static PreparedStatement pstmt;

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 连接数据库
            conn = DriverManager.getConnection(url,root,pwd);
            // 从控制台获取数据
            Scanner in = new Scanner(System.in);
            // 获取用户名
            System.out.print("请输入用户名:");
            String uid = in.nextLine();
            // 获取密码
            System.out.print("请输入密码:");
            String upassword = in.nextLine();
            //组合成sql语句
            // 静态的sql
            String sql = "select * from supermarketuser where uid="+"'"+uid+"'"+ " and UPassword="+"'"+upassword+"'";


            // 预处理的sql语句 ?是占位符 并获取preparedStatement对象
            String sql1 = "select * from supermarketuser where uid = ? and upassword = ?";
            pstmt = conn.prepareStatement(sql1);
            // 给占位符的位置放上值
            pstmt.setString(1,uid);
            pstmt.setString(2,upassword);


//            System.out.println(sql);
            // 获取Statement对象
//            stmt = conn.createStatement();
            //　执行查询
//            ResultSet set = stmt.executeQuery(sql);
            ResultSet set1 = pstmt.executeQuery();
//            Boolean result = stmt.execute(sql);
            if (set1.next()){
//            if(set == null){ //此方法不行，set永不可能为空
//                if(set.getRow()==0){
                System.out.println("该用户存在，正在执行登录操作");
            }else{
                System.out.println("该用户不存在或密码输入错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
//                stmt.close();
                pstmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
