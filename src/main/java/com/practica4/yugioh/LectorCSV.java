package com.practica4.yugioh;

import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.lang3.StringUtils;
import java.io.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LectorCSV {

    public static ListaDoble<String[]> cartas;
    boolean primeraLinea = true;

    public LectorCSV() {

        cartas = new ListaDoble<>();

    }

    public static ListaDoble<String[]> getCartas() {
        return cartas;
    }

    public void setCartas(ListaDoble<String[]> cartas) {
        this.cartas = cartas;
    }

    public void obtenerLista() {

        FileReader archCSV = null;
        CSVReader csvReader = null;

        try {
            archCSV = new FileReader("C:\\Users\\omar-\\OneDrive\\Documentos\\NetBeansProjects\\Yugioh\\src\\main\\java\\com\\practica4\\yugioh\\InfoCartas.csv");
            CSVParser coma = new CSVParserBuilder().withSeparator(',').build();
            csvReader = new CSVReaderBuilder(archCSV).withCSVParser(coma).build();

            String[] fila = null;

            while ((fila = csvReader.readNext()) != null) {
                if (primeraLinea) {

                    primeraLinea = false;

                } else {

                    //puede ver un error aqui
                    if (fila.length > 0 && StringUtils.isNumeric(fila[0])) {
                        cartas.insertaFin(fila);
                    } 
                    else {
                        
                        
                        
                    }
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CsvValidationException ex) {
            Logger.getLogger(LectorCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void clear() {

        this.cartas = new ListaDoble<>();

    }

}
