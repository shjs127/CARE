package handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.DetailRequest;
import auth.service.DetailService;
import auth.service.DuplicateIdException;
import auth.service.StoreRequest;
import auth.service.StoreService;
import member.model.StoreInfo;
import mvc.command.CommandHandler;

public class StorageHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/main/storeStorage.jsp";
	private StoreService storeService = new StoreService();
	private DetailService detailService = new DetailService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		StoreRequest storeReq = new StoreRequest();
		storeReq.setStoreName(req.getParameter("storeName"));
		storeReq.setStorePic(req.getParameter("storePic"));
		storeReq.setAddress(req.getParameter("address"));
		storeReq.setHours(req.getParameter("hours"));
		storeReq.setClosedDays(req.getParameter("closedDays"));
		storeReq.setCallNumber(req.getParameter("callNumber"));
		storeReq.setManageNo(req.getParameter("manageNo"));

		DetailRequest detailReq = new DetailRequest();

		
		  detailReq.setTotalSeat(Integer.parseInt(req.getParameter("totalSeat")));
		  detailReq.setSocketSeat(Integer.parseInt(req.getParameter("socketSeat")));
		  detailReq.setDessertSales(req.getParameter("dessertSales"));
		  detailReq.setTerrace(req.getParameter("terrace"));
		  detailReq.setRoofTop(req.getParameter("roofTop"));
		  detailReq.setWifi(req.getParameter("wifi"));
		  detailReq.setCompanionDog(req.getParameter("companionDog"));
		  detailReq.setParkingSpace(req.getParameter("parkingSpace"));
		  detailReq.setNokidsZone(req.getParameter("noKidsZone"));
		  detailReq.setSmokingArea(req.getParameter("smokingArea"));
		  
		 
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		storeReq.validate(errors); // errors = {"name":true, "confirmPw":true}

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		try {

			storeService.store(storeReq, detailReq);
			return "/WEB-INF/view/main/storageSuccess.jsp";
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

}
