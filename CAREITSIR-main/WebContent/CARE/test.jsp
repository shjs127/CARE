<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "java.sql.DriverManager" %>
<%@ page import = "java.sql.Connection" %>
<%@ page import = "java.sql.Statement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>

 

<html>
<head><title>회원 목록</title></head>
<body>
      MEMBER 테이블의 내용
      <table width = "100%" border = "1">
      <tr>
            <td>매장 번호</td>
            <td>테라스 여부</td>
            <td>와이파이 여부</td>
      </tr>
 
<%
      // 1. JDBC 드라이버 로딩
      Class.forName("oracle.jdbc.driver.OracleDriver");
  
      Connection conn = null; // DBMS와 Java연결객체
      Statement stmt = null; // SQL구문을 실행
      ResultSet rs = null; // SQL구문의 실행결과를 저장
  
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
   
            // 2. 데이터베이스 커넥션 생성
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
   
            // 3. Statement 생성
            stmt = conn.createStatement();
   
            // 4. 쿼리 실행
            rs = stmt.executeQuery(query);
   
            // 5. 쿼리 실행 결과 출력
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
            // 6. 사용한 Statement 종료
            if(rs != null) try { rs.close(); } catch(SQLException ex) {}
            if(stmt != null) try { stmt.close(); } catch(SQLException ex) {}
   
            // 7. 커넥션 종료
            if(conn != null) try { conn.close(); } catch(SQLException ex) {}
      }
%>
      </table>
</body>
</html>