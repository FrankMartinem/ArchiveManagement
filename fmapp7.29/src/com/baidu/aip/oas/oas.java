package com.baidu.aip.oas;

import com.baidu.aip.error.AipError;

//ocr and speech

import com.baidu.aip.oas.Aipoas;
import com.baidu.aip.oas.TtsResponse;

import com.baidu.aip.util.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class oas {
	// 设置APPID/AK/SK
	private static final String APP_ID = "14746654";
	private static final String API_KEY = "aHkyqEYTapYgZIspNLWpw2GM";
	private static final String SECRET_KEY = "8VwI0WqGXZZUxB8zmKqW2z4yNmTsDatV";
	private Aipoas client;
	private ArrayList<String> res_ocr_list;// 保存图像识别结果

	public oas() {
		this(APP_ID, API_KEY, SECRET_KEY);
	}

	public oas(String appId, String apiKey, String secretKey) {

		// 初始化一个Aipoas
		client = new Aipoas(appId, apiKey, secretKey);
		// 可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);

		// 可选：设置代理服务器地址, http和socket二选一，或者均不设置
		// client.setHttpProxy("proxy_host", proxy_port); // 设置http代理
		// client.setSocketProxy("proxy_host", proxy_port); // 设置socket代理

		// 可选：设置log4j日志输出格式，若不设置，则使用默认配置
		// 也可以直接通过jvm启动参数设置此环境变量
		// System.setProperty("aip.log4j.conf",
		// "E:\\Project\\Java\\Eclipse_Workspace\\java-sdk-master\\log\\log4j.properties");

	}

	/**
	 * 语音合成接口
	 *
	 * @param text - 输入文本 in_t 将被直接修改
	 * @return byte[] 音频数据
	 **/
	public byte[] SpeechOut(String text) {
		// 调用接口
		TtsResponse res = client.synthesis(text, "zh", 1, null);

		JSONObject res1 = res.getResult();

		if (res1 != null) {
			System.out.println(res1.toString(2));
		}
		return res.getData();
	}

	/**
	 * 图像识别结果输出结果
	 *
	 * @return ArrayList<String>
	 **/
	public ArrayList<String> Ocrout() {
		return res_ocr_list;
	}

	/**
	 * 语义分析接口
	 *
	 * @param in_t - 输入数据 in_t 将被直接修改
	 * @return
	 **/
	private void TextLexer(HashMap<String, String> in_t) {

		for (String Key : in_t.keySet()) {

			StringBuilder deal_str = new StringBuilder(in_t.get(Key));
			String match_str = Key;
			int pos_t = deal_str.indexOf(match_str);
			if (pos_t != -1) {
				deal_str.delete(0, pos_t + match_str.length());
				for (String S : in_t.keySet()) {
					int pos_del = deal_str.indexOf(S);
					if (pos_del != -1) {
						deal_str.delete(pos_del, deal_str.length());
					}
				}
				//System.out.println(deal_str.toString());
				in_t.replace(Key, deal_str.toString().trim());

			} else {
				System.out.println("do not find name");
			}
		}

	}

	/**
	 * 信息匹配接口 使用语义分析，用于信息识别
	 * 
	 * @param find_list - 匹配信息数组
	 * @return HashMap<String, String>
	 **/
	public HashMap<String, String> matchKey(ArrayList<String> find_list) {
		return matchKey(find_list, 0);
	}

	/**
	 * 信息匹配接口
	 *
	 * @param find_list - 匹配信息数组
	 * @param mode      - 是否采用语义分析 0 不使用语义分析，用于标题识别 1 使用语义分析，用于信息识别
	 * @return HashMap<String, String>
	 **/
	public HashMap<String, String> matchKey(ArrayList<String> find_list, int mode) {

		HashMap<String, String> out_temp = new HashMap<String, String>();

		if (mode == 0)// 完成匹配模式，用于抬头识别
		{
			for (String match_str : find_list) {
				for (String S : res_ocr_list) {
					int pos_t = S.indexOf(match_str);
					if (pos_t != -1) {
						// System.out.printf("find str :%s\r\n", S);
						out_temp.put("Title", S);
						break;
					}
				}
			}
		} else if (mode == 1)//// 部分匹配模式，信息识别
		{
			for (String match_str : find_list) {
				for (int i = 0; i < res_ocr_list.size(); i++) {
					String S = res_ocr_list.get(i);
					int pos_t = S.indexOf(match_str);
					if (pos_t != -1) {
						// System.out.printf("find str :%s\r\n", S);
						if (pos_t + match_str.length() >= S.length()) {
							if (i + 1 < res_ocr_list.size()) {
								out_temp.put(match_str, S.concat(res_ocr_list.get(i + 1)));
							}
						} else {
							out_temp.put(match_str, S);
						}
						break;
					}
				}
			}
			TextLexer(out_temp);
		} else {
			System.out.println("matchKey error");
		}
		return out_temp;

	}
	// public HashMap <String,String> image_analysis(ArrayList find_list)

	/**
	 * 文字识别接口
	 *
	 * @param image - 本地图片路径
	 * @return void 结果保存于res_ocr_list
	 **/
	public void image_analysis(String image) {
		try {
			byte[] data = Util.readFileByBytes(image);
			image_analysis(data);
		} catch (IOException e) {
			e.printStackTrace();
			// AipError.IMAGE_READ_ERROR.toJsonResult();
		}
	}

	/**
	 * 文字识别接口
	 *
	 * @param image - 二进制图像数据
	 * @return void 结果保存于res_ocr_list
	 **/
	public void image_analysis(byte[] image) {
		// 调用接口
		// JSONObject res_ocr = client.basicGeneral(image, new HashMap<String,
		// String>());
		JSONObject res_ocr = client.basicAccurateGeneral(image, new HashMap<String, String>());
		// System.out.println(res_ocr.toString(2));
		if (res_ocr.has("words_result_num")) {
			int result_len = res_ocr.getInt("words_result_num");
			// System.out.printf("words_result_num:%d\r\n", result_len);
			if (result_len > 0) {
				JSONArray result = res_ocr.getJSONArray("words_result");
				ArrayList<String> result_list = new ArrayList<String>();
				for (int i = 0; i < result_len; i++) {
					JSONObject out_temp = result.getJSONObject(i);
					String out_string = out_temp.getString("words");
					result_list.add(out_string);
				}
				res_ocr_list = result_list;
			}
		}
	}

}
