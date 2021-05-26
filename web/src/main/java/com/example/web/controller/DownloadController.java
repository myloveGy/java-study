package com.example.web.controller;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "DownloadController", value = "/download")
public class DownloadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、需要下载的文件
        String filename = "2021.jpg";
        ServletContext servletContext = getServletContext();

        // 2、读取需要下载的文件内容
        InputStream resourceAsStream = servletContext.getResourceAsStream("/images/" + filename);
        if (resourceAsStream == null) {
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write("{\"code\": 500, \"msg\": \"文件不存在\"}");
            return;
        }

        OutputStream outputStream = response.getOutputStream();

        // 4、需要设置文件类型
        String mimeType = servletContext.getMimeType("/images/" + filename);
        response.setContentType(mimeType);
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("金莎.jpg", StandardCharsets.UTF_8));

        // 3、下载文件内容回传到客户
        IOUtils.copy(resourceAsStream, outputStream);
    }
}
