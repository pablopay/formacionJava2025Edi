package com.edisa.formacion.mayo2025;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.IOException;
import java.nio.file.Paths;
//"Hola mundo" "C:\\Users\\pablo.locay\\Desktop\\qr.jpg"

public class Parte1 {
    public static void main(String[] args) throws WriterException, IOException {
        if (args.length == 0) {
            System.out.println("Por favor, proporciona un texto para el código QR.");
            return;
        }

        String data = args[0];

        String path = args[1];


        BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 500, 500);

        MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));

        System.out.println("QR code successfully created!");
    }
}
