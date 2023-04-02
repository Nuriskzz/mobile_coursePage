package com.example.mobiletest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mobiletest.adapter.CategoryAdapter;
import com.example.mobiletest.model.Category;
import com.example.mobiletest.model.Course;
import com.example.mobiletest.adapter.CourseAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCoursesList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Мобилька" ));
        categoryList.add(new Category(2, "Сайты" ));
        categoryList.add(new Category(3, "Языки" ));
        categoryList.add(new Category(4, "Прочее" ));

        setCategoryRecycler(categoryList);


        courseList.add(new Course(1, "java", "Профессия Java\nразработчик", "1 января", "начальный", "#424345" , "Test", 1));
        courseList.add(new Course(2, "python", "Профессия Python\nразработчик", "10 января", "начальный", "#9FA52D","Test", 3));
        courseList.add(new Course(3, "csharp", "Профессия C#\nразработчик", "20 января", "начальный", "#572A8D","Test", 2));
        courseList.add(new Course(4, "switchh", "Профессия Switch\nразработчик", "1 февраля", "начальный", "#FD4E33","Test", 1 ));
        courseList.add(new Course(5, "javascript", "Профессия JavaScript\nразработчик", "10 февраля", "начальный", "#ED8D28" ,"Test", 1));
        courseList.add(new Course(6, "php", "Профессия PHP\nразработчик", "1 март", "начальный", "#59ABFF" ,"Test", 2));

        fullCoursesList.addAll(courseList);

        setCourseRecycler(courseList);

    }

    public void openShoppingCart(View view){
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);

    }


    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);// Солға қарай аяғына деиін листать етп кете береді, если TRUE десек тогда ол қайталана береді

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);

    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);// Солға қарай аяғына деиін листать етп кете береді, если TRUE десек тогда ол қайталана береді

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }

    public static void showCoursesByCategory(int category){

        courseList.clear();
        courseList.addAll(fullCoursesList);

        List<Course> filterCourses = new ArrayList<>();

        for(Course c: courseList){
            if (c.getCategory()==category)
                filterCourses.add(c);
        }
        courseList.clear();
        courseList.addAll(filterCourses);
        courseAdapter.notifyDataSetChanged();

    }
}