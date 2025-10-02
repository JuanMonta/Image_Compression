package com.crowie;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.SwingWorker;

public class ImageCompression extends SwingWorker<Object, Object> {

    /**
     *
     * @param imagePath la ruta donde está guardada la imagen.
     * @param compressQality de 0.0f a 1.0f representando un porcentraje de
     * 0%-100%.
     * @param compressType el tipo de imagen al cual será convertido durente la
     * compresion, [jpeg,jpg,png]
     * @param activarRatio si se decide mantener un escalado propocional para la
     * imagen comprimida resultante.
     * @param forzarDimensiones si se decide mantener unas dimensiones exactas
     * para la imagen comprimida resultante.
     * @param maxWidth si se desea mantener unas dimensiones exactas, entonces
     * pasar el ancho máximo.
     * @param maxHeight si se desea mantener unas dimensiones exactas, entonces
     * pasar el alto máximo.
     * @return
     */
    public String compressImage(String imagePath, float compressQality, String compressType, boolean activarRatio, boolean forzarDimensiones, int maxWidth, int maxHeight) {
        BufferedImage scaledImage = null;

        try {
            // Recuperamos la imagen de la ruta donde está guardada.
            BufferedImage image = ImageIO.read(new File(imagePath));
            // Tomamos sus dimensiones, esto para calcular el ratio, o forzar dimensiones.
            int actualHeight = image.getHeight();
            int actualWidth = image.getWidth();
            // Busca una relacion de aspecto adecuada para la imagen a comprimir.
            if (activarRatio) {
                // Si se desea forzar las dimensiones, simplemente las asignamos.
                if (forzarDimensiones) {
                    actualWidth = maxWidth;
                    actualHeight = maxHeight;
                } else {
                    // Si no, usamos escalado proporcional para la imagen.
                    if (actualWidth > maxWidth || actualHeight > maxHeight) {
                        float widthRatio = (float) maxWidth / actualWidth;
                        float heightRatio = (float) maxHeight / actualHeight;
                        float scaleFactor = Math.min(widthRatio, heightRatio);

                        actualWidth = (int) (actualWidth * scaleFactor);
                        actualHeight = (int) (actualHeight * scaleFactor);
                    }
                }
            }
            int imageType = (image.getType() == 0) ? BufferedImage.TYPE_INT_ARGB : image.getType();
            // Colocar en modo RGB cuando son jpg o jpeg para evitar el error de "Bogus input colorspace"
            // porque esos formatos no soportan el ARGB
            if (compressType.equalsIgnoreCase("jpg") || compressType.equalsIgnoreCase("jpeg")) {
                imageType = BufferedImage.TYPE_INT_RGB;
            }
            // Creamos la nueva imagen
            scaledImage = new BufferedImage(actualWidth, actualHeight, imageType);
            Graphics2D g = scaledImage.createGraphics();
            g.drawImage(image, 0, 0, actualWidth, actualHeight, null);
            g.dispose();
            // Designamos que la imagen será destinada en los archivos temporales del sistema.
            File out = File.createTempFile("compressed_", "." + compressType);
            out.deleteOnExit();
            // Recuperamos la ruta donde se guarda la imagen en los archivos temporales.
            String filepath = out.getAbsolutePath();

            // Procedemos con el guardado de la imagen.
            //Asignamos el tipo de imagen [jpeg,jpg,png]
            javax.imageio.ImageWriter writer = ImageIO.getImageWritersByFormatName(compressType).next();
            // Tomamos file de la imagen en pasos anteriores.
            javax.imageio.stream.ImageOutputStream ios = ImageIO.createImageOutputStream(out);
            writer.setOutput(ios);
            // Asignamos parámetros a la imagen
            javax.imageio.ImageWriteParam param = writer.getDefaultWriteParam();
            if (param.canWriteCompressed()) {
                param.setCompressionMode(javax.imageio.ImageWriteParam.MODE_EXPLICIT);
                param.setCompressionQuality(compressQality);
            }
            // Creamos la imagen con los parámetros.
            writer.write(null, new javax.imageio.IIOImage(scaledImage, null, null), param);
            // Cerramos para evitar fugas de memoria.
            ios.close();
            writer.dispose();

            return filepath;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected Object doInBackground() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
