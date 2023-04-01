package com.dv19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class CourseActivity extends AppCompatActivity {

    RecyclerView recview;
    MaterialButton enrolled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        enrolled= findViewById(R.id.enrolled);
        enrolled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),EnrolledCourses.class);
                startActivity(intent);

            }
        });

        recview = findViewById(R.id.coursesRecview);
        ArrayList<Courses> courses = new ArrayList<>();
        courses.add(new Courses("App Development","https://www.netsolutions.com/insights/wp-content/uploads/2022/01/15-mobile-app-development.webp","Mobile application development is the process of creating software applications that run on a mobile device, and a typical mobile application utilizes a network connection to work with remote computing resources.",
                "EXPOSYS VIRTUAL INTERNSHIP-EVI APP \n" +
                "Let’s assume students want to apply Exposys Data Labs Virtual internship through mobile application. \n" +
                "1. Create Mobile User Interface\n"+"2. Develop Registration form & Login Credential \n" +
                "3. Explore different domains with ICONS \n" +
                "4. You can select the domain from the menu \n" +
                "5. You can apply"));
        courses.add(new Courses("Data Science","https://bigdataanalyticsnews.com/wp-content/uploads/2021/12/big-data-application-in-education.jpg","Data science is a field that uses a wide array of scientific methods to gain insights and extract knowledge from data. Data scientists refine raw data using sophisticated techniques and expertise in various disciplines.\n",
                "In the given dataset, R&D Spend, Administration Cost and Marketing Spend of 50 Companies are given along with the profit earned. The target is to prepare an ML model which can predict the profit value of a company if the value of its R&D Spend, Administration Cost and Marketing Spend are given. \n" +
                        " i) Construct Different Regression algorithms \n" +
                        " ii) Divide the data into train set and test set \n" +
                        " iii) Calculate different regression metrics \n" +
                        " iv) Choose the best model \n" +
                        "Language: Python or R \n" +
                        "DATA SET LINK: \n" +
                        "https://drive.google.com/file/d/1Z7RKmScBO7n9vcDIG3Xeo853Ics4QFaF/view"));

        courses.add(new Courses("Web Development","https://www.nirvanacanada.com/wp-content/uploads/2020/08/home-banner-2.jpg","Web development, also known as website development, refers to the tasks associated with creating, building, and maintaining websites and web applications that run online on a browser. It may, however, also include web design, web programming, and database management.",
                "Design and Develop Website Mass-Mail Dispatcher\n" +
                        "1. The system have been working with in this project is the web-based Mass-Mail Dispatcher. \n" +
                        "2. The application is designed to send mass mails to all the recipients uploaded through a CSV file. \n" +
                        "3. The purpose of this is to provide a tool to control and send emails to a vast number of recipients. \n" +
                        "4. The application will list and sort out all the valid and invalid emails detected by the application allowing the users to more readily send emails as per user convenience. \n" +
                        "5. The end user should be able to upload CSV file. \n" +
                        "6. The application shall list the detected invalid emails found in the CSV File. \n" +
                        "7. The user should be given a structured list of the valid emails. \n" +
                        "INPUT CSV FILE:\n" +
                        "https://drive.google.com/file/d/1kbu3Fu0LQzkM3CQLWXyRoB5Suguq8wqq/view"));
        courses.add(new Courses("Software Developer","https://codersera.com/blog/wp-content/uploads/2021/08/Software-Development-672x372.png","Software development refers to a set of computer science activities dedicated to the process of creating, designing, deploying and supporting software. Software itself is the set of instructions or programs that tell a computer what to do. It is independent of hardware and makes computers programmable.",
                "Building an E-Learning Web application Platform guides you through creating an e-learning platform. You will add fixtures to your project, use model inheritance, create custom model fields, use class-based views, and manage groups and permissions. You will create a content management system and handle formsets."));
        courses.add(new Courses("IOT","https://www.globalsign.com/application/files/7416/3763/0034/General_Banner_WhatisIOT_4_APAC_2021_11_22.jpg","The Internet of Things (IoT) describes the network of physical objects—“things”—that are embedded with sensors, software, and other technologies for the purpose of connecting and exchanging data with other devices and systems over the internet.",
                "OBJECTIVE: \n" +
                        "Develop Intelligent Traffic information System based on Internet of things: \n" +
                        "1. It connected to internet to receive data from traffic center or transmit data to car. \n" +
                        "2. Or it can store data the car take an action according to the received data."));
        courses.add(new Courses("Cyber Security","https://www.elmhurst.edu/wp-content/uploads/2020/03/cybersecurity-vs-information-security-illustration.jpg",
                "Cyber security can be described as the collective methods, technologies, and processes to help protect the confidentiality, integrity, and availability of computer systems, networks and data, against cyber-attacks or unauthorized access.",
                "Encryption and Decryption of Text By Using Caesar Cipher.\n" +
                        " Explaination: For example, if you encrypt the word ‘Software’ by shifting 3 alphabets, then the " +
                        "Caesar chipper for it will be VRIWZDUH. So, you can start by building a Software Interface to " +
                        "break such simple encryption; later on, you can move on to complex concepts. Your software " +
                        "interface should have a space for the input text, and drop option to choose the ‘Shift,’ and a space " +
                        "for the output text, which will be the cipher decoded text." +
                        "\n\n\"Develop Caesar Cipher method using any programming language.\""));
        courses.add(new Courses("Digital Marketing","https://leverageedublog.s3.ap-south-1.amazonaws.com/blog/wp-content/uploads/2020/06/05174400/Types-of-Digital-Marketing-1600x1001.png","Digital marketing, also called online marketing, is the promotion of brands to connect with potential customers using the internet and other forms of digital communication. This includes not only email, social media, and web-based advertising, but also text and multimedia messages as a marketing channel.",
                "1. Work on Social media marketing generate leads for Exposys Data Labs Virtual Internship \n" +
                        "2. Report your leads in the form of xlsheet and send datalabs491@gmail.com\n" +
                        "3. Work on Email Marketing and Write Content about Exposys Data Labs Virtual " +
                        "Internship. \n" +
                        "4. Make Reports \n" +
                        "5. Work on Designs related services \n" +
                        "6. Create short ads"
                       ));
        courses.add(new Courses("UI|UX Design","https://neetable.com/img/services/uiux/ui-ux-design-services.png","UI UX designers create the user interface for an app, website, or other interactive media. Their work includes collaborating with product managers and engineers to gather requirements from users before designing ideas that can be communicated using storyboards. They also process flows or sitemaps.",
                "1. Design the poster that helps you to promote company products or Services. \n" +
                        "2. Use case: Design Exposys Data Labs Virtual Internship Posters With different domains " +
                        "with attractive contents. \n" +
                        "3. Domains Like Data Science,FrontEnd Developer,BackEnd Developer Full Stack \n" +
                        "Developer UI/UX Design Etc…….."));

        CoursesAdapter adapter = new CoursesAdapter(this);
        adapter.setCourses(courses);
        recview.setAdapter(adapter);
        recview.setLayoutManager(new GridLayoutManager(this,1));

    }
}