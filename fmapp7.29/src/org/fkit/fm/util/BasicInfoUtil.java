package org.fkit.fm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.baidu.aip.oas.oas;



public class BasicInfoUtil {
	public static HashMap<String, String> getBasicInfo(String path, List<String> list){
		
		ArrayList<String> find_list = new ArrayList<String>();
		find_list.add("ѧ(��)��");
		find_list.add("����");
		int len = list.size();
		for(int i=0;i<len;i++){
			find_list.add(list.get(i));
		}
		oas client = new oas();	
		client.image_analysis(path);
		System.out.println(client.Ocrout());
		HashMap<String, String> out_temp;		
		out_temp = client.matchKey(find_list, 1);
		System.out.println(out_temp);
		return out_temp;
	}
	
}
