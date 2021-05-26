package com.example.web.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "UploadController", value = "/upload")
public class UploadController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 判断文件是否多端数据
        if (ServletFileUpload.isMultipartContent(request)) {
            // 创建FileItemFactory工厂实现类
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            // 创建用于解析上传数据的工具类ServletFileUpload
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                // 循环判断每一个表单项，是普通类型还是上传文件
                list.forEach(item -> {
                    if (item.isFormField()) {
                        // 普通表单项
                        System.out.println("name属性值:" + item.getFieldName());
                        try {
                            System.out.println("value属性值:" + item.getString("UTF-8"));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // 上传文件
                        System.out.println("name属性值:" + item.getFieldName());
                        System.out.println("上传的文件名:" + item.getName());
                        try {
                            File file = new File("/Users/jinxing/" + item.getName());
                            System.out.println(file.getAbsolutePath());
                            item.write(file);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                response.setContentType("application/json; charset=utf-8");
                response.getWriter().write("{\"status\": 200, \"msg\": \"success\"}");
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Upload Insert");
        }
    }
}
