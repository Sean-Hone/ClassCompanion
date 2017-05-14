package student.seanm.classcompanion;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ClassInfoActivity extends AppCompatActivity {

    private String courseName;
    private SectionsPagerAdapter sectionPageAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_info);

        Intent intent = getIntent();
        courseName = intent.getStringExtra("Class");
        this.setTitle(courseName);

        sectionPageAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.classInfo_viewPager);
        viewPager.setAdapter(sectionPageAdapter);

        TabLayout tabs = (TabLayout) findViewById(R.id.classInfo_tabs);
        tabs.setupWithViewPager(viewPager);
    }
}
