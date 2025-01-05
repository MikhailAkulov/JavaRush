package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    private ImageReaderFactory() {
    }

    public static ImageReader getImageReader(ImageTypes imageType) {
        if (imageType == null) {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        ImageReader imageReader;

        // 2 вариант
        switch (imageType) {
            case BMP:
                imageReader = new BmpReader();
                break;
            case JPG:
                imageReader = new JpgReader();
                break;
            case PNG:
                imageReader = new PngReader();
                break;
            default:
                throw new IllegalArgumentException("Неизвестный тип картинки");
        }

        // 1 вариант
//        if (imageType == ImageTypes.JPG) {
//            imageReader = new JpgReader();
//        } else if (imageType == ImageTypes.PNG) {
//            imageReader = new PngReader();
//        } else if (imageType == ImageTypes.BMP) {
//            imageReader = new BmpReader();
//        } else {
//            throw new IllegalArgumentException("Неизвестный тип картинки");
//        }

        return imageReader;
    }
}
