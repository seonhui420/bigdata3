package kr.mem.controller;

import java.util.HashMap;

import kr.mem.pojo.Controller;
import kr.mem.pojo.MemberContentController;
import kr.mem.pojo.MemberDeleteController;
import kr.mem.pojo.MemberInsertController;
import kr.mem.pojo.MemberInsertFormController;
import kr.mem.pojo.MemberListController;
import kr.mem.pojo.MemberUpdateController;

public class HandlerMapping {
//                 < key  , value> 
	private HashMap<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		initMap(); // 임의로 만든 함수
	}
	// ★★아★주★중★요!!!!!!★★
	private void initMap() {
		//    key   -->     value         : 키와 밸류 형태로 볼 수 있음
		// /list.do --> MemberListController
		// /insert.do --> MemberInsertController
		// /insertForm.do --> MemberInsertFormController
		// /delete.do --> MemberDeleteController
		
		//POJO에 있는 위의 형태를 대체할 식  
		try {  //예외처리를 위해 트라이,캐치
			mappings.put("/list.do", new MemberListController());
			mappings.put("/insert.do", new MemberInsertController());
			mappings.put("/insertForm.do", new MemberInsertFormController());
			mappings.put("/delete.do", new MemberDeleteController());
			mappings.put("/content.do", new MemberContentController());
			mappings.put("/update.do", new MemberUpdateController());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Controller getController(String key) {
		return mappings.get(key);
	}

}
