package pension.util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*
 *    [ Data Base Connection Pool Bean ]
 *    
 *    ?��?��?�� ?��?��?���? ?��?��?��?���? 
 *    
 *    1. Servers/context.xml 문서?�� DB ?��?�� ?��보�? ?��?��?��?��?��.
 *    
 *    <Resource name="jdbc/myoracle" auth="Container"
              type="javax.sql.DataSource" driverClassName="oracle.jdbc.OracleDriver"
              url="jdbc:oracle:thin:@127.0.0.1:1521:xe"
              username="scott" password="tiger" maxTotal="20" maxIdle="10"
              maxWaitMillis="-1"/>
              
      2. ?��로젝?��?�� WEB-INF/web.xml 문서?�� ?��?��?�� ?��?��?�� ?��?��?��?��?��.
      
      <resource-ref>
		 <description>Oracle Datasource example</description>
		 <res-ref-name>jdbc/myoracle</res-ref-name>
		 <res-type>javax.sql.DataSource</res-type>
		 <res-auth>Container</res-auth>
	  </resource-ref>
	  
	  3. WEB-INF/lib/ ?��?��?�� ojdbc6.jar ?��?��?�� ?��?��?�� ?��비르?��리�?? ?��?��?�� �?비�?? ?��?��?��?��.
	  
	  ?��?�� 3�?�? ?��?��?�� ?�� ?��?��
	  
	  - new DbcpBean().getConn() 메소?���? ?��출하�? Connection Poll ?��?��
	  Connection 객체�? ?��?�� 리턴?��?��.
	  
	  - Dao ?��?�� Connection 객체�? ?��?��?��?�� .close() 메소?���? ?��출하�? 
	    ?��?��?���? Connection Pool ?�� Connection 객체�? 반환?��?��.
 */

public class DbcpBean {
	// ?��?��
	private Connection conn;
	
	// ?��?��?��
	public DbcpBean() {
		// Connection 객체?�� 참조값을 ?��?��???�� ?��?��?�� ???��?��?�� ?��?��?�� ?��?��.
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		//etc.
		}catch(Exception e) { e.printStackTrace();}
	}
	
	// Connection 객체�? 리턴?��주는 메소?��
	public Connection getConn() {
		return conn;
	}
}
