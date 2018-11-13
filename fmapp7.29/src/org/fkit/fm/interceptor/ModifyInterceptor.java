package org.fkit.fm.interceptor;

import org.fkit.fm.domain.Student;
import org.fkit.fm.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
/** 
 * ����������ʵ��HandlerInterceptor�ӿ�
 * */ 
public class ModifyInterceptor  implements HandlerInterceptor {

	// ����"/loginForm"��"/login"����
	private static final String[] NOTIGNORE_URI = {"/editUndergraduate", "/editPartyInfo"};
	
	 /** 
     * �÷������������������֮��ִ�У� ��Ҫ����������������Դ�ģ�
     * �÷���Ҳֻ���ڵ�ǰInterceptor��preHandle�����ķ���ֵΪtrueʱ�Ż�ִ�С� 
     */  
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
//		System.out.println("AuthorizationInterceptor afterCompletion --> ");
		
	}
	/** 
     * �÷�������Controller�ķ�������֮��ִ�У� �����п��Զ�ModelAndView���в��� ��
     * �÷���Ҳֻ���ڵ�ǰInterceptor��preHandle�����ķ���ֵΪtrueʱ�Ż�ִ�С� 
     */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView mv) throws Exception {
//		System.out.println("AuthorizationInterceptor postHandle --> ");
		
	}

	 /** 
     * preHandle�����ǽ��д����������õģ��÷�������Controller����֮ǰ���е��ã�
     * �÷����ķ���ֵΪtrue�������Ż��������ִ�У��÷����ķ���ֵΪfalse��ʱ����������ͽ����ˡ� 
     */  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		System.out.println("ModifyInterceptor preHandle --> ");
		// flag���������ж��û��Ƿ��¼��Ĭ��Ϊfalse 
		boolean flag = true; 
		//��ȡ�����·�������ж�
		String servletPath = request.getServletPath();
		// �ж������Ƿ���Ҫ����
        for (String s : NOTIGNORE_URI) {
            if (servletPath.contains(s)) {
                flag = false;
                break;
            }
        }
        // ��������
        if (!flag){
        	// 1.��ȡsession�е��û� 
        	Student student = (Student) request.getSession().getAttribute("student");
        	User admin = (User) request.getSession().getAttribute("admin");
        	// 2.�ж��û��Ƿ��Ѿ���¼ 
        	if(admin==null){
        		// ����û�û�е�¼����������ʾ��Ϣ����ת����¼ҳ��
        		 System.out.println("ModifyInterceptor��������");
        		 request.setAttribute("message", "��û�и�Ȩ�޽��в�����");
        		 request.getRequestDispatcher("loginSelection").forward(request, response);
        	}else{
        		// ����û��Ѿ���¼������֤ͨ��������
        		 System.out.println("ModifyInterceptor��������");
        		 flag = true;
        	}
        }
        return flag;
		
	}

}