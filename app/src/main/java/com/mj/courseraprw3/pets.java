package com.mj.courseraprw3;

import java.util.ArrayList;

/**
 * Created by leyenda1 on 16/09/2016.
 */

public class pets {
    private int id;
    private String  name;
    private Integer likes;
    private int picture;

    public pets() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(Integer picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public pets (int id, String myname, Integer mylikes, Integer myPicture){
        setId(id);
        setName(myname);
        setLikes(mylikes);
        setPicture(myPicture);
    }

    public int indexOf(String needle, ArrayList<pets> haystack)
    {
        for (int i=0; i<haystack.size(); i++)
        {
            if (haystack.get(i) != null && haystack.get(i).getName().equals(needle)
                    || needle == null && haystack.get(i) == null) return i;
        }

        return -1;
    }

}
