package com.edisa.formacion.mayo2025EjersDia1;


import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.net.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Ejer02 {

    public static void main(String[] args) {
        if (args.length < 2 || args.length > 3) {
            System.out.println("Uso: java CurrencyConverter <DivisaOrigen> <DivisaDestino> [Cantidad]");
            return;
        }


        String monedaOrigen = args[0].toUpperCase();
        String monedaDestino = args[1].toUpperCase();


        double cantidad = 1.0;
        if (args.length == 3) {
            try {
                cantidad = Double.parseDouble(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Cantidad no válida. Debe ser un número.");
                return;
            }
        }

        try {
            Map<String, Double> tasas = obtenerTasas();
            tasas.put("EUR", 1.0);

            if (!tasas.containsKey(monedaOrigen) || !tasas.containsKey(monedaDestino)) {
                System.out.println("Error: divisa no encontrada.");
                return;
            }

            double tasaOrigen = tasas.get(monedaOrigen);
            double tasaDestino = tasas.get(monedaDestino);
            double resultado = cantidad * (tasaDestino / tasaOrigen);
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println(cantidad + " " + monedaOrigen + " = " + df.format(resultado) + " " + monedaDestino);

        } catch (Exception e) {
            System.out.println("Error al obtener los datos: " + e.getMessage());
        }
    }

    // Método para obtener las tasas de cambio desde el archivo XML del BCE
    private static Map<String, Double> obtenerTasas() throws Exception {
        String url = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
        HttpURLConnection conexion = (HttpURLConnection) new URL(url).openConnection();
        conexion.setRequestMethod("GET");

        InputStream flujo = conexion.getInputStream();
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(flujo);
        doc.getDocumentElement().normalize();

        Map<String, Double> tasas = new HashMap<>();
        NodeList lista = doc.getElementsByTagName("Cube");

        for (int i = 0; i < lista.getLength(); i++) {
            Node nodo = lista.item(i);
            NamedNodeMap atributos = nodo.getAttributes();

            if (atributos != null && atributos.getNamedItem("currency") != null) {
                String moneda = atributos.getNamedItem("currency").getTextContent();
                double valor = Double.parseDouble(atributos.getNamedItem("rate").getTextContent());
                tasas.put(moneda, valor);
            }
        }

        return tasas;
    }
}

