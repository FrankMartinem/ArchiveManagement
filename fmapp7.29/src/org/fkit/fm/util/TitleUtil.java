package org.fkit.fm.util;

import java.util.ArrayList;
import java.util.HashMap;

import com.baidu.aip.oas.oas;

public class TitleUtil {
	
	public static HashMap<String, String> getTitle(oas client, String path){
		
		ArrayList<String> title_list = new ArrayList<String>();
		title_list.add("�ɼ��ܱ�");
		title_list.add("��������");
		
		title_list.add("�뵳������");
		title_list.add("����֯���ű�");
		
		client.image_analysis(path);
		HashMap<String, String> out_temp;		
		out_temp = client.matchKey(title_list);
		System.out.println(out_temp);
		return out_temp;
	}
}
