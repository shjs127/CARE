package auth.service;

import java.util.Map;
import member.model.*;

public class DetailRequest {
	
	StoreInfo storeinfo=new StoreInfo();
	private int storeNo;
	private int totalSeat;  // "lee"
	private int socketSeat;
	private String dessertSales;
	private String terrace;
	private String roofTop;
	private String wifi;
	private String companionDog; // null
	private String parkingSpace;
	private String nokidsZone;
	private String smokingArea;
	
	
	public int getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	public int getSocketSeat() {
		return socketSeat;
	}
	public void setSocketSeat(int socketSeat) {
		this.socketSeat = socketSeat;
	}
	public String getDessertSales() {
		return dessertSales;
	}
	public void setDessertSales(String dessertSales) {
		this.dessertSales = dessertSales;
	}
	public String getTerrace() {
		return terrace;
	}
	public void setTerrace(String terrace) {
		this.terrace = terrace;
	}
	public String getRoofTop() {
		return roofTop;
	}
	public void setRoofTop(String roofTop) {
		this.roofTop = roofTop;
	}
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	public String getCompanionDog() {
		return companionDog;
	}
	public void setCompanionDog(String companionDog) {
		this.companionDog = companionDog;
	}
	public String getParkingSpace() {
		return parkingSpace;
	}
	public void setParkingSpace(String parkingSpace) {
		this.parkingSpace = parkingSpace;
	}
	public String getNokidsZone() {
		return nokidsZone;
	}
	public void setNokidsZone(String nokidsZone) {
		this.nokidsZone = nokidsZone;
	}
	public String getSmokingArea() {
		return smokingArea;
	}
	public void setSmokingArea(String smokingArea) {
		this.smokingArea = smokingArea;
	}
	public int getStoreNo() {
		// TODO Auto-generated method stub
		return storeNo;
	}

	
}
