# Compresor de Imágenes

Una aplicación de escritorio de Java Swing simple para comprimir y redimensionar imágenes.

## Descripción

Ajusta la calidad de compresión de una imagem y, opcionalmente, redimensionarla.
El proyecto proporciona una interfaz gráfica de usuario para seleccionar una imagen de su sistema de archivos, mostrándolo en una vista previa en tiempo real de la imagen original y la resultante, junto con detalles como el tamaño del archivo y las dimensiones.

## Características

-   **Compresión de Imagen:** Ajuste la calidad de compresión de 0% a 100% usando un Slider.
-   **Formatos de Salida:** Convierta la imagen a formatos populares como JPG, JPEG o PNG.
-   **Redimensionamiento de Imagen:**
    -   Redimensione imágenes a un ancho y alto específicos.
    -   Opción para mantener la relación de aspecto original al redimensionar.
    -   Opción para forzar las dimensiones exactas.
-   **Vista Previa en Vivo:** Vea la imagen original y la comprimida una al lado de la otra.
-   **Información del Archivo:** Muestra el tamaño del archivo y las dimensiones tanto de la imagen original como de la comprimida.
-   **Selección de Archivo Fácil:** Para falicitar la selección de archivos en este proyecto, se utiliza un selector de archivos nativo para una fácil selección de imágenes.


## Cómo Usar

1.  Inicie la aplicación.
2.  Haga clic en el botón **"ELEGIR IMAGEN"** para seleccionar un archivo de imagen ( `.jpg`, `.jpeg`,`.png`).
3.  Use el deslizador **"PORCENTAJE DE COMPRESIÓN"** para ajustar el nivel de compresión deseado.
4.  Seleccione el formato de salida (`JPG`, `JPEG`, `PNG`) del menú desplegable.
5.  (Opcional) Configure las opciones de redimensionamiento:
    -   Desmarque **"Default"** para habilitar el redimensionamiento.
    -   Ingrese el ancho y alto deseados.
    -   Marque **"Forzar dimensiones"** si desea que la imagen tenga exactamente esas dimensiones (puede distorsionar la imagen). Si no está marcado, la imagen se redimensionará proporcionalmente para ajustarse dentro de las dimensiones dadas.
6.  La imagen comprimida se actualizará automáticamente. La información y la vista previa se mostrarán en el panel "COMPRESSED".

## Ejemplos de Código

La lógica principal de compresión se encuentra en la clase `ImageCompression.java`. Utiliza `javax.imageio` para leer, redimensionar y escribir la imagen con nuevos parámetros de compresión.

```java
// Ejemplo de cómo se invoca la lógica de compresión
String compressedImagePath = new ImageCompression()
        .compressImage(this.originalImagePath, 
                this.compressionValue,
                this.cb_TipoImagen.getSelectedItem().toString().toLowerCase().trim(),
                !this.checkB_Default.isSelected(),
                this.checkB_ForzarDim.isSelected(),
                Integer.parseInt(this.lb_RelAncho.getText().trim()),
                Integer.parseInt(this.lb_RelAlto.getText().trim()));
```

## Capturas de Pantalla
Mostrando mediante la interface la compresión de una imagen.
![Demostración de compresión de imagen](https://github.com/JuanMonta/Image_Compression/blob/main/capturas/AppImageCompression.png?raw=true)

## Dependencias

-   Java Swing (para la GUI).
-   [JnaFileChooser](https://github.com/MatthiasMielke/JnaFileChooser) (para el selector de archivos nativo).
-   [JnaFileChooser .jar tambien aquí](https://github.com/JuanMonta/Image_Compression/tree/main/src/main/java/libs/) (para descargar e instalar). Dentro contiene un archivo .txt con explicaciones de cómo instalar las librerias para maven.
-   Las dependencias son gestionadas a través de Maven. Consulte el archivo `pom.xml` para más detalles.

