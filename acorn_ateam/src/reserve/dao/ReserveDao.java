package reserve.dao;

import pension.dao.RoomDao;

public class ReserveDao {
	private static ReserveDao dao;
	private ReserveDao() {}
	
	// ������ ����
	public static ReserveDao getInstance() {
		if(dao==null) {
			dao=new ReserveDao();
		}
		return dao;
	}
	
	public void switchCase(int msg) {
		
		switch(msg){
		case 1:
			System.out.println("1��2��");
			break;
		case 2:
			System.out.println("2��3��");
			break;
		case 3:
			System.out.println("3��4��");
			break;
		case 4:
			System.out.println("4��5��");
			break;
		case 5:
			System.out.println("5��6��");
			break;
		case 6:
			System.out.println("6��7��");
			break;
		}
	}
}
