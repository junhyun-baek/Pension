package reserve.dao;

import pension.dao.RoomDao;

public class ReserveDao {
	private static ReserveDao dao;
	private ReserveDao() {}
	
	// 없으면 만듦
	public static ReserveDao getInstance() {
		if(dao==null) {
			dao=new ReserveDao();
		}
		return dao;
	}
	
	public void switchCase(int msg) {
		
		switch(msg){
		case 1:
			System.out.println("1박2일");
			break;
		case 2:
			System.out.println("2박3일");
			break;
		case 3:
			System.out.println("3박4일");
			break;
		case 4:
			System.out.println("4박5일");
			break;
		case 5:
			System.out.println("5박6일");
			break;
		case 6:
			System.out.println("6박7일");
			break;
		}
	}
}
