package handler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import auth.service.StoreRequest;
import auth.service.DuplicateStoreNoExcetpion;
import mvc.command.CommandHandler;
import auth.service.StoreService;
import member.model.JsonVO;

public class ApiHandler implements CommandHandler {
	private static final String FORM_VIEW = "WEB-INF/view/api/apiSync.jsp";

	private StoreService storeService = new StoreService();
//
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
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

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		JSONObject jsonObj = null;
		JSONObject jsonObj2 = null;
		String list_total_count = "";

		try {
			BufferedReader br = null;
			String chkTotalCountResult = "";

			String urlstr = "http://openapi.seoul.go.kr:8088/56504d68436c6565353067596b7578/json/LOCALDATA_072405/1/1/";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			String line;
			while ((line = br.readLine()) != null) {
				chkTotalCountResult = chkTotalCountResult + line;
			}

			JSONParser parser = new JSONParser();
			jsonObj = (JSONObject) parser.parse(chkTotalCountResult);
			jsonObj2 = (JSONObject) jsonObj.get("LOCALDATA_072405");
			list_total_count = jsonObj2.get("list_total_count").toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		int endNo = Integer.parseInt(list_total_count) / 500;
		int lastNo = Integer.parseInt(list_total_count) % 500;
		int pageNo = 500;

		for (int j = 0; j < endNo; j++) {

			String urlstr = "http://openapi.seoul.go.kr:8088/56504d68436c6565353067596b7578/json/LOCALDATA_072405/";
			if (j == endNo - 1) {
				urlstr = urlstr + ((j * pageNo) + 1) + "/" + ((j * pageNo) + lastNo) + "/";
			} else {
				urlstr = urlstr + ((j * pageNo) + 1) + "/" + ((j * pageNo) + pageNo) + "/";
			}

			String result = "";
			BufferedReader br = null;

			try {
				URL url = new URL(urlstr);
				HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
				br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));

				String line;

				while ((line = br.readLine()) != null) {
					result = result + line;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				JSONParser parser = new JSONParser();
				jsonObj = (JSONObject) parser.parse(result);
				jsonObj2 = (JSONObject) jsonObj.get("LOCALDATA_072405");

				JSONArray jsonArray = (JSONArray) ((JSONObject) jsonObj2).get("row");

				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject jsonObj3 = new JSONObject();
					jsonObj3 = (JSONObject) jsonArray.get(i);

					StoreRequest storeReq = new StoreRequest();

					if (jsonObj3.get("BPLCNM").toString() != null
							&& !jsonObj3.get("BPLCNM").toString().trim().equals("")) {
						if (jsonObj3.get("RDNWHLADDR").toString() != null
								&& !jsonObj3.get("RDNWHLADDR").toString().trim().equals("")) {
							if (jsonObj3.get("DTLSTATEGBN").toString().equals("01")) { // 01:�쁺�뾽, 02:�룓�뾽
								if (jsonObj3.get("UPTAENM").toString().equals("떡카페")
										|| jsonObj3.get("UPTAENM").toString().equals("과자점")
										|| jsonObj3.get("UPTAENM").toString().equals("아이스크림")
										|| jsonObj3.get("UPTAENM").toString().equals("전통찻집")
										|| jsonObj3.get("UPTAENM").toString().equals("커피숍")) {

									storeReq.setStoreName(jsonObj3.get("BPLCNM").toString());
									storeReq.setAddress(jsonObj3.get("RDNWHLADDR").toString());
									storeReq.setManageNo(jsonObj3.get("MGTNO").toString());

									if (jsonObj3.get("SITETEL").toString() == null
											|| "".equals(jsonObj3.get("SITETEL").toString())) {
										storeReq.setCallNumber(null);
									} else {
										String callNum = jsonObj3.get("SITETEL").toString().replaceAll(" ", "");
										storeReq.setCallNumber(callNum);
									}

									storeService.store(storeReq);
								}
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			return "WEB-INF/view/api/apiSuccess.jsp";
		} catch (DuplicateStoreNoExcetpion e) {
			e.printStackTrace();
			errors.put("duplicateStoreNo", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

}
