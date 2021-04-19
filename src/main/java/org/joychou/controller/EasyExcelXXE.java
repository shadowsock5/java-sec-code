package org.joychou.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.joychou.dao.User;
import org.joychou.util.WebUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("/easyExcel")
public class EasyExcelXXE {

    @PostMapping("/deserialize")
    public String parseXml(@RequestParam("file") MultipartFile multipartFile) throws Exception{
        // 2.MultipartFile 转换为 File 类型
        File file = convertMultipartFile(multipartFile);
        parseExcel(file);
        return "easyExcel";
    }



    /**
     * 将 multipartFile 转为 file
     * 选择用缓冲区来实现这个转换 File.createTempFile multipartFile.transferTo
     *
     * @param multipartFile
     * @return
     */
    private File convertMultipartFile(MultipartFile multipartFile) {
        File file = null;
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            String[] filename = originalFilename.split("\\.");
            // 创建临时文件
            String prefix = filename[0].length() >= 3 ? filename[0] : "tmp";
            String suffix = filename[1];
            // prefix : must be at least three characters long
            file = File.createTempFile(prefix, suffix);
            multipartFile.transferTo(file);
            file.deleteOnExit();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return file;

    }

    /**
     * 解析excel数据  File类型
     * ExcelDataListener 在回调函数中处理数据
     *
     * @param file
     */
    private void parseExcel(File file) {
        ExcelReader excelReader = null;
        try {
            // 有个很重要的点 DataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
            excelReader = EasyExcel.read(file, ExcelData.class, new ExcelDataListener()).build();
            ReadSheet readSheet = EasyExcel.readSheet(0).build();
            excelReader.read(readSheet);
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            if (excelReader != null) {
                // 关闭，读的时候会创建临时文件，到时磁盘会崩的
                excelReader.finish();
            }
        }
    }





    public static void main(String[] args) throws Exception {

    }




    public class ExcelDataListener extends AnalysisEventListener<ExcelData> {

        @Override
        public void invoke(ExcelData excelData, AnalysisContext analysisContext) {

        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        }
    }

    public class ExcelData {
        /**
         * 包名
         */
        @ExcelProperty(index = 0)
        private String packageName;
        /**
         * 对应渠道名称
         */
        @ExcelProperty(index = 1)
        private String channelName;
    }
}