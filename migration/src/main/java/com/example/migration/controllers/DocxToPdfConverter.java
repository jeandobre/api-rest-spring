package com.example.migration.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;

public class DocxToPdfConverter {

	public void convertToPDFFromFile(String docPath, String pdfPath) throws IOException {

		InputStream doc = new FileInputStream(new File(docPath));
		XWPFDocument document = new XWPFDocument(doc);
		PdfOptions options = PdfOptions.create();
		OutputStream out = new FileOutputStream(new File(pdfPath));
		PdfConverter.getInstance().convert(document, out, options);

	}
	
	public OutputStream convertToPDFFromInputStream(InputStream doc) throws IOException {
		XWPFDocument document = new XWPFDocument(doc);
		PdfOptions options = PdfOptions.create();
		OutputStream out = new ByteArrayOutputStream();
		PdfConverter.getInstance().convert(document, out, options);
		return out;
	}	
	
}
