package com.epam.beanviews;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.epam.model.User;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


@Component("pdfViewAllUsers")
public class ReportPdfViewUsers extends AbstractView {

	private static Font font = new Font(Font.FontFamily.TIMES_ROMAN, 18,
			Font.BOLD);
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=AllUsers.pdf");


		Document document = new Document();
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();

		document.addTitle("All Users");

		
		//document.newPage();

		Paragraph preface = new Paragraph();
		
		addEmptyLine(preface, 3);

		preface.add(new Paragraph("All Users",font));

		List<User> allUsers=(List<User>)model.get("allUsers");
		PdfPTable table=new PdfPTable(4);
		table.addCell("User ID");
		table.addCell("Email");
		table.addCell("Name");
		table.addCell("Date Of Birth");
		for(User user:allUsers) {
			table.addCell(user.getId()+"");
			table.addCell(user.getEmail());
			table.addCell(user.getName());
			table.addCell(user.getBirthDay()+"");

		}
		preface.add(table);
		document.add(preface);

		document.close();
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

}
