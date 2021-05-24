package com.navdeventerprise.nevdev.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {

    private Widget widget;

    @Data
    @NoArgsConstructor
     static class Window{
        private String title;
        private String name;
        private int width;
        private int height;
    }
    @Data
    @NoArgsConstructor
     static class Image{
        private String src;
        private String name;
        private int hoffset;
        private int voffset;
        private String alignment;
    }
    @Data
    @NoArgsConstructor
     static class Text{
        private String data;
        private int size;
        private String style;
        private String name;
        private int hoffset;
        private int voffset;
        private String alignment;
        private String onMouseUp;
    }
    @Data
    @NoArgsConstructor
     static class Widget{
        private String debug;
        private Window window;
        private Image image;
        private Text text;
    }





}
