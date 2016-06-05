package net.pankaj.pieChartAction;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.jdbc.JDBCPieDataset;

import net.pankaj.pieChart.DataAccess;

public class PieChart extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private Connection dbConnection = null;

        public PieChart() {
                dbConnection = DataAccess.getConnection();
        }

        public String getPieChart()
                         {
        HttpServletRequest	request = ServletActionContext.getRequest();
   		HttpServletResponse response = ServletActionContext.getResponse();
   		String userId = request.getParameter("pieId");
                JDBCPieDataset dataSet = new JDBCPieDataset(dbConnection);
                System.out.println("inside piechart action");
                System.out.println("manager id is"+ userId);

                try {
                dataSet.executeQuery("select  status_tbl.STATUS,count(*) as count from task_tbl,user_tbl,status_tbl,task_assignment_tbl "
	        		 +"where task_tbl.TASK_ID = task_assignment_tbl.TASK_ID "
	        		 +"and status_tbl.STATUS_ID = task_assignment_tbl.STATUS "
	        		 +"and user_tbl.USER_ID = task_assignment_tbl.ASSIGN_TO "
	        		 +"and user_tbl.MANAGER_ID =" + userId + " group by status_tbl.status ");
                JFreeChart chart = ChartFactory.createPieChart("Project Status", dataSet, true, true, false);
                        
                if (chart != null) {
                        chart.setBorderVisible(true);
                        int width = 600;
                        int height = 400;
                        response.setContentType("image/jpeg");
                        OutputStream out = response.getOutputStream();
                        ChartUtilities.writeChartAsJPEG(out, chart, width, height);
                        
                }
                }
                catch (SQLException e) {
                        System.err.println(e.getMessage());
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
            }
                return "success";
        }
        
}