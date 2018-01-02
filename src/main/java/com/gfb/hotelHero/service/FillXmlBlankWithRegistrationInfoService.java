package com.gfb.hotelHero.service;

import com.gfb.hotelHero.domain.IdentityDocument;
import com.gfb.hotelHero.domain.Person;
import com.gfb.hotelHero.domain.RightToStayConfirmingDocument;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FillXmlBlankWithRegistrationInfoService {

    private static final String[] LAST_NAME_CELLS = {"W13","W69"};
    private static final String[] FIRST_NAME_CELLS = {"W15","W71"};
    private static final String[] NATIONALITY_NAME_CELLS = {"AA18","AA74"};

    private static HSSFCellStyle style;

    public void writeData(File blankForm, File resultFile, Person personData, boolean openOnSave) throws IOException {
        cloneBlankDoc(blankForm, resultFile);
        HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(resultFile));
        style = initFontStyle(book);
        HSSFSheet sheet = book.getSheet("стр.1");

        writePersonalData(personData, sheet);
        writeIdentityDocumentData(personData, sheet);
        writeRightToStayDocumentData(personData, sheet);
        writePeriodToStay(personData, sheet);
        writeMigrationCard(personData, sheet);

        book.write(new FileOutputStream(resultFile));
        book.close();

        if (openOnSave) {
            Desktop.getDesktop().open(resultFile.getParentFile());
        }
    }

    private static void writePersonalData(Person citizen, HSSFSheet sheet) {
        writeToDoc(sheet, LAST_NAME_CELLS, citizen.getLastName());
        writeToDoc(sheet, FIRST_NAME_CELLS, citizen.getFirstName());
        writeToDoc(sheet, NATIONALITY_NAME_CELLS, citizen.getNationality());

        writeDateToDoc(sheet, citizen.getBirthday(), "AE21", "AU21", "BG21");
        writeDateToDoc(sheet, citizen.getBirthday(), "AE77", "AU77", "BG77");

        boolean isMale = citizen.getGender() == Person.Genders.MALE;
        writeToDoc(sheet, new CellReference(isMale ? "CY21" : "DS21"), "х");
        writeToDoc(sheet, new CellReference(isMale ? "DC77" : "DW77"), "х");

        writeToDoc(sheet, new CellReference("AE24"), citizen.getPlaceOfBirth().getCounty());
        writeToDoc(sheet, new CellReference("AE27"), citizen.getPlaceOfBirth().getCity());
    }

    private static void writeIdentityDocumentData(Person citizen, HSSFSheet sheet) {
        IdentityDocument identityDocument = citizen.getIdentityDocument();

        String idDocumentCellValue = "";
        switch (identityDocument.getType()) {
            case PASSPORT:
                idDocumentCellValue = "паспорт";
                break;
//            case RESIDENCE_PERMIT:
//                roscDocumentCellName = "AY37";
//                break;
//            case TMP_RESIDENCE_PERMIT:
//                roscDocumentCellName = "CM37";
//                break;
        }
        writeToDoc(sheet, new CellReference("BC30"), idDocumentCellValue);
        writeToDoc(sheet, new CellReference("DC30"), identityDocument.getSeries());
        writeToDoc(sheet, new CellReference("DW30"), identityDocument.getIdentifier());

        writeToDoc(sheet, new CellReference("BC80"), idDocumentCellValue);
        writeToDoc(sheet, new CellReference("DC80"), identityDocument.getSeries());
        writeToDoc(sheet, new CellReference("DW80"), identityDocument.getIdentifier());

        writeDateToDoc(sheet, identityDocument.getDateOfIssueDate(), "AA32", "AQ32", "BC32");
        writeDateToDoc(sheet, identityDocument.getValidityTillDate(), "CM32", "DC32", "DO32");
    }

    private static void writeRightToStayDocumentData(Person citizen, HSSFSheet sheet) {
        RightToStayConfirmingDocument stayConfirmingDocument = citizen.getStayConfirmingDocument();
        String roscDocumentCellName = null;
        switch (stayConfirmingDocument.getType()) {
            case NONE:
                return;
            case VISA:
                roscDocumentCellName = "W37";
                break;
            case RESIDENCE_PERMIT:
                roscDocumentCellName = "AY37";
                break;
            case TMP_RESIDENCE_PERMIT:
                roscDocumentCellName = "CM37";
                break;
        }
        writeToDoc(sheet, new CellReference(roscDocumentCellName), "х");

        writeToDoc(sheet, new CellReference("DC37"), stayConfirmingDocument.getSeries());
        writeToDoc(sheet, new CellReference("DW37"), stayConfirmingDocument.getIdentifier());

        writeDateToDoc(sheet, stayConfirmingDocument.getDateOfIssueDate(), "AA40", "AQ40", "BC40");
        writeDateToDoc(sheet, stayConfirmingDocument.getValidityTillDate(), "CM40", "DC40", "DO40");
    }

    private static void writePeriodToStay(Person citizen, HSSFSheet sheet) {
        writeDateToDoc(sheet, citizen.getArrivalDate(), "AI47", "AY47", "BK47");
        writeDateToDoc(sheet, citizen.getDurationOfStay(), "DO47", "EE47", "EQ47");
        writeDateToDoc(sheet, citizen.getDurationOfStay(), "AQ95", "BG95", "BS95");
    }

    private static void writeMigrationCard(Person citizen, HSSFSheet sheet) {
        writeToDoc(sheet, new CellReference("AQ49"), citizen.getMigrationCard().getSeries());
        writeToDoc(sheet, new CellReference("BK49"), citizen.getMigrationCard().getNumber());
    }

    //

    private static void writeDateToDoc(HSSFSheet sheet, Date date, String daysPos, String monthPos, String yearPos) {
        if (null == date)
            return;
        writeToDoc(sheet, new CellReference(daysPos), new SimpleDateFormat("dd").format(date));
        writeToDoc(sheet, new CellReference(monthPos), new SimpleDateFormat("MM").format(date));
        writeToDoc(sheet, new CellReference(yearPos), new SimpleDateFormat("yyyy").format(date));
    }

    private static void writeToDoc(HSSFSheet sheet, String[] cells, String data) {
        for (int i = 0; i < cells.length; i++) {
            writeToDoc(sheet, new CellReference(cells[i]), data);
        }
    }

    private static void writeToDoc(HSSFSheet sheet, CellReference start, String data) {
        Row row = sheet.getRow(start.getRow());
        int offset = 0, step = 4;
        while (offset < data.length()) {
            int cellPos = start.getCol() + offset * step;
            Cell cell = row.getCell(cellPos);
            if (null == cell)
                cell = row.createCell(cellPos);
            cell.setCellStyle(style);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(data.substring(offset, offset + 1));
            offset++;
        }
    }

    private static HSSFCellStyle initFontStyle(HSSFWorkbook book) {
        HSSFFont font = book.createFont();
        font.setFontHeightInPoints((short) 8);
        font.setFontName("Arial Narrow");
        font.setBold(true);
        HSSFCellStyle style = book.createCellStyle();
        style.setFont(font);

//            style.setBorderTop((short) 1);
//            style.setBorderRight((short) 1);
//            style.setBorderBottom((short) 1);
//            style.setBorderLeft((short) 1);

        return style;
    }

    private static void cloneBlankDoc(File blankFile, File resultFile) throws IOException {
        InputStream inStream = new FileInputStream(blankFile);
        OutputStream outStream = new FileOutputStream(resultFile);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = inStream.read(buffer)) > 0) {
            outStream.write(buffer, 0, length);
        }
        inStream.close();
        outStream.close();
    }

}
