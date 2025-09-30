package com.crowie;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.SwingWorker;

public class ImageCompressionRestaurant extends SwingWorker<Object, Object> {

    //private static final float maxHeight = 1280.0f;
    //private static final float maxWidth = 1280.0f;
    public String compressImage(String imagePath, float compressQality, String compressType, boolean activarRatio, boolean forzarDimensiones, int maxWidth, int maxHeight) {
        BufferedImage scaledImage = null;

        try {
            BufferedImage image = ImageIO.read(new File(imagePath));

            int actualHeight = image.getHeight();
            int actualWidth = image.getWidth();

            if (activarRatio) {
                // Si se desea forzar las dimensiones, simplemente las asignamos.
                if (forzarDimensiones) {
                    actualWidth = maxWidth;
                    actualHeight = maxHeight;
                } else {
                    // Si no, usamos la lógica de escalado proporcional para la imagen.
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
            // porque no soporta el ARGB
            if (compressType.equalsIgnoreCase("jpg") || compressType.equalsIgnoreCase("jpeg")) {
                imageType = BufferedImage.TYPE_INT_RGB;
            }
            scaledImage = new BufferedImage(actualWidth, actualHeight, imageType);
            Graphics2D g = scaledImage.createGraphics();
            g.drawImage(image, 0, 0, actualWidth, actualHeight, null);
            g.dispose();

            File out = File.createTempFile("compressed_", "." + compressType);
            out.deleteOnExit();
            String filepath = out.getAbsolutePath();

            //GUARDANDO IMAGEN
            javax.imageio.ImageWriter writer = ImageIO.getImageWritersByFormatName(compressType).next();
            javax.imageio.stream.ImageOutputStream ios = ImageIO.createImageOutputStream(out);
            writer.setOutput(ios);
            javax.imageio.ImageWriteParam param = writer.getDefaultWriteParam();
            if (param.canWriteCompressed()) {
                param.setCompressionMode(javax.imageio.ImageWriteParam.MODE_EXPLICIT);
                param.setCompressionQuality(compressQality);
            }
            writer.write(null, new javax.imageio.IIOImage(scaledImage, null, null), param);
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
