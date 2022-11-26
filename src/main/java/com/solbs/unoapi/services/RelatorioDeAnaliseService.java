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
        Font titulo = FontFactory.getFont(FontFactory.TIMES);
        titulo.setSize(30);

        Font negrito = FontFactory.getFont(FontFactory.TIMES_BOLD);
        Font corpo = FontFactory.getFont(FontFactory.TIMES);

        Paragraph valer_laboratorios = new Paragraph("Valer Laboratórios", titulo);
        valer_laboratorios.setAlignment(Element.ALIGN_CENTER);
        Paragraph quebraDeLinha = new Paragraph("\n");

        Phrase solicitacaoItem = new Phrase("Solicitação de Análise:  ", negrito);
        Phrase solicitanteItem = new Phrase("Solicitante:   ", negrito);
        Phrase tipoDeAnaliseItem = new Phrase("Tipo de Análise: ", negrito);
        Phrase numSolicitacaoDeAnalise = new Phrase(solicitacaoDeAnalise.getIdSA() + "\n", corpo);
        Phrase nomeSolicitante = new Phrase(solicitante.getNomeFantasia() + "\n", corpo);
        Phrase tipoDeAnalise = new Phrase(solicitacaoDeAnalise.getTipoDeAnalise() + "\n");

        document.add(valer_laboratorios);
        document.add(quebraDeLinha);
        document.add(quebraDeLinha);
        document.add(solicitacaoItem);
        document.add(numSolicitacaoDeAnalise);
        document.add(solicitanteItem);
        document.add(nomeSolicitante);
        document.add(tipoDeAnaliseItem);
        document.add(tipoDeAnalise);
        document.add(quebraDeLinha);

        for(Amostra amostra : amostras){
            Font subTitulo = FontFactory.getFont(FontFactory.TIMES_BOLD);
            subTitulo.setSize(14);
            Paragraph numeroAmostra = new Paragraph("Amostra: " + amostra.getNomeAmostra(), subTitulo);
            document.add(numeroAmostra);
            Set<Ensaio> ensaios = amostra.getEnsaios();
            for(Ensaio ensaio : ensaios){
                Paragraph ensaioItem = new Paragraph("         Ensaio: " + ensaio.getNomeEnsaio(), negrito);
                document.add(ensaioItem);
                Paragraph resultado = new Paragraph("                  Especificação: " + ensaio.getEspecificacao() + "                   Resultado: " + ensaio.getResultadoDoEnsaio(), corpo);
                document.add(resultado);
            }
        }
        document.close();

    }
}
