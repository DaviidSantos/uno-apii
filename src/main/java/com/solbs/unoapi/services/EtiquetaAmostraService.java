package com.solbs.unoapi.services;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class EtiquetaAmostraService {
    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A8.rotate());

        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        document.addHeader("sei la", "Valer Laboratórios");
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA);
        fontTitle.setSize(8);
        Paragraph paragraph = new Paragraph("Valer Laboratórios", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph);
        document.close();
    }
}
