package cn.zhangtl.zhangtlblog;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;

@SpringBootTest
public class EasyExcelTest {

    @Test
    public void importTest(){
        File file = new File("E:\\test.xlsx");
        List<Object> list = EasyExcel.read(file).autoCloseStream(true).excelType(ExcelTypeEnum.XLSX).sheet(0).doReadSync();
        System.out.println(list);
    }
}
