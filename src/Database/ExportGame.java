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
import com.neet.Game.Manager.Game;

public class ExportGame {
	
	private DataQuery data;
	
	private ArrayList<Game> games;
	
	public void init() {
		games = new ArrayList<Game>();
		data = new DataQuery();
    	String [] cols = {"name", "hp","mn","exp","level","atk/def","crit/arp","hat"
    			,"armor","scepter","shoe","item","mission","time","map","row/col"};
    	ResultSet resultSet = data.view("savegame", cols);
    	try {
    		int index=0;
    	    while(resultSet.next() && index<8){
    	    	Game game = new Game(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
    	    			resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),
    	    			resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),
    	    			resultSet.getString(12),resultSet.getInt(13),resultSet.getInt(14),resultSet.getInt(15),resultSet.getString(16));
    	    	games.add(game);
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
            PdfWriter.getInstance(document, new FileOutputStream("Savegame.pdf"));

            // mở file để thực hiện viết
            document.open();
            Paragraph paragraph1 = new Paragraph("THONG TIN VE MAN CHOI");
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
            PdfPTable table = new PdfPTable(17);
            
        	//Khởi tạo 17 ô header
            PdfPCell header1 = new PdfPCell(new Paragraph("ID"));
            PdfPCell header2 = new PdfPCell(new Paragraph("Name"));
            PdfPCell header3 = new PdfPCell(new Paragraph("Hp"));
            PdfPCell header4 = new PdfPCell(new Paragraph("Mn"));
            PdfPCell header5 = new PdfPCell(new Paragraph("Exp"));
            PdfPCell header6 = new PdfPCell(new Paragraph("Level"));
            PdfPCell header7 = new PdfPCell(new Paragraph("atk/def"));
            PdfPCell header8 = new PdfPCell(new Paragraph("crit/arp"));
            PdfPCell header9 = new PdfPCell(new Paragraph("hat"));
            PdfPCell header10 = new PdfPCell(new Paragraph("armor"));
            PdfPCell header11 = new PdfPCell(new Paragraph("scepter"));
            PdfPCell header12 = new PdfPCell(new Paragraph("shoe"));
            PdfPCell header13 = new PdfPCell(new Paragraph("item"));
            PdfPCell header14 = new PdfPCell(new Paragraph("Misson"));
            PdfPCell header15 = new PdfPCell(new Paragraph("Time"));
            PdfPCell header16 = new PdfPCell(new Paragraph("map"));
            PdfPCell header17 = new PdfPCell(new Paragraph("row/col"));
        	//Thêm 17 ô header vào table
            table.addCell(header1);
            table.addCell(header2);
            table.addCell(header3);
            table.addCell(header4);
            table.addCell(header5);
            table.addCell(header6);
            table.addCell(header7);
            table.addCell(header8);
            table.addCell(header9);
            table.addCell(header10);
            table.addCell(header11);
            table.addCell(header12);
            table.addCell(header13);
            table.addCell(header14);
            table.addCell(header15);
            table.addCell(header16);
            table.addCell(header17);

            for (int i=0;i<games.size();i++) {
            	Game game = games.get(i);
            	PdfPCell data1 = new PdfPCell(new Paragraph((i+1)+""));
            	PdfPCell data2 = new PdfPCell(new Paragraph(game.getName()));
                PdfPCell data3 = new PdfPCell(new Paragraph(game.getHp()));
                PdfPCell data4 = new PdfPCell(new Paragraph(game.getMn()));
                PdfPCell data5 = new PdfPCell(new Paragraph(game.getExp()));
                PdfPCell data6 = new PdfPCell(new Paragraph(game.getLevel()+""));
                PdfPCell data7 = new PdfPCell(new Paragraph(game.getAtkdef()));
                PdfPCell data8 = new PdfPCell(new Paragraph(game.getCritarp()));
                PdfPCell data9 = new PdfPCell(new Paragraph(game.getHat()));
                PdfPCell data10 = new PdfPCell(new Paragraph(game.getArmor()));
                PdfPCell data11 = new PdfPCell(new Paragraph(game.getScepter()));
                PdfPCell data12 = new PdfPCell(new Paragraph(game.getShoe()));
                PdfPCell data13 = new PdfPCell(new Paragraph(game.getItem()));
                PdfPCell data14 = new PdfPCell(new Paragraph(game.getMission()+""));
                PdfPCell data15 = new PdfPCell(new Paragraph(game.getTime()+""));
                PdfPCell data16 = new PdfPCell(new Paragraph(game.getMap()+""));
                PdfPCell data17 = new PdfPCell(new Paragraph(game.getRowcol()));

            	//Thêm data vào bảng.
                table.addCell(data1);
                table.addCell(data2);
                table.addCell(data3);
                table.addCell(data4);
                table.addCell(data5);
                table.addCell(data6);
                table.addCell(data7);
                table.addCell(data8);
                table.addCell(data9);
                table.addCell(data10);
                table.addCell(data11);
                table.addCell(data12);
                table.addCell(data13);
                table.addCell(data14);
                table.addCell(data15);
                table.addCell(data16);
                table.addCell(data17);
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
