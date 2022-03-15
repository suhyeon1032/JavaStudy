package com.campus.myapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	@RequestMapping("/ajaxView")
	public String ajaxView() {
		return "ajax/ajaxView";
	}

	@RequestMapping(value = "/ajaxString", method = RequestMethod.GET, produces = "application/text;charset=UTF-8")
	@ResponseBody
	public String ajaxString(int num, String name, String addr) {
		System.out.println("num->" + num);
		System.out.println("name->" + name);
		System.out.println("addr->" + addr);

		String data = "��ȣ : " + num + "<br/>" + "�̸� : " + name + "<br/>" + "�ּ� : " + addr;
		return data;
	}

	@RequestMapping("/ajaxObject")
	@ResponseBody
	public ProductVO ajaxObject(int num, String name) {
		System.out.println(num + "===>" + name);

		// ProductVO�� �����͸� ��Ƽ� ajax���� ������
		ProductVO vo = new ProductVO(1234, "��ǻ��", 1200000, 13);

		return vo;
	}

	// List
	@RequestMapping("/ajaxList")
	@ResponseBody
	public List<ProductVO> ajaxList() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		list.add(new ProductVO(100, "å��", 120000, 2));
		list.add(new ProductVO(200, "����", 50000, 4));
		list.add(new ProductVO(300, "�����", 200000, 3));
		list.add(new ProductVO(400, "��Ʈ��", 2000000, 1));

		return list;
	}

	// Map
	@RequestMapping("/ajaxMap")
	@ResponseBody
	public HashMap<String, ProductVO> ajaxMap() {

		HashMap<String, ProductVO> map = new HashMap<String, ProductVO>();

		map.put("p1", new ProductVO(100, "å��", 120000, 2));
		map.put("p2", new ProductVO(200, "����", 50000, 4));
		map.put("p3", new ProductVO(300, "�����", 200000, 3));
		map.put("p4", new ProductVO(400, "��Ʈ��", 2000000, 1));
		map.put("p5", new ProductVO(500, "����ũ��", 1500000, 1));

		return map;
	}

	@RequestMapping(value = "/ajaxJson", method = RequestMethod.GET, produces = "application/text;charset=utf-8")
	@ResponseBody
	public String ajaxJson(int no, String name, String tel) {
		System.out.println(no + ">>>" + name + ">>>" + tel);

		int proNo = 1234;
		String proName = "�����";
		int price = 1254200;

		String txt = "{\"proNo\":\"" + proNo + "\", \"proName\":\"" + proName + "\", \"price\":\"" + price + "\"}";
		System.out.println(txt);
		return txt;
	}

	@RequestMapping(value = "/ajaxForm", method = RequestMethod.POST, produces = "application/text;charset=utf-8")
	@ResponseBody
	public String ajaxForm(String proName, int price) {
		System.out.println(proName);
		System.out.println(price);
		return "���ۿϷ�";
	}
}
