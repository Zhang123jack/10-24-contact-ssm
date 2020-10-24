package com.zxr.web;
import com.zxr.config.SpringConfig;
import com.zxr.domain.Contact;
import com.zxr.service.ContactService;
import com.zxr.service.impl.ContactServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/query_contact_page")
public class QueryContactPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage=1;
        String currentPage1 = request.getParameter("currentPage");
        if(currentPage1!=null){
            currentPage= Integer.parseInt(currentPage1);
        }
        int pageSize=10;
        String pageSize1 = request.getParameter("pageSize");
        if(pageSize1!=null){
            pageSize=Integer.parseInt(pageSize1);
        }
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ContactService contactService = context.getBean("contactService", ContactService.class);
        int pageCount=contactService.getPageCount(pageSize);
        List<Contact> cons=contactService.queryAll(currentPage,pageSize);
        // 1. 如果当前页码为1-5的情况，那么首页就为1
        int begin = 1;
        int end = pageCount;
        /*前两个if为确保当前页 前5后4（当前页在特定范围内时），当当前页不属于此范围时，会导致总页数不足10页*/
        if (currentPage > 5) {
            // 2. 如果当前页码大于5的情况，那么首页应该: 当前页 - 5
            begin = currentPage - 5;
        }
        // 3. 如果当前页码为小于总页码-4的情况，那么末页就为当前页+4(即current+4<pagecount，展示不完全部)
        if (currentPage+4< pageCount) {
            end = currentPage + 4;
        }
        /*后两个if为确保显示页码数为10（除非总页码小于10，这种情况为end为总页码数）*/
        // 4. 如果当前页为5以内，（即当前页小于5，如果想要10页，末页固定为10，如果总页数小于10，那么末页为总页数）(此种情况为前5个不足5个，需要从后面补)
        if (currentPage <= 5) {
            //(注意，此时为不满足上面第一个if的情况，因此begin依然为1)
            end = begin + 9;
            // 5. 如果end超出范围，那么end就该为总页码
            if (end > pageCount) {
                end = pageCount;
            }
        }
        // 6. 如果当前页为最后4页以内，（即当前页为最后4页，总页数若想为10，那么起始页应当为总页数-9，如果小于1，则首页固定为1)（此种情况为后4个不足4个，需要从前面补）
        if (currentPage > pageCount-4) {
            begin = end - 9;
            // 7. 如果计算后的begin比1小的情况，那么再把begin设置为1
            if (begin < 1) {
                begin = 1;
            }
        }
        //8经过4和6的查缺补漏，除非总页数不足
        request.setAttribute("end",end);
        request.setAttribute("begin",begin);
        request.setAttribute("pageCount",pageCount);
        request.setAttribute("contacts",cons);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("pageSize",pageSize);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
