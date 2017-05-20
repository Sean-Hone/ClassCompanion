package student.seanm.classcompanion;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class ClassInfoActivity extends AppCompatActivity {

    private String courseName;
    private SectionsPagerAdapter sectionPageAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_info);

        Toolbar tBar = (Toolbar) findViewById(R.id.classInfo_toolBar);
        setSupportActionBar(tBar);

        //retrieves the class name and sets that as the title
        Intent intent = getIntent();
        courseName = intent.getStringExtra("Class");
        getSupportActionBar().setTitle(courseName);

        //initialise the drawer layout and set the toggle listener
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.classInfo_drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, tBar,
                R.string.Nav_Drawer_Open, R.string.Nav_Drawer_Close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //adapter that deals with having multiple fragments or tabs
        sectionPageAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        //view pager handles the swiping action between tabs
        viewPager = (ViewPager) findViewById(R.id.classInfo_viewPager);
        viewPager.setAdapter(sectionPageAdapter);

        //links the view pager to the tab layout
        TabLayout tabs = (TabLayout) findViewById(R.id.classInfo_tabs);
        tabs.setupWithViewPager(viewPager);
    }
}
