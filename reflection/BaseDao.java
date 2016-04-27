package reflection;

/**
 * time: 16-4-27.
 * author: han
 */

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

package dao;

import vo.User;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static dao.InitDB.getConn;

/**
 * 我自己实现的ORM框架
 * time: 16-4-27.
 * author: han
 */
public class BaseDao {

    public <T>void save(T t){
//        StringBuffer sql = new StringBuffer();
//        sql.append(" insert into ");
        Class cl = t.getClass();
        /********** SQL 拼接部分 ****************/
        String nn = cl.getName();
        String table_name = nn.substring(nn.lastIndexOf(".")+1).toLowerCase();
        String clumName = "";
        String valueSql = "";
        /***********    END     ***********/
        Field[] fields = cl.getDeclaredFields();
        Connection conn = getConn();
        PreparedStatement pstmt = null;
        try {
            for (Field f : fields) {
                String fname = f.getName();
                clumName = clumName + fname + ",";
                /**  修改访问权限，可以访问private   */
                f.setAccessible(true);
                valueSql = valueSql + "'" +f.get(t)+ "'" +",";
            }
            clumName = clumName.substring(0,clumName.lastIndexOf(","));
            valueSql = valueSql.substring(0,valueSql.lastIndexOf(","));
            String sql = " insert into " +table_name+ "("+clumName+")"+" values("+valueSql+")";
            System.out.println(sql);
            try {
                pstmt = conn.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            pstmt.execute(sql);
            pstmt.close();
            conn.close();
        } catch ( IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        BaseDao bd = new BaseDao();
        User u = new User("zhangsan","1234");
        bd.save(u);
    }
}
