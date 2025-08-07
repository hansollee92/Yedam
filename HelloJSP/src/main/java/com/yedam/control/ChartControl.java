package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;

public class ChartControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 데이터베이스에서 값을 가져와야하지만
		// 어떻게 그려지는지 보기위해서 임의로 클래스를 가지고 데이터를 만들어보겠다.
		Map<String, Integer> map = new HashMap<>();
		map.put("user01", 39);
		map.put("user02", 27);
		map.put("user03", 123);
		map.put("user05", 223);
		map.put("user15", 15);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);
		
		resp.getWriter().print(json);

	}

}
