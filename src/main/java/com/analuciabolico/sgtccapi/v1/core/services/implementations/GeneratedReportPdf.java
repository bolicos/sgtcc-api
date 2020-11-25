package com.analuciabolico.sgtccapi.v1.core.services.implementations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.analuciabolico.sgtccapi.v1.classes.dtos.StudentClassResponse;
import com.analuciabolico.sgtccapi.v1.core.enums.StudentClassReportColumnEnum;
import com.analuciabolico.sgtccapi.v1.core.services.interfaces.IGeneratedReportPdf;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class GeneratedReportPdf implements IGeneratedReportPdf {

    public ByteArrayInputStream tableClassesStudent(List<StudentClassResponse> list) {
        Document document = new Document();
        ByteArrayOutputStream pdf = new ByteArrayOutputStream();

        try {
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(60);
            table.setWidths(new int[]{3, 5, 5, 2});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            Arrays.stream(StudentClassReportColumnEnum.values()).forEach(studentClassReportColumnEnum -> {
                PdfPCell headerCell = new PdfPCell(new Phrase(studentClassReportColumnEnum.getKey(), headFont));
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(headerCell);
            });

            list.forEach(studentClassResponse -> {
                addColumn(table, studentClassResponse.getSemester());
                addColumn(table, studentClassResponse.getName());
                addColumn(table, studentClassResponse.getStudent());
                addColumn(table, cellNull(studentClassResponse.getAverage()));
            });

            PdfWriter.getInstance(document, pdf);

            document.open();
            document.add(table);
            document.close();
        } catch (DocumentException ex) {

            log.error("Error occurred: {0}", ex);
        }
        return new ByteArrayInputStream(pdf.toByteArray());
    }

    private void addColumn(PdfPTable table, String valueColumn) {
        PdfPCell cell = new PdfPCell(new Phrase(valueColumn));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
    }

    private String cellNull(Double value) {
        return value == null ? " - " : value.toString();
    }

}
