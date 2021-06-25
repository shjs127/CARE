package auth.service;

import java.util.List;

import member.model.Favorite;

public class FavoriteListView {

	private List<Favorite> favoriteList;

	public FavoriteListView(List<Favorite> favoriteList) {
		this.favoriteList = favoriteList;
	}

	public List<Favorite> getFavoriteList() {
		return favoriteList;
	}
}