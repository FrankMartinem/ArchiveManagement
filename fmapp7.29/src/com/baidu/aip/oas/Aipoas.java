/*
 * Copyright 2017 Baidu, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.baidu.aip.oas;

//import com.baidu.aip.ocr.*;
//import com.baidu.aip.speech.*;
//import com.baidu.aip.nlp.*;

import com.baidu.aip.client.BaseClient;
import com.baidu.aip.error.AipError;
import com.baidu.aip.http.AipHttpClient;
import com.baidu.aip.http.AipRequest;
import com.baidu.aip.http.AipResponse;
import com.baidu.aip.http.EBodyFormat;
import com.baidu.aip.http.Headers;
import com.baidu.aip.http.HttpCharacterEncoding;
import com.baidu.aip.http.HttpContentType;

import com.baidu.aip.util.AipClientConst;
import com.baidu.aip.util.Base64Util;
import com.baidu.aip.util.SignUtil;
import com.baidu.aip.util.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class Aipoas extends BaseClient {

    public Aipoas(String appId, String apiKey, String secretKey) {
        super(appId, apiKey, secretKey);
    }
//    /**
//     * �ʷ������ӿ�
//     * �ʷ������ӿ����û��ṩ�ִʡ����Ա�ע��ר��ʶ�������ܣ��ܹ�ʶ����ı����еĻ����ʻ㣨�ִʣ�������Щ�ʻ�������顢��ע��Ϻ�ʻ�Ĵ��ԣ�����һ��ʶ�������ʵ�塣
//     *
//     * @param text - �������ı���Ŀǰ��֧��GBK���룩�����Ȳ�����65536�ֽ�
//     * @param options - ��ѡ��������key: value��Ϊstring����
//     * options - options�б�:
//     * @return JSONObject
//     */
//    public JSONObject lexer(String text, HashMap<String, Object> options) {
//        AipRequest request = new AipRequest();
//        preOperation(request);
//        
//        request.addBody("text", text);
//        
//        if (options != null) {
//            request.addBody(options);
//        }
//        request.setUri(NlpConsts.LEXER);
//        request.addHeader(Headers.CONTENT_ENCODING, HttpCharacterEncoding.ENCODE_GBK);
//        request.addHeader(Headers.CONTENT_TYPE, HttpContentType.JSON_DATA);
//        request.setBodyFormat(EBodyFormat.RAW_JSON);
//        postOperation(request);
//        return requestServer(request);
//    }

//    /**
//     * �ʷ����������ư棩�ӿ�
//     * �ʷ������ӿ����û��ṩ�ִʡ����Ա�ע��ר��ʶ�������ܣ��ܹ�ʶ����ı����еĻ����ʻ㣨�ִʣ�������Щ�ʻ�������顢��ע��Ϻ�ʻ�Ĵ��ԣ�����һ��ʶ�������ʵ�塣
//     *
//     * @param text - �������ı���Ŀǰ��֧��GBK���룩�����Ȳ�����65536�ֽ�
//     * @param options - ��ѡ��������key: value��Ϊstring����
//     * options - options�б�:
//     * @return JSONObject
//     */
//    public JSONObject lexerCustom(String text, HashMap<String, Object> options) {
//        AipRequest request = new AipRequest();
//        preOperation(request);
//        
//        request.addBody("text", text);
//        
//        if (options != null) {
//            request.addBody(options);
//        }
//        request.setUri(NlpConsts.LEXER_CUSTOM);
//        request.addHeader(Headers.CONTENT_ENCODING, HttpCharacterEncoding.ENCODE_GBK);
//        request.addHeader(Headers.CONTENT_TYPE, HttpContentType.JSON_DATA);
//        request.setBodyFormat(EBodyFormat.RAW_JSON);
//        postOperation(request);
//        return requestServer(request);
//    }

    /**
     * �����ϳɽӿ�   
     * �û���������������ϳ�
     *
     * @param text - �ַ���
     * @param lang - ����ѡ��
     * @param ctp - �ͻ�������ѡ��web����д�̶�ֵ1
     * @param options - ��ѡ��������key: value��Ϊstring����
     * ����	����	����
     * spd	String	���٣�ȡֵ0-9��Ĭ��Ϊ5������
     * pit	String	������ȡֵ0-9��Ĭ��Ϊ5�����
     * vol	String	������ȡֵ0-15��Ĭ��Ϊ5������
     * per	String	������ѡ��, 0ΪŮ����1Ϊ������3Ϊ��кϳ�-����ң��4Ϊ��кϳ�-��ѾѾ��Ĭ��Ϊ��ͨŮ
     * @return TtsResponse
     */

    public TtsResponse synthesis(String text, String lang, int ctp, HashMap<String, Object> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        if (this.isBceKey.get()) {
            // get access token failed!
            TtsResponse response = new TtsResponse();
            JSONObject msg = Util.getGeneralError(AipClientConst.OPENAPI_NO_ACCESS_ERROR_CODE,
                    AipClientConst.OPENAPI_NO_ACCESS_ERROR_MSG);
            response.setResult(msg);
            return response;
        }
        request.addBody("tex", text);
        request.addBody("lan", lang);
        request.addBody("tok", accessToken);
        request.addBody("ctp", ctp);
        String cuid = SignUtil.md5(accessToken, "UTF-8");
        request.addBody("cuid", cuid);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(SpeechConsts.SPEECH_TTS_URL);

        TtsResponse response = new TtsResponse();
        AipResponse res = AipHttpClient.post(request);
        if (res == null) {
            response.setResult(Util.getGeneralError(-1,
                    "null response from server"));
            return response;
        }
        Map<String, List<String>> header = res.getHeader();
        if (header.containsKey("content-type")) {
            String contentType = res.getHeader().get("content-type").get(0);
            if (contentType.contains("json")) {
                String data = res.getBodyStr();
                JSONObject json = new JSONObject(data);
                response.setResult(json);
            }
            else {
                byte[] binData = res.getBody();
                response.setData(binData);
            }
        }
        else {
            LOGGER.error("synthesis get no content-type in header: " + header);
            LOGGER.info("synthesis response status: " + res.getStatus());
            try {
                JSONObject json = new JSONObject(res.getBodyStr());
                response.setResult(json);
            } catch (JSONException e) {
                response.setData(res.getBody());
            }
        }
        return response;
    }

    /**
     * ͨ������ʶ��ӿ�   
     * �û����������ʶ��ĳ��ͼ�е���������
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   language_type ʶ���������ͣ�Ĭ��ΪCHN_ENG����ѡֵ������<br>- CHN_ENG����Ӣ�Ļ�ϣ�<br>- ENG��Ӣ�ģ�<br>- POR���������<br>- FRE�����<br>- GER�����<br>- ITA��������<br>- SPA���������<br>- RUS�����<br>- JAP�����<br>- KOR�����
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   detect_language �Ƿ������ԣ�Ĭ�ϲ���⡣��ǰ֧�֣����ġ�Ӣ�������
     *   probability �Ƿ񷵻�ʶ������ÿһ�е����Ŷ�
     * @return JSONObject
     */
    public JSONObject basicGeneral(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.GENERAL_BASIC);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ͨ������ʶ��ӿ�
     * �û����������ʶ��ĳ��ͼ�е���������
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   language_type ʶ���������ͣ�Ĭ��ΪCHN_ENG����ѡֵ������<br>- CHN_ENG����Ӣ�Ļ�ϣ�<br>- ENG��Ӣ�ģ�<br>- POR���������<br>- FRE�����<br>- GER�����<br>- ITA��������<br>- SPA���������<br>- RUS�����<br>- JAP�����<br>- KOR�����
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   detect_language �Ƿ������ԣ�Ĭ�ϲ���⡣��ǰ֧�֣����ġ�Ӣ�������
     *   probability �Ƿ񷵻�ʶ������ÿһ�е����Ŷ�
     * @return JSONObject
     */
    public JSONObject basicGeneral(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return basicGeneral(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ͨ������ʶ��ӿ�   
     * �û����������ʶ��ĳ��ͼ�е���������
     *
     * @param url - ͼƬ����URL��URL���Ȳ�����1024�ֽڣ�URL��Ӧ��ͼƬbase64������С������4M����̱�����15px��������4096px,֧��jpg/png/bmp��ʽ����image�ֶδ���ʱurl�ֶ�ʧЧ
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   language_type ʶ���������ͣ�Ĭ��ΪCHN_ENG����ѡֵ������<br>- CHN_ENG����Ӣ�Ļ�ϣ�<br>- ENG��Ӣ�ģ�<br>- POR���������<br>- FRE�����<br>- GER�����<br>- ITA��������<br>- SPA���������<br>- RUS�����<br>- JAP�����<br>- KOR�����
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   detect_language �Ƿ������ԣ�Ĭ�ϲ���⡣��ǰ֧�֣����ġ�Ӣ�������
     *   probability �Ƿ񷵻�ʶ������ÿһ�е����Ŷ�
     * @return JSONObject
     */
    public JSONObject basicGeneralUrl(String url, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        request.addBody("url", url);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.GENERAL_BASIC);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ͨ������ʶ�𣨸߾��Ȱ棩�ӿ�   
     * �û����������ʶ��ĳ��ͼ�е��������֣������ͨ������ʶ��ò�Ʒ���ȸ��ߣ�����ʶ���ʱ���Գ���
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   probability �Ƿ񷵻�ʶ������ÿһ�е����Ŷ�
     * @return JSONObject
     */
    public JSONObject basicAccurateGeneral(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.ACCURATE_BASIC);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ͨ������ʶ�𣨸߾��Ȱ棩�ӿ�
     * �û����������ʶ��ĳ��ͼ�е��������֣������ͨ������ʶ��ò�Ʒ���ȸ��ߣ�����ʶ���ʱ���Գ���
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   probability �Ƿ񷵻�ʶ������ÿһ�е����Ŷ�
     * @return JSONObject
     */
    public JSONObject basicAccurateGeneral(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return basicAccurateGeneral(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ͨ������ʶ�𣨺�λ����Ϣ�棩�ӿ�   
     * �û����������ʶ��ĳ��ͼ�е��������֣�������������ͼ�е�λ����Ϣ��
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   recognize_granularity �Ƿ�λ���ַ�λ�ã�big������λ���ַ�λ�ã�Ĭ��ֵ��small����λ���ַ�λ��
     *   language_type ʶ���������ͣ�Ĭ��ΪCHN_ENG����ѡֵ������<br>- CHN_ENG����Ӣ�Ļ�ϣ�<br>- ENG��Ӣ�ģ�<br>- POR���������<br>- FRE�����<br>- GER�����<br>- ITA��������<br>- SPA���������<br>- RUS�����<br>- JAP�����<br>- KOR�����
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   detect_language �Ƿ������ԣ�Ĭ�ϲ���⡣��ǰ֧�֣����ġ�Ӣ�������
     *   vertexes_location �Ƿ񷵻�������Ӷ���ζ���λ�ã���֧�ֵ���λ�á�Ĭ��Ϊfalse
     *   probability �Ƿ񷵻�ʶ������ÿһ�е����Ŷ�
     * @return JSONObject
     */
    public JSONObject general(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.GENERAL);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ͨ������ʶ�𣨺�λ����Ϣ�棩�ӿ�
     * �û����������ʶ��ĳ��ͼ�е��������֣�������������ͼ�е�λ����Ϣ��
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   recognize_granularity �Ƿ�λ���ַ�λ�ã�big������λ���ַ�λ�ã�Ĭ��ֵ��small����λ���ַ�λ��
     *   language_type ʶ���������ͣ�Ĭ��ΪCHN_ENG����ѡֵ������<br>- CHN_ENG����Ӣ�Ļ�ϣ�<br>- ENG��Ӣ�ģ�<br>- POR���������<br>- FRE�����<br>- GER�����<br>- ITA��������<br>- SPA���������<br>- RUS�����<br>- JAP�����<br>- KOR�����
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   detect_language �Ƿ������ԣ�Ĭ�ϲ���⡣��ǰ֧�֣����ġ�Ӣ�������
     *   vertexes_location �Ƿ񷵻�������Ӷ���ζ���λ�ã���֧�ֵ���λ�á�Ĭ��Ϊfalse
     *   probability �Ƿ񷵻�ʶ������ÿһ�е����Ŷ�
     * @return JSONObject
     */
    public JSONObject general(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return general(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ͨ������ʶ�𣨺�λ����Ϣ�棩�ӿ�   
     * �û����������ʶ��ĳ��ͼ�е��������֣�������������ͼ�е�λ����Ϣ��
     *
     * @param url - ͼƬ����URL��URL���Ȳ�����1024�ֽڣ�URL��Ӧ��ͼƬbase64������С������4M����̱�����15px��������4096px,֧��jpg/png/bmp��ʽ����image�ֶδ���ʱurl�ֶ�ʧЧ
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   recognize_granularity �Ƿ�λ���ַ�λ�ã�big������λ���ַ�λ�ã�Ĭ��ֵ��small����λ���ַ�λ��
     *   language_type ʶ���������ͣ�Ĭ��ΪCHN_ENG����ѡֵ������<br>- CHN_ENG����Ӣ�Ļ�ϣ�<br>- ENG��Ӣ�ģ�<br>- POR���������<br>- FRE�����<br>- GER�����<br>- ITA��������<br>- SPA���������<br>- RUS�����<br>- JAP�����<br>- KOR�����
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   detect_language �Ƿ������ԣ�Ĭ�ϲ���⡣��ǰ֧�֣����ġ�Ӣ�������
     *   vertexes_location �Ƿ񷵻�������Ӷ���ζ���λ�ã���֧�ֵ���λ�á�Ĭ��Ϊfalse
     *   probability �Ƿ񷵻�ʶ������ÿһ�е����Ŷ�
     * @return JSONObject
     */
    public JSONObject generalUrl(String url, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        request.addBody("url", url);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.GENERAL);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ͨ������ʶ�𣨺�λ�ø߾��Ȱ棩�ӿ�   
     * �û����������ʶ��ĳ��ͼ�е��������֣�������������ͼƬ�е�������Ϣ�������ͨ������ʶ�𣨺�λ����Ϣ�棩�ò�Ʒ���ȸ��ߣ�����ʶ���ʱ���Գ���
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   recognize_granularity �Ƿ�λ���ַ�λ�ã�big������λ���ַ�λ�ã�Ĭ��ֵ��small����λ���ַ�λ��
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   vertexes_location �Ƿ񷵻�������Ӷ���ζ���λ�ã���֧�ֵ���λ�á�Ĭ��Ϊfalse
     *   probability �Ƿ񷵻�ʶ������ÿһ�е����Ŷ�
     * @return JSONObject
     */
    public JSONObject accurateGeneral(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.ACCURATE);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ͨ������ʶ�𣨺�λ�ø߾��Ȱ棩�ӿ�
     * �û����������ʶ��ĳ��ͼ�е��������֣�������������ͼƬ�е�������Ϣ�������ͨ������ʶ�𣨺�λ����Ϣ�棩�ò�Ʒ���ȸ��ߣ�����ʶ���ʱ���Գ���
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   recognize_granularity �Ƿ�λ���ַ�λ�ã�big������λ���ַ�λ�ã�Ĭ��ֵ��small����λ���ַ�λ��
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   vertexes_location �Ƿ񷵻�������Ӷ���ζ���λ�ã���֧�ֵ���λ�á�Ĭ��Ϊfalse
     *   probability �Ƿ񷵻�ʶ������ÿһ�е����Ŷ�
     * @return JSONObject
     */
    public JSONObject accurateGeneral(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return accurateGeneral(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ͨ������ʶ�𣨺���Ƨ�ְ棩�ӿ�   
     * ĳЩ�����У�ͼƬ�е����Ĳ����г����֣�����������Ƨ�֣���ʱ�û���Ҫ�Ը�ͼ��������ʶ��Ӧʹ��ͨ������ʶ�𣨺���Ƨ�ְ棩��
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   language_type ʶ���������ͣ�Ĭ��ΪCHN_ENG����ѡֵ������<br>- CHN_ENG����Ӣ�Ļ�ϣ�<br>- ENG��Ӣ�ģ�<br>- POR���������<br>- FRE�����<br>- GER�����<br>- ITA��������<br>- SPA���������<br>- RUS�����<br>- JAP�����<br>- KOR�����
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   detect_language �Ƿ������ԣ�Ĭ�ϲ���⡣��ǰ֧�֣����ġ�Ӣ�������
     *   probability �Ƿ񷵻�ʶ������ÿһ�е����Ŷ�
     * @return JSONObject
     */
    public JSONObject enhancedGeneral(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.GENERAL_ENHANCED);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ͨ������ʶ�𣨺���Ƨ�ְ棩�ӿ�
     * ĳЩ�����У�ͼƬ�е����Ĳ����г����֣�����������Ƨ�֣���ʱ�û���Ҫ�Ը�ͼ��������ʶ��Ӧʹ��ͨ������ʶ�𣨺���Ƨ�ְ棩��
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   language_type ʶ���������ͣ�Ĭ��ΪCHN_ENG����ѡֵ������<br>- CHN_ENG����Ӣ�Ļ�ϣ�<br>- ENG��Ӣ�ģ�<br>- POR���������<br>- FRE�����<br>- GER�����<br>- ITA��������<br>- SPA���������<br>- RUS�����<br>- JAP�����<br>- KOR�����
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   detect_language �Ƿ������ԣ�Ĭ�ϲ���⡣��ǰ֧�֣����ġ�Ӣ�������
     *   probability �Ƿ񷵻�ʶ������ÿһ�е����Ŷ�
     * @return JSONObject
     */
    public JSONObject enhancedGeneral(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return enhancedGeneral(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ͨ������ʶ�𣨺���Ƨ�ְ棩�ӿ�   
     * ĳЩ�����У�ͼƬ�е����Ĳ����г����֣�����������Ƨ�֣���ʱ�û���Ҫ�Ը�ͼ��������ʶ��Ӧʹ��ͨ������ʶ�𣨺���Ƨ�ְ棩��
     *
     * @param url - ͼƬ����URL��URL���Ȳ�����1024�ֽڣ�URL��Ӧ��ͼƬbase64������С������4M����̱�����15px��������4096px,֧��jpg/png/bmp��ʽ����image�ֶδ���ʱurl�ֶ�ʧЧ
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   language_type ʶ���������ͣ�Ĭ��ΪCHN_ENG����ѡֵ������<br>- CHN_ENG����Ӣ�Ļ�ϣ�<br>- ENG��Ӣ�ģ�<br>- POR���������<br>- FRE�����<br>- GER�����<br>- ITA��������<br>- SPA���������<br>- RUS�����<br>- JAP�����<br>- KOR�����
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   detect_language �Ƿ������ԣ�Ĭ�ϲ���⡣��ǰ֧�֣����ġ�Ӣ�������
     *   probability �Ƿ񷵻�ʶ������ÿһ�е����Ŷ�
     * @return JSONObject
     */
    public JSONObject enhancedGeneralUrl(String url, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        request.addBody("url", url);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.GENERAL_ENHANCED);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ����ͼƬ����ʶ��ӿ�   
     * �û����������ʶ��һЩ�����ϱ������ӣ�������������֡�
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   detect_language �Ƿ������ԣ�Ĭ�ϲ���⡣��ǰ֧�֣����ġ�Ӣ�������
     * @return JSONObject
     */
    public JSONObject webImage(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.WEB_IMAGE);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ����ͼƬ����ʶ��ӿ�
     * �û����������ʶ��һЩ�����ϱ������ӣ�������������֡�
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   detect_language �Ƿ������ԣ�Ĭ�ϲ���⡣��ǰ֧�֣����ġ�Ӣ�������
     * @return JSONObject
     */
    public JSONObject webImage(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return webImage(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ����ͼƬ����ʶ��ӿ�   
     * �û����������ʶ��һЩ�����ϱ������ӣ�������������֡�
     *
     * @param url - ͼƬ����URL��URL���Ȳ�����1024�ֽڣ�URL��Ӧ��ͼƬbase64������С������4M����̱�����15px��������4096px,֧��jpg/png/bmp��ʽ����image�ֶδ���ʱurl�ֶ�ʧЧ
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   detect_language �Ƿ������ԣ�Ĭ�ϲ���⡣��ǰ֧�֣����ġ�Ӣ�������
     * @return JSONObject
     */
    public JSONObject webImageUrl(String url, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        request.addBody("url", url);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.WEB_IMAGE);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ���֤ʶ��ӿ�   
     * �û����������ʶ�����֤�����֤ʶ���������ͱ��档
     *
     * @param image - ������ͼ������
     * @param idCardSide - front�����֤����Ƭ��һ�棻back�����֤�����յ�һ��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   detect_risk �Ƿ������֤��������(���֤��ӡ������ʱ���֤�����֤���ġ��޸Ĺ������֤)���ܣ�Ĭ�ϲ�����������false����ѡֵ:true-������false-������
     * @return JSONObject
     */
    public JSONObject idcard(byte[] image, String idCardSide, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        
        request.addBody("id_card_side", idCardSide);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.IDCARD);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ���֤ʶ��ӿ�
     * �û����������ʶ�����֤�����֤ʶ���������ͱ��档
     *
     * @param image - ����ͼƬ·��
     * @param idCardSide - front�����֤����Ƭ��һ�棻back�����֤�����յ�һ��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   detect_risk �Ƿ������֤��������(���֤��ӡ������ʱ���֤�����֤���ġ��޸Ĺ������֤)���ܣ�Ĭ�ϲ�����������false����ѡֵ:true-������false-������
     * @return JSONObject
     */
    public JSONObject idcard(String image, String idCardSide, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return idcard(data, idCardSide, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ���п�ʶ��ӿ�   
     * ʶ�����п������ؿ��źͷ����С�
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject bankcard(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.BANKCARD);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ���п�ʶ��ӿ�
     * ʶ�����п������ؿ��źͷ����С�
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject bankcard(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return bankcard(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ��ʻ֤ʶ��ӿ�   
     * �Ի�������ʻ֤���йؼ��ֶν���ʶ��
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     * @return JSONObject
     */
    public JSONObject drivingLicense(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.DRIVING_LICENSE);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ��ʻ֤ʶ��ӿ�
     * �Ի�������ʻ֤���йؼ��ֶν���ʶ��
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     * @return JSONObject
     */
    public JSONObject drivingLicense(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return drivingLicense(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ��ʻ֤ʶ��ӿ�   
     * �Ի�������ʻ֤�������йؼ��ֶν���ʶ��
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   accuracy normal ʹ�ÿ��ٷ���1200ms����ʱ�ӣ�ȱʡ������ֵʹ�ø߾��ȷ���1600ms����ʱ��
     * @return JSONObject
     */
    public JSONObject vehicleLicense(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.VEHICLE_LICENSE);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ��ʻ֤ʶ��ӿ�
     * �Ի�������ʻ֤�������йؼ��ֶν���ʶ��
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     *   accuracy normal ʹ�ÿ��ٷ���1200ms����ʱ�ӣ�ȱʡ������ֵʹ�ø߾��ȷ���1600ms����ʱ��
     * @return JSONObject
     */
    public JSONObject vehicleLicense(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return vehicleLicense(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ����ʶ��ӿ�   
     * ʶ����������ƣ�������ǩ���غͺ��ơ�
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   multi_detect �Ƿ�����ų��ƣ�Ĭ��Ϊfalse������Ϊtrue��ʱ����Զ�һ��ͼƬ�ڵĶ��ų��ƽ���ʶ��
     * @return JSONObject
     */
    public JSONObject plateLicense(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.LICENSE_PLATE);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ����ʶ��ӿ�
     * ʶ����������ƣ�������ǩ���غͺ��ơ�
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   multi_detect �Ƿ�����ų��ƣ�Ĭ��Ϊfalse������Ϊtrue��ʱ����Զ�һ��ͼƬ�ڵĶ��ų��ƽ���ʶ��
     * @return JSONObject
     */
    public JSONObject plateLicense(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return plateLicense(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * Ӫҵִ��ʶ��ӿ�   
     * ʶ��Ӫҵִ�գ������عؼ��ֶε�ֵ��������λ���ơ����ˡ���ַ����Ч�ڡ�֤����š�������ô���ȡ�
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject businessLicense(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.BUSINESS_LICENSE);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * Ӫҵִ��ʶ��ӿ�
     * ʶ��Ӫҵִ�գ������عؼ��ֶε�ֵ��������λ���ơ����ˡ���ַ����Ч�ڡ�֤����š�������ô���ȡ�
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject businessLicense(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return businessLicense(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ͨ��Ʊ��ʶ��ӿ�   
     * �û����������ʶ��ҽ��Ʊ�ݡ���Ʊ����ʿƱ�����ձ�����Ʊ����ͼƬ�е��������֣�������������ͼ�е�λ����Ϣ��
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   recognize_granularity �Ƿ�λ���ַ�λ�ã�big������λ���ַ�λ�ã�Ĭ��ֵ��small����λ���ַ�λ��
     *   probability �Ƿ񷵻�ʶ������ÿһ�е����Ŷ�
     *   accuracy normal ʹ�ÿ��ٷ���1200ms����ʱ�ӣ�ȱʡ������ֵʹ�ø߾��ȷ���1600ms����ʱ��
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     * @return JSONObject
     */
    public JSONObject receipt(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.RECEIPT);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ͨ��Ʊ��ʶ��ӿ�
     * �û����������ʶ��ҽ��Ʊ�ݡ���Ʊ����ʿƱ�����ձ�����Ʊ����ͼƬ�е��������֣�������������ͼ�е�λ����Ϣ��
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   recognize_granularity �Ƿ�λ���ַ�λ�ã�big������λ���ַ�λ�ã�Ĭ��ֵ��small����λ���ַ�λ��
     *   probability �Ƿ񷵻�ʶ������ÿһ�е����Ŷ�
     *   accuracy normal ʹ�ÿ��ٷ���1200ms����ʱ�ӣ�ȱʡ������ֵʹ�ø߾��ȷ���1600ms����ʱ��
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     * @return JSONObject
     */
    public JSONObject receipt(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return receipt(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * �������ʶ��ͬ���ӿڽӿ�   
     * �Զ�ʶ�����߼�������ݣ��ṹ�������ͷ����β��ÿ����Ԫ����������ݡ�
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject form(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.FORM);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * �������ʶ��ͬ���ӿڽӿ�
     * �Զ�ʶ�����߼�������ݣ��ṹ�������ͷ����β��ÿ����Ԫ����������ݡ�
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject form(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return form(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * �������ʶ��ӿ�   
     * �Զ�ʶ�����߼�������ݣ��ṹ�������ͷ����β��ÿ����Ԫ����������ݡ��������ʶ��ӿ�Ϊ�첽�ӿڣ���Ϊ����API���ύ����ӿڡ���ȡ����ӿڡ�
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject tableRecognitionAsync(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.TABLE_RECOGNIZE);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * �������ʶ��ӿ�
     * �Զ�ʶ�����߼�������ݣ��ṹ�������ͷ����β��ÿ����Ԫ����������ݡ��������ʶ��ӿ�Ϊ�첽�ӿڣ���Ϊ����API���ύ����ӿڡ���ȡ����ӿڡ�
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject tableRecognitionAsync(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return tableRecognitionAsync(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ���ʶ�����ӿ�   
     * ��ȡ�������ʶ����
     *
     * @param requestId - ���ͱ������ʶ������ʱ���ص�request id
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   result_type ������ȡ��������ͣ�ȡֵΪ��excel��ʱ����xls�ļ��ĵ�ַ��ȡֵΪ��json��ʱ����json��ʽ���ַ���,Ĭ��Ϊ��excel��
     * @return JSONObject
     */
    public JSONObject tableResultGet(String requestId, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        request.addBody("request_id", requestId);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.TABLE_RESULT_GET);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ��ֵ˰��Ʊʶ��ӿ�   
     * �˽ӿ���Ҫ����ҳ�����ύ������ѯ��ͨȨ�ޡ� ʶ�𲢽ṹ��������ֵ˰��Ʊ�ĸ����ֶμ����Ӧֵ�������˷�Ʊ������Ϣ9����������Ϣ12�����/���۷������ơ�ʶ��š���ַ�绰�������м��˺ţ���29��ṹ���ֶΡ�
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject vatInvoice(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.VAT_INVOICE);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ��ֵ˰��Ʊʶ��ӿ�
     * �˽ӿ���Ҫ����ҳ�����ύ������ѯ��ͨȨ�ޡ� ʶ�𲢽ṹ��������ֵ˰��Ʊ�ĸ����ֶμ����Ӧֵ�������˷�Ʊ������Ϣ9����������Ϣ12�����/���۷������ơ�ʶ��š���ַ�绰�������м��˺ţ���29��ṹ���ֶΡ�
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject vatInvoice(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return vatInvoice(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ��ά��ʶ��ӿ�   
     * ���˽ӿ���Ҫ����[ҳ��](http://ai.baidu.com/tech/ocr)���ύ������ѯ��ͨȨ��ʶ�������롢��ά���а�����URL��������Ϣ����
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject qrcode(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.QRCODE);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ��ά��ʶ��ӿ�
     * ���˽ӿ���Ҫ����[ҳ��](http://ai.baidu.com/tech/ocr)���ύ������ѯ��ͨȨ��ʶ�������롢��ά���а�����URL��������Ϣ����
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject qrcode(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return qrcode(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ����ʶ��ӿ�   
     * ���˽ӿ���Ҫ����[ҳ��](http://ai.baidu.com/tech/ocr)���ύ������ѯ��ͨȨ�ޡ���ͼ���еİ��������ֽ���ʶ����ȡ�������ڿ�ݵ��š��ֻ��š���ֵ����ȡ�ȳ���
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   recognize_granularity �Ƿ�λ���ַ�λ�ã�big������λ���ַ�λ�ã�Ĭ��ֵ��small����λ���ַ�λ��
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     * @return JSONObject
     */
    public JSONObject numbers(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.NUMBERS);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ����ʶ��ӿ�
     * ���˽ӿ���Ҫ����[ҳ��](http://ai.baidu.com/tech/ocr)���ύ������ѯ��ͨȨ�ޡ���ͼ���еİ��������ֽ���ʶ����ȡ�������ڿ�ݵ��š��ֻ��š���ֵ����ȡ�ȳ���
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   recognize_granularity �Ƿ�λ���ַ�λ�ã�big������λ���ַ�λ�ã�Ĭ��ֵ��small����λ���ַ�λ��
     *   detect_direction �Ƿ���ͼ����Ĭ�ϲ���⣬����false��������ָ����ͼ��������������ʱ����ת90/180/270�ȡ���ѡֵ����:<br>- true����⳯��<br>- false������⳯��
     * @return JSONObject
     */
    public JSONObject numbers(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return numbers(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ��Ʊʶ��ӿ�   
     * ���˽ӿ���Ҫ����[ҳ��](http://ai.baidu.com/tech/ocr)���ύ������ѯ��ͨȨ�ޡ��Դ���͸��˫ɫ���Ʊ����ʶ�𣬲�����ʶ����
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   recognize_granularity �Ƿ�λ���ַ�λ�ã�big������λ���ַ�λ�ã�Ĭ��ֵ��small����λ���ַ�λ��
     * @return JSONObject
     */
    public JSONObject lottery(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.LOTTERY);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ��Ʊʶ��ӿ�
     * ���˽ӿ���Ҫ����[ҳ��](http://ai.baidu.com/tech/ocr)���ύ������ѯ��ͨȨ�ޡ��Դ���͸��˫ɫ���Ʊ����ʶ�𣬲�����ʶ����
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   recognize_granularity �Ƿ�λ���ַ�λ�ã�big������λ���ַ�λ�ã�Ĭ��ֵ��small����λ���ַ�λ��
     * @return JSONObject
     */
    public JSONObject lottery(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return lottery(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ����ʶ��ӿ�   
     * ���˽ӿ���Ҫ����[ҳ��](http://ai.baidu.com/tech/ocr)���ύ������ѯ��ͨȨ�ޡ�֧�ֶ��й���½�����յ�����ҳ���нṹ��ʶ�𣬰��������롢�������Ա𡢻��պš��������ڡ�ǩ�����ڡ���Ч������ǩ���ص㡣
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject passport(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.PASSPORT);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ����ʶ��ӿ�
     * ���˽ӿ���Ҫ����[ҳ��](http://ai.baidu.com/tech/ocr)���ύ������ѯ��ͨȨ�ޡ�֧�ֶ��й���½�����յ�����ҳ���нṹ��ʶ�𣬰��������롢�������Ա𡢻��պš��������ڡ�ǩ�����ڡ���Ч������ǩ���ص㡣
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject passport(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return passport(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ��Ƭʶ��ӿ�   
     * ���˽ӿ���Ҫ����[ҳ��](http://ai.baidu.com/tech/ocr)���ύ������ѯ��ͨȨ�ޡ��ṩ�Ը�����Ƭ�Ľṹ��ʶ���ܣ���ȡ�������ʱࡢ���䡢�绰����ַ����ַ���ֻ����ֶ�
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject businessCard(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.BUSINESS_CARD);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ��Ƭʶ��ӿ�
     * ���˽ӿ���Ҫ����[ҳ��](http://ai.baidu.com/tech/ocr)���ύ������ѯ��ͨȨ�ޡ��ṩ�Ը�����Ƭ�Ľṹ��ʶ���ܣ���ȡ�������ʱࡢ���䡢�绰����ַ����ַ���ֻ����ֶ�
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject businessCard(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return businessCard(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ��д����ʶ��ӿ�   
     * ���˽ӿ���Ҫ����[ҳ��](http://ai.baidu.com/tech/ocr)���ύ������ѯ��ͨȨ�ޡ��ṩ�Ը�����Ƭ�Ľṹ��ʶ���ܣ���ȡ�������ʱࡢ���䡢�绰����ַ����ַ���ֻ����ֶ�
     *
     * @param image - ������ͼ������
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   recognize_granularity �Ƿ�λ���ַ�λ�ã�big������λ���ַ�λ�ã�Ĭ��ֵ��small����λ���ַ�λ��
     * @return JSONObject
     */
    public JSONObject handwriting(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.HANDWRITING);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ��д����ʶ��ӿ�
     * ���˽ӿ���Ҫ����[ҳ��](http://ai.baidu.com/tech/ocr)���ύ������ѯ��ͨȨ�ޡ��ṩ�Ը�����Ƭ�Ľṹ��ʶ���ܣ���ȡ�������ʱࡢ���䡢�绰����ַ����ַ���ֻ����ֶ�
     *
     * @param image - ����ͼƬ·��
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     *   recognize_granularity �Ƿ�λ���ַ�λ�ã�big������λ���ַ�λ�ã�Ĭ��ֵ��small����λ���ַ�λ��
     * @return JSONObject
     */
    public JSONObject handwriting(String image, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return handwriting(data, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * �Զ���ģ������ʶ��ӿ�   
     * �Զ���ģ������ʶ������԰ٶȹٷ�û���Ƴ���Ӧ��ģ�壬���ǵ��û���Ҫ��ĳһ�࿨֤/Ʊ�ݣ��緿��֤������֤����Ʊ�ȣ����нṹ������ȡ����ʱ������ʹ�øò�Ʒ��������ģ�壬����ʶ��
     *
     * @param image - ������ͼ������
     * @param templateSign - �����Զ�������ʶ��ƽ̨������ģ���ID
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject custom(byte[] image, String templateSign, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);
        
        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        
        request.addBody("templateSign", templateSign);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.CUSTOM);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * �Զ���ģ������ʶ��ӿ�
     * �Զ���ģ������ʶ������԰ٶȹٷ�û���Ƴ���Ӧ��ģ�壬���ǵ��û���Ҫ��ĳһ�࿨֤/Ʊ�ݣ��緿��֤������֤����Ʊ�ȣ����нṹ������ȡ����ʱ������ʹ�øò�Ʒ��������ģ�壬����ʶ��
     *
     * @param image - ����ͼƬ·��
     * @param templateSign - �����Զ�������ʶ��ƽ̨������ģ���ID
     * @param options - ��ѡ��������key: value��Ϊstring����
     * options - options�б�:
     * @return JSONObject
     */
    public JSONObject custom(String image, String templateSign, HashMap<String, String> options) {
        try {
            byte[] data = Util.readFileByBytes(image);
            return custom(data, templateSign, options);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ��ȡ���ʶ�������첽��.
     * @param requestId ��tableRecognition�ӿڷ��ص�requestId
     * @return ʶ��״̬�ͽ��
     */
    public JSONObject getTableRecognitionJsonResult(String requestId) {
        return getTableResultHelper(requestId, "json");
    }

    /**
     * ��ȡ���ʶ�������첽��.
     * @param requestId ��tableRecognition�ӿڷ��ص�requestId
     * @return ʶ��״̬��excel���ص�ַ
     */
    public JSONObject getTableRecognitionExcelResult(String requestId) {
        return getTableResultHelper(requestId, "excel");
    }

    // ���ʶ���ȡ����ӿڹ����߼�
    private JSONObject getTableResultHelper(String requestId, String resultType) {
        AipRequest request = new AipRequest();
        preOperation(request);
        request.addBody("request_id", requestId);
        request.addBody("result_type", resultType);
        request.setUri(OcrConsts.TABLE_RESULT_GET);
        postOperation(request);
        return requestServer(request);
    }

    /**
     * ���ʶ��ӿڣ�����json���
     * @param imgPath ʶ��ͼƬ·��
     * @param timeoutMiliseconds �ȴ���ʱ(ms)
     * @return json��ʽʶ����
     */
    public JSONObject tableRecognizeToJson(String imgPath, long timeoutMiliseconds) {
        try {
            byte[] imgData = Util.readFileByBytes(imgPath);
            return tableRecognizeToJson(imgData, timeoutMiliseconds);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ���ʶ��ӿڣ�����json���
     * @param imgData ʶ��ͼƬ����������
     * @param timeoutMiliseconds �ȴ���ʱ(ms)
     * @return json��ʽʶ����
     */
    public JSONObject tableRecognizeToJson(byte[] imgData, long timeoutMiliseconds) {
        return tableRecSyncHelper(imgData, timeoutMiliseconds, "json");
    }

    /**
     * ���ʶ��ӿڣ���������excel��url��ַ
     * @param imgPath ʶ��ͼƬ·��
     * @param timeoutMiliseconds �ȴ���ʱ(ms)
     * @return json result
     */
    public JSONObject tableRecognizeToExcelUrl(String imgPath, long timeoutMiliseconds) {
        try {
            byte[] imgData = Util.readFileByBytes(imgPath);
            return tableRecognizeToExcelUrl(imgData, timeoutMiliseconds);
        } catch (IOException e) {
            e.printStackTrace();
            return AipError.IMAGE_READ_ERROR.toJsonResult();
        }
    }

    /**
     * ���ʶ��ӿڣ���������excel��url��ַ
     * @param imgData ʶ��ͼƬ����������
     * @param timeoutMiliseconds �ȴ���ʱ(ms)
     * @return json result
     */
    public JSONObject tableRecognizeToExcelUrl(byte[] imgData, long timeoutMiliseconds) {
        return tableRecSyncHelper(imgData, timeoutMiliseconds, "excel");
    }

    // ���ʶ��ӿڰ�װͬ���ӿڣ�������ʶ�����󲢵ȴ�������ɡ�
    private JSONObject tableRecSyncHelper(byte[] imgData, long timeout, String resultType) {
        JSONObject res = tableRecognitionAsync(imgData, null);
        if (res.has("error_code")) {
            return res;
        }
        String reqId = res.getJSONArray("result").getJSONObject(0).getString("request_id");
        long start = Calendar.getInstance().getTimeInMillis();
        long sleepInterval = 2000;
        JSONObject result;
        while (true) {
            long now = Calendar.getInstance().getTimeInMillis();
            if (now - start > timeout) {
                // ��ʱ
                return AipError.ASYNC_TIMEOUT_ERROR.toJsonResult();
            }
            result = getTableResultHelper(reqId, resultType);
            if (result.has("error_code")) {
                // ���ش���
                return result;
            }
            int retCode = result.getJSONObject("result").getInt("ret_code");
            if (retCode == OcrConsts.ASYNC_TASK_STATUS_FINISHED) {
                return result;
            }
            else {
                try {
                    Thread.sleep(sleepInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}