package com.java.controller.order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.java.controller.Controller;
import com.java.dto.order.OrderVO;
import com.java.dto.storage.detail.StorageDtlVO;
import com.java.service.order.OrderService;
import com.java.service.order.OrderServiceImpl;
import com.java.service.storage.StorageService;
import com.java.service.storage.StorageServiceImpl;
import com.java.views.View;
import com.java.views.order.OrderRegistView;

public class OrderRegistController extends Controller {
	private View view = new OrderRegistView();
	private OrderService ODservice = new OrderServiceImpl();
	private StorageService dtlservice = new StorageServiceImpl();

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {

		boolean flag = true;

		while (flag) {
			OrderVO orderr = new OrderVO();
			StorageDtlVO storagedtl = new StorageDtlVO();
			Map<String, Object> dataMap = new HashMap<String, Object>();
			Map<String, Object> paramData = view.view(null);

			if (!flag)
				continue;
			String odate = (String) paramData.get("Odate");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy.mm.dd");

			try {
				java.util.Date Odate = simpleDateFormat.parse(odate);
				java.sql.Date Oodate = new java.sql.Date(Odate.getTime());
				orderr.setOdate(Oodate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			orderr.setFcode((String) paramData.get("Fcode"));
			orderr.setOcode((String) paramData.get("Ocode"));
			orderr.setOqty((int) paramData.get("Oqty"));
			orderr.setSnum((String) paramData.get("Snum"));
			////////////////////////////////////////////////////

			try {
				ODservice.regist(orderr);
				flag = (Boolean) paramData.get("flag");
			} catch (Exception e) {
				e.printStackTrace();
			}

			
			// dataMap.get("flag");

			storagedtl.setF_code((String) paramData.get("Fcode"));
			storagedtl.setSd_qty((int) paramData.get("Oqty"));
			storagedtl.setS_num((String) paramData.get("Snum"));
			storagedtl.setSd_section((String) paramData.get("section"));
			storagedtl.setSd_standard((int) paramData.get("sdstandard"));
			storagedtl.setSd_num((String) paramData.get("sd_num"));

			try {
				dtlservice.addStorageDtl(storagedtl);
				flag = (Boolean) paramData.get("flag");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return null;
	}

}