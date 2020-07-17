package com.example.demo.models;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Array;

public class pdfCreator {

    public static void main(String[] args) throws FileNotFoundException, DocumentException {

        String dateOfIssue = "10.10.2010";
        String voucherID = "AV467281637";
        String passengerName = "John Hultquist";
        String passportCode = "9341234";
        String seatID = "3B";
        String specialService = "Disabled";
        String airportFrom = "Riga";
        String airportTo = "Ainazi";
        String flightID = "Balt251562";
        String date = "20.10.2010";
        String departureTime = "00.00";
        String arrivalTime = "00.20";
        String[] contactNumber = {"+37122814886", "+37161337666"};
        final int DEFAULT_KG = 25;

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("iTextTable.pdf"));
        document.open();

        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16,
                BaseColor.BLACK);
        Chunk chunk = new Chunk("ELECTRONIC TICKET PASSENGER ITINERARY",
                font);
        document.add(chunk);

        Paragraph paragraph = new Paragraph(" ");
        document.add(paragraph);

        String[] cellStringArray;
        cellStringArray = new String[]{"Issued by:", "Accenture",
                "Contact Information", contactNumber[0] + " "
                + contactNumber[1]};
        PdfPTable table = new PdfPTable(Array.getLength(cellStringArray));
        addRows(table, cellStringArray);

        cellStringArray = new String[]{"Date Of Issue", dateOfIssue,
                "Booking:", voucherID};
        addRows(table, cellStringArray);

        document.add(table);
        document.add(paragraph);

        cellStringArray = new String[]{"Name", "Passport", "Seat", "SpecialService"};
        table = new PdfPTable(Array.getLength(cellStringArray));
        addRows(table, cellStringArray);

        cellStringArray = new String[]{passengerName, passportCode, seatID,
                specialService};
        addRows(table, cellStringArray);

        document.add(table);
        document.add(paragraph);

        cellStringArray = new String[]{"Departure/ Arrival Destination", "Flight №",
        "Date", "Departure time", "Arrival Time", "Allowed KG"};
        table = new PdfPTable(Array.getLength(cellStringArray));
        addRows(table, cellStringArray);

        cellStringArray = new String[]{airportFrom + "-" + airportTo, flightID,
        date, departureTime, arrivalTime, DEFAULT_KG + " KG"};
        addRows(table, cellStringArray);

        document.add(table);

        document.close();

    }

    private static void addRows(PdfPTable table, String[] text) {
        for (int i = 0; i < Array.getLength(text); i++) {
            table.addCell(text[i]);
        }
    }

}
