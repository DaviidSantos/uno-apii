package com.solbs.unoapi.services;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.solbs.unoapi.entities.Amostra;
import com.solbs.unoapi.entities.Ensaio;
import com.solbs.unoapi.entities.SolicitacaoDeAnalise;
import com.solbs.unoapi.entities.Solicitante;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Service
public class RelatorioDeAnaliseService {

    public void export(HttpServletResponse response, Solicitante solicitante, SolicitacaoDeAnalise solicitacaoDeAnalise, Set<Amostra> amostras) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setSize(32);
        HeaderFooter header = new HeaderFooter(new Phrase("Uno"), false);

        Paragraph uno = new Paragraph("UNO", font);

        Paragraph numSA = new Paragraph(solicitacaoDeAnalise.getIdSA());
        Paragraph nomeSolicitante = new Paragraph(solicitante.getNomeSolicitante());


        document.add(uno);
        document.add(numSA);
        document.add(nomeSolicitante);
        for (Amostra amostra : amostras){
            Paragraph nomeAmostra = new Paragraph(amostra.getNomeAmostra());
            document.add(nomeAmostra);
            Set<Ensaio> ensaios = amostra.getEnsaios();
            for (Ensaio ensaio : ensaios){
                Paragraph nomeEnsaio = new Paragraph(ensaio.getNomeEnsaio());
                document.add(nomeEnsaio);
            }
        }
        document.close();
    }
}
