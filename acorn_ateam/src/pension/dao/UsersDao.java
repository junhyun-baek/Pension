package pension.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pension.dto.UsersDto;
import pension.util.DbcpBean;

public class UsersDao {

	private static UsersDao dao;
	private UsersDao() {}
	
	// ������ ����
	public static UsersDao getInstance() {
		if(dao==null) {
			dao=new UsersDao();
		}
		return dao;
	}
	
	// ȸ������
	public boolean insert(UsersDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DbcpBean().getConn();

			String sql = "insert into tb_users (users_id,users_pwd,users_email,users_phone) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getUsers_id());
			pstmt.setString(2, dto.getUsers_pwd());
			pstmt.setString(3, dto.getUsers_email());
			pstmt.setString(4, dto.getUsers_phone());
 
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// �α��� �Ҷ� ���� �´��� Ȯ��
	public boolean isValid(UsersDto dto) {
		
		boolean isValid=false;
		
		//�ʿ��� ��ü�� �������� ���� �������� ����� 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection ��ü�� ������ ������ 
			conn = new DbcpBean().getConn();
			//������ sql �� �غ��ϱ�
			String sql = "select users_id"
					+" from tb_users"
					+" where users_id=? and users_pwd=?";
			pstmt = conn.prepareStatement(sql);
			//sql ���� ? �� ���ε��� ���� ������ ���ε��ϰ� 
			pstmt.setString(1, dto.getUsers_id());
			pstmt.setString(2, dto.getUsers_pwd());
			//select �� �����ϰ� ��� �޾ƿ��� 
			rs = pstmt.executeQuery();
			//�ݺ��� ���鼭 ��� �� �����ϱ� 
			if (rs.next()) {
				isValid=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return isValid;
	}
	
	// ȸ�� Ż��
	public boolean delete(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag=0;
		
		try {
			conn = new DbcpBean().getConn();

			String sql = "delete from tb_users where users_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			flag=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {}
		}if(flag>0) {
			return true;
		}else {
			return false;
		}
	}
}
