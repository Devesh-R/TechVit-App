package com.dv19;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Courses implements Parcelable {

    String coursename;
    String imglink;
    String shortdesc;
    String longdesc;

    protected Courses(Parcel in) {
        coursename = in.readString();
        imglink = in.readString();
        shortdesc = in.readString();
        longdesc = in.readString();
    }

    public static final Creator<Courses> CREATOR = new Creator<Courses>() {
        @Override
        public Courses createFromParcel(Parcel in) {
            return new Courses(in);
        }

        @Override
        public Courses[] newArray(int size) {
            return new Courses[size];
        }
    };

    @Override
    public String toString() {
        return "Courses{" +
                "coursename='" + coursename + '\'' +
                ", imglink='" + imglink + '\'' +
                ", shortdesc='" + shortdesc + '\'' +
                ", longdesc='" + longdesc + '\'' +
                '}';
    }

    public Courses(String coursename, String imglink, String shortdesc, String longdesc) {
        this.coursename = coursename;
        this.imglink = imglink;
        this.shortdesc = shortdesc;
        this.longdesc = longdesc;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getImglink() {
        return imglink;
    }

    public void setImglink(String imglink) {
        this.imglink = imglink;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public String getLongdesc() {
        return longdesc;
    }

    public void setLongdesc(String longdesc) {
        this.longdesc = longdesc;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    public Courses() {
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(coursename);
        parcel.writeString(imglink);
        parcel.writeString(shortdesc);
        parcel.writeString(longdesc);
    }
}
