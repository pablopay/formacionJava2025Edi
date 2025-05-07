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
    public static void main(String[] args) {


        try{

            if (args.length == 0) {
                throw new IllegalArgumentException("Por favor, proporciona un texto para el código QR y su ruta.");

            }



        } catch (Exception e) {
            System.out.println("Ha ocurrido una excepcion:\n"+e.getMessage());
        }


        String data = args[0];

        String path = args[1];


        BitMatrix matrix = null;
        try {
            matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 500, 500);
        } catch (WriterException e) {
            System.out.println("Error al construir la matriz de bits :\n"+e.getMessage());
        }

        if(matrix!=null){
            try {
                MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
            } catch (IOException e) {
                System.out.println("El Qr no se escribio correctamente :\n"+e.getMessage());
            }
        }



        System.out.println("QR code successfully created!");
    }
}
