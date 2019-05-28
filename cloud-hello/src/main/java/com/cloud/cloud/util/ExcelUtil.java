package com.cloud.cloud.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class ExcelUtil {
	
	/**
	 * 下载模板
	 * 将模板放到src\main\resources\template文件夹下
	 * @param templateName
	 */
	public static void downExcel(String templateName){
		ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletResponse response = sra.getResponse();
		OutputStream os = null;
		FileInputStream fs = null;
        try{
        	String filePath = ExcelUtil.class.getClassLoader().getResource("/template/"+templateName).getPath();
        	fs = new FileInputStream(new File(filePath));
            response.reset();// 清空输出流
            response.setHeader("Content-disposition", "attachment;filename=template.xlsx");
            response.setContentType("application/msexcel");// 定义输出类型
            os = response.getOutputStream();
            //缓存字节数组
            byte[] b = new byte[2048];
            int length;
            while ((length = fs.read(b)) > 0) {
               os.write(b, 0, length);
            }
        } catch (IOException e) {
        	e.printStackTrace();
        } finally{
            try {
            	if(fs != null) {
            		fs.close();
    	        }
                if(null != os){
                    os.close();
                }
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
	}
	/**
	 * 读取excel
	 * @param InputStream 文件流
	 * @param fileName 文件名
	 * @param columns map 键
	 * @return
	 */
    public static List<Map<String,String>> readExcel(InputStream is,String fileName,String columns[]){
    	//用来存放表中数据
    	List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        Workbook wb = null;
        if(fileName==null){
            return null;
        }
        String extString = fileName.substring(fileName.lastIndexOf("."));
//        InputStream is = null;
        try {
//            is = new FileInputStream(filePath); 
            if(".xls".equals(extString)){
                wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                wb = new XSSFWorkbook(is);
            }
            Sheet sheet = null;
            Row row = null;
            String cellData = null;
            //获取第一个sheet
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);
            //获取最大列数
            int colnum = row.getPhysicalNumberOfCells();
            for (int i = 1; i<rownum; i++) {
                Map<String,String> map = new LinkedHashMap<String,String>();
                row = sheet.getRow(i);
                if(row !=null){
                    for (int j=0;j<colnum;j++){
                        cellData = (String) getCellFormatValue(row.getCell(j));
                        map.put(columns[j], cellData);
                    }
                }else{
                    break;
                }
                list.add(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        	try {
            	if(is != null) {
            		is.close();
    	        }
            } catch (IOException e) {
            	e.printStackTrace();
            }
        }
        return list;
    }
    
    public static Object getCellFormatValue(Cell cell){
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC:{
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            }
            case Cell.CELL_TYPE_FORMULA:{
                //判断cell是否为日期格式
                if(DateUtil.isCellDateFormatted(cell)){
                    //转换为日期格式YYYY-mm-dd
                    cellValue = cell.getDateCellValue();
                }else{
                    //数字
                    cellValue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            case Cell.CELL_TYPE_STRING:{
                cellValue = cell.getRichStringCellValue().getString();
                break;
            }
            default:
                cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
		String file = "C:/Users/admin/Desktop/acceptDetail.xlsx";
		String columns[] = {"a","b","c","d","e","f"};
		InputStream is = new FileInputStream(file); 
		List<Map<String,String>> list = readExcel(is,file,columns);
		System.out.println(list.size());
	}
}
