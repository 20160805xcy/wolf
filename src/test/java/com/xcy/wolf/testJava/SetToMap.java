package com.xcy.wolf.testJava;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xcy
 * @date 2019/02/23 11:38
 * @description java 8 实现Set转Map Lamda
 * @since V1.0.0
 */
public class SetToMap {
    public static void main(String[] args) {
        Artist zs1 = new Artist("张三", "深圳");
        Artist zs2 = new Artist("张三", "深圳");
        Artist ls1 = new Artist("李四", "北京");

        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(zs1);
        artists.add(zs2);
        artists.add(ls1);


        List<Artist> list = artists.stream().filter(artist ->
                artist.getLocation().equals("深圳")).collect(Collectors.toList());
        System.out.println(list);

    }
}
