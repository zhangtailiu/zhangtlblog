package cn.zhangtl.zhangtlblog;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class EasyExcelTest {

    @Test
    public void importTest() throws IOException {
        File file = new File("E:\\大件预算.xlsx");
        List<Object> list = EasyExcel.read(file).autoCloseStream(true).excelType(ExcelTypeEnum.XLSX).sheet(0).doReadSync();
        StringBuffer sb = new StringBuffer();
        for (Object o : list) {
            sb.append("UPDATE EHREOS.T_EXPRESS_STAFFING STA SET ");
            Map<Integer,String> dj = (Map) o;
            sb.append("STA.RMS_DJNUM = ").append(dj.get(1)).append(" WHERE STA.DEPTNAME4 = \"").append(dj.get(3)).append("\";");
        }
        File file1 = new File("E:\\大件预算sql.sql");
        FileOutputStream out = new FileOutputStream(file1);
        out.write(sb.toString().getBytes());
        out.flush();
        out.close();
    }
}
