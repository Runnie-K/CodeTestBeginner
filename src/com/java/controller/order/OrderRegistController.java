package com.java.controller.order;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.java.controller.Controller;
import com.java.dto.order.OrderVO;
import com.java.service.order.OrderService;
import com.java.service.order.OrderServiceImpl;
import com.java.views.View;
import com.java.views.order.OrderRegistView;

public class  OrderRegistController extends Controller {
private View view = new OrderRegistView();
private OrderService ODservice = new OrderServiceImpl();




@Override
public Map<String, Object> execute(Map<String, Object> paramMap) {

boolean flag = true;

while(flag) {
	OrderVO orderr = new OrderVO();
	Map<String,Object> dataMap = new HashMap<String,Object>();
	Map<String,Object>paramData= view.view(null);
	
	 
			
	if(!flag)
		continue;
	String odate = (String)paramData.get("Odate");
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.mm.dd");
	
	try {
		java.util.Date Odate = simpleDateFormat.parse(odate);
		java.sql.Date Oodate = new java.sql.Date(Odate.getDate());
		orderr.setOdate(Oodate);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 orderr.setFcode((String)paramData.get("Fcode"));
	 orderr.setOcode((String)paramData.get("Ocode"));
	 orderr.setOqty((int)paramData.get("Oqty"));
	 orderr.setSnum((String)paramData.get("Snum"));
	 
	 try {
		ODservice.regist(orderr);
		flag =(Boolean)paramData.get("flag");
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	
	
	
	
	
	
	
}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	return null;
}




}
