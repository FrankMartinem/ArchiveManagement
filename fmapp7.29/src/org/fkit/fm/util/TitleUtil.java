package org.fkit.fm.util;

import java.util.ArrayList;
import java.util.HashMap;

import com.baidu.aip.oas.oas;

public class TitleUtil {
	
	public static HashMap<String, String> getTitle(oas client, String path){
		
		ArrayList<String> title_list = new ArrayList<String>();
		title_list.add("成绩总表");
		title_list.add("党建材料");
		
		title_list.add("入党申请书");
		title_list.add("团组织推优表");
		
		client.image_analysis(path);
		HashMap<String, String> out_temp;		
		out_temp = client.matchKey(title_list);
		System.out.println(out_temp);
		return out_temp;
	}
}
