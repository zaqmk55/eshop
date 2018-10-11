package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSourceUtils {

    private static DataSource dataSource = new ComboPooledDataSource();

    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    // ֱ�ӿ��Ի�ȡһ�����ӳ�
    public static DataSource getDataSource() {
        return dataSource;
    }

    // ��ȡ���Ӷ���
    public static Connection getConnection() {
        try {
            Connection con = tl.get();
            if (con == null) {
                con = dataSource.getConnection();
                tl.set(con);
            }
            return con;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("!!!");
        }
    }

    // ��������
    public static void startTransaction() throws SQLException {
        Connection con = getConnection();
        if (con != null) {
            con.setAutoCommit(false);
        }
    }

    // ����ع�
    public static void rollback() throws SQLException {
        Connection con = getConnection();
        if (con != null) {
            con.rollback();
        }
    }

    // �ύ���� �ر���Դ����ThreadLocall���ͷ�
    public static void commitAndRelease() throws SQLException {
        Connection con = getConnection();
        if (con != null) {
            con.commit(); // �����ύ
            con.close();// �ر���Դ
            tl.remove();// ���̰߳����Ƴ�
        }
    }

    // �ر���Դ����
    public static void closeConnection() throws SQLException {
        Connection con = getConnection();
        if (con != null) {
            con.close();
        }
    }

    public static void closeStatement(Statement st) throws SQLException {
        if (st != null) {
            st.close();
        }
    }

    public static void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }

}
