package auth.service;

import java.util.List;

import member.model.StoreInfo;

public class StoreInfoListView {

	private List<StoreInfo> storeInfoList;

	public StoreInfoListView(List<StoreInfo> storeInfoList) {
		this.storeInfoList = storeInfoList;

	}

	private boolean isEmpty() {
		return false;
	}

	public List<StoreInfo> getStoreInfoList() {
		return storeInfoList;
	}

	public void setStoreInfoList(List<StoreInfo> storeInfoList) {
		this.storeInfoList = storeInfoList;
	}

}
