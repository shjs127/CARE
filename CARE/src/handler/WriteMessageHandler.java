package handler;

//�̼��� �߰� ����
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import auth.service.LoginFailException;
import auth.service.Message;
import auth.service.WriteMessageService;
import mvc.command.CommandHandler;


public class WriteMessageHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/main/food-details.jsp";


	
	
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			
			System.out.println("WriteMessageHandler GET 실행...");
			return processForm(req, res);
			
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("WriteMessageHandler POST 실행...");
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
		Message message = new Message();
		
		 message.setReviewContents(req.getParameter("reviewContents")); 
		
		
		System.out.println("message.reveiewContents=" + message.getReviewContents());
		
		
		
		try {
			

			WriteMessageService writeService = WriteMessageService.getInstance();
			int writeResult = writeService.writeMessage(message); // 원래 메소드명은 write()였던 것으로 기억합니다.
			// WriteMessageService 클래스에서 msgDAO.insert()의 리턴값을 반환하도록 수정해야 합니다.

			req.getSession().setAttribute("view", writeResult);

			return FORM_VIEW;
		} catch (LoginFailException e) {
			return FORM_VIEW;
			
		}
	}

}


