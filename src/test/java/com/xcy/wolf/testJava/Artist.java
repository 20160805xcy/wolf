package com.xcy.wolf.testJava;

/**
 * @author xcy
 * @date 2019/02/25 15:33
 * @description
 * @since V1.0.0
 */
public class Artist {
    private String name;
    private String location;

    public Artist(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
