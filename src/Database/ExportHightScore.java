package Database;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.neet.Game.Manager.HightScore;

public class ExportHightScore {
private DataQuery data;
	
	public ArrayList<HightScore> hs;
	
	public void init() {
		hs = new ArrayList<HightScore>();
		data = new DataQuery();
    	String [] cols = {"name", "time"};
    	ResultSet resultSet = data.view("highscore", cols);
    	try {
    		int index=0;
    	    while(resultSet.next() && index<5){
    	    	HightScore temp = new HightScore(resultSet.getInt(2), resultSet.getString(1));
    	    	hs.add(temp);
    	        index++;
    	    }     
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	}
	}
	public void export () {
		init();
		Document document = new Document();

        try {
        	// khởi tạo một PdfWriter truyền vào document và FileOutputStream
            PdfWriter.getInstance(document, new FileOutputStream("Hightscore.pdf"));

            // mở file để thực hiện viết
            document.open();
            Paragraph paragraph1 = new Paragraph("BANG XEP HANG");
            //Định dạng đoạn văn bản thứ nhất
            paragraph1.setIndentationLeft(60);
            paragraph1.setIndentationRight(60);
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph paragraph2 = new Paragraph("GAME HUNTERMONSTER");
            //Định dạng đoạn văn bản thứ nhất
            paragraph2.setIndentationLeft(60);
            paragraph2.setIndentationRight(60);
            paragraph2.setAlignment(Element.ALIGN_CENTER);
            paragraph2.setSpacingAfter(15);
            
            // thêm nội dung sử dụng add function
            PdfPTable table = new PdfPTable(3);
            
        	//Khởi tạo 17 ô header
            PdfPCell header1 = new PdfPCell(new Paragraph("STT"));
            PdfPCell header2 = new PdfPCell(new Paragraph("TEN"));
            PdfPCell header3 = new PdfPCell(new Paragraph("THOI GIAN"));

        	//Thêm 17 ô header vào table
            table.addCell(header1);
            table.addCell(header2);
            table.addCell(header3);

            for (int i=0;i<hs.size();i++) {
            	HightScore score = hs.get(i);
            	PdfPCell data1 = new PdfPCell(new Paragraph((i+1)+""));
            	PdfPCell data2 = new PdfPCell(new Paragraph(score.getName()));
                PdfPCell data3 = new PdfPCell(new Paragraph(score.getTime()+""));

            	//Thêm data vào bảng.
                table.addCell(data1);
                table.addCell(data2);
                table.addCell(data3);
            } 

            Paragraph paragraph3 = new Paragraph("Ngay xuat: "+java.time.LocalDateTime.now());
            paragraph3.setAlignment(Element.ALIGN_RIGHT);
            
            document.add(paragraph1);
            document.add(paragraph2);
            document.add(table);
            document.add(paragraph3);

            System.out.println("true");
            // đóng file
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
}
