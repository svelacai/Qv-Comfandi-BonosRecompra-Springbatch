package com.comfandi.bono.recompra.batch.util;

/**
 * Clase para la generacion de codigos de barras
 * Se utiliza la libreria Barcode
 */
public class GenerateBarcode {
		
    public static void main(String[] args) {

    	///Structura del bono: (91)xxxxxx(3900)xxxxx
    	///(91)0174352504(3900)85200
    	
        try {
   
        	Integer tipoDoc = 1;
            Long numDoc = 1253698951L;
            Long val = 60000L;
            System.out.println("------->>> "+generateBarcode(tipoDoc, numDoc, val));
        } catch (Exception e) {
            System.out.println("Error generando el código de barras: " + e.getMessage());
        }
    }

    public static StringBuilder generateBarcode(Integer typeDocmuent, Long numberDocument, Long bondValue ) throws Exception {
    	        StringBuilder generateCode = new StringBuilder();
    	        generateCode.append("(91)");
    	        generateCode.append(typeDocmuent); 
    	        generateCode.append(numberDocument);
    	        generateCode.append("(3900)");
    	        generateCode.append(bondValue);
    	        
    	        return generateCode; 
    }
}
