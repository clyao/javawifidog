package com.bandgear.apfree.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

/**
 * 该servlet用作初始化
 * @author hanyu
 *
 */
public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = -3313055007909794922L;

	public void init(ServletConfig config) throws ServletException {
		//初始化log4j
		String prefix = config.getServletContext().getRealPath("/");
        String file = config.getInitParameter("log4j");
        String filePath = prefix + file;
        Properties props = new Properties();
        try {
            FileInputStream istream = new FileInputStream(filePath);
            props.load(istream);
            istream.close();
            PropertyConfigurator.configure(props);//装入log4j配置信息
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
