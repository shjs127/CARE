<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.Statement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>

 

<html>
<head><title>ȸ�� ���</title></head>
<body>
      MEMBER ���̺��� ����
      <table width = "100%" border = "1">
      <tr>
            <td>���� ��ȣ</td>
            <td>�׶� ����</td>
            <td>�������� ����</td>
      </tr>
 
<%
      // 1. JDBC ����̹� �ε�
      Class.forName("oracle.jdbc.driver.OracleDriver");
  
      Connection conn = null; // DBMS�� Java���ᰴü
      Statement stmt = null; // SQL������ ����
      ResultSet rs = null; // SQL������ �������� ����
  
      try
      {
            String jdbcDriver = "jdbc:oracle:thin:@localhost:1521:xe";
            String dbUser = "USER10";
            String dbPass = "USER10";
   
            String query = " select * from DETAILINFO order by STORENO";
            
           /*   select * from STOREINFO order by STORENAME
            SELECT * FROM STOREINFO ORDER BY STORENAME 
            select STORENO, STORENAME, TERRACE from STORENO, '' as TERRACE, STORENAME from STOREINFO union all select STORENO, TERRACE, WIFI as STORENAME from DETAILINFO
            */
   
            // 2. �����ͺ��̽� Ŀ�ؼ� ����
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
   
            // 3. Statement ����
            stmt = conn.createStatement();
   
            // 4. ���� ����
            rs = stmt.executeQuery(query);
   
            // 5. ���� ���� ��� ���
            while(rs.next())
            {
%>
      <tr>
            <td><%= rs.getInt("storeNo") %></td>
            <td><%= rs.getString("TERRACE") %></td>
            <td><%= rs.getString("WIFI") %></td>
      </tr>
<%
            }
      }catch(SQLException ex){
            out.println(ex.getMessage());
            ex.printStackTrace();
      }finally{
            // 6. ����� Statement ����
            if(rs != null) try { rs.close(); } catch(SQLException ex) {}
            if(stmt != null) try { stmt.close(); } catch(SQLException ex) {}
   
            // 7. Ŀ�ؼ� ����
            if(conn != null) try { conn.close(); } catch(SQLException ex) {}
      }
%>
      </table>
</body>
</html>