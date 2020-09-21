package com.guigu.utils;

import com.guigu.pojo.Book;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/11
 */
public class WebUtils {
    /**
     * 把map值注入到javabean属性中，适用于更大范围。
     * web
     * service
     * dao
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean(Map value, T bean) {

        try {
            // User user=new User();

            System.out.println("注入之前：" + bean);
            /*
            把所有请求参数都注入到user对象中
             */

            BeanUtils.populate(bean, value);
            System.out.println("注入之后" + bean);
        } catch (Exception e) {

        e.printStackTrace();
        }
        return bean;
    }

}

