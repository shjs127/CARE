package member.model;


public class MenuInfo {

	private int storeNo;
	private String menu;
	private int price;
	private String menuPic;
	
	public MenuInfo(int storeNo, String menu, int price, String menuPic) {
		
		this.storeNo = storeNo;
		this.menu = menu;
		this.price = price;
		this.menuPic = menuPic;
	}
	public MenuInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMenuPic() {
		return menuPic;
	}

	public void setMenuPic(String menuPic) {
		this.menuPic = menuPic;
	}
	
}

