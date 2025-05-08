package com.edisa.formacion.mayo2025EjersDia2;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.IOException;
import java.nio.file.Paths;

public class Parte2 {
    public static void main(String[] args) throws WriterException, IOException {
        if (args.length == 0) {
            System.out.println("Por favor, proporciona un texto para el codigo QR.");
            return;
        }

        String data = args[0];
        String path = args[1];
        String format = args[2];

        BarcodeFormat barcodeFormat;

        try {
            barcodeFormat = BarcodeFormat.valueOf(format);
        } catch (IllegalArgumentException e) {
            System.out.println("Formato no valido. Usa, por ejemplo: QR_CODE, CODE_128, etc.");
            return;
        }

        BitMatrix matrix = new MultiFormatWriter().encode(data, barcodeFormat, 500, 500);
        MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));


        System.out.println(barcodeFormat + " successfully created!");
    }
}