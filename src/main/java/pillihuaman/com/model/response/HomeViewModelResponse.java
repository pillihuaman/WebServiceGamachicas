package pillihuaman.com.model.response;

import java.util.List;

import pillihuaman.com.BusinessEntity.Base.HomeViewModel;
import pillihuaman.com.BusinessEntity.Base.Response;

public class HomeViewModelResponse extends Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public HomeViewModel getHomeViewModel() {
		return homeViewModel;
	}
	public List<HomeViewModel> getListHomeViewModel() {
		return listHomeViewModel;
	}
	public void setHomeViewModel(HomeViewModel homeViewModel) {
		this.homeViewModel = homeViewModel;
	}
	public void setListHomeViewModel(List<HomeViewModel> listHomeViewModel) {
		this.listHomeViewModel = listHomeViewModel;
	}
	private HomeViewModel homeViewModel;
    private List<HomeViewModel> listHomeViewModel;
}
