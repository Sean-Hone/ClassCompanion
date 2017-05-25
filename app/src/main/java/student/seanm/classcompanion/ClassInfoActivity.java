package student.seanm.classcompanion;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

//implements OnNavigationItemSelectedListener to put method
public class ClassInfoActivity extends AppCompatActivity {

    public static String courseName;
    private SectionsPagerAdapter sectionPageAdapter;
    private ViewPager viewPager;
    private NavigationView navView;
    private Menu navMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_info);

        //retrieves the class name and sets that as the name to be passed during population
        Intent intent = getIntent();
        courseName = intent.getStringExtra("Class");

        Toolbar tBar = (Toolbar) findViewById(R.id.classInfo_toolBar);
        setSupportActionBar(tBar);

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

        //get references to the navigation view and its menu object
        navView = (NavigationView) findViewById(R.id.classInfo_navMenu);
        navMenu = navView.getMenu();

        //create the listener for when a nav view item is clicked
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return menuItemPressed(item);
            }
        });

        //populate the navigation menu and action bar with correct titles and item names
        populateClassInfo();
    }

    public boolean menuItemPressed(MenuItem item){
        //Repopulates parts of activity with the new class that was selected
        String title = item.getTitle().toString();
        courseName = title;
        populateClassInfo();

        //closes the navigation menu after repopulating activity
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.classInfo_drawerLayout);
        drawer.closeDrawer(GravityCompat.START);

        //recreates all tabs after name changes have been made
        viewPager.setAdapter(sectionPageAdapter);
        return true;
    }

    @Override
    public void onBackPressed() {
        //makes it so that pressing the back button closes the nav menu rather than returning to parent activity
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.classInfo_drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //fills in class info activity with information specific to activity
    public void populateClassInfo(){

        //sets the title of the action bar to be the name of the class
        getSupportActionBar().setTitle(courseName);

        //change header text
        View header = navView.getHeaderView(0);
        TextView headerText = (TextView) header.findViewById(R.id.ci_navHead_name_tv);
        headerText.setText(courseName);

        int menuPos = 1; //menu item number
        String[] classes = this.getResources().getStringArray(R.array.classes); //array or class names
        MenuItem menuItem; //reference to menu item being changed

        //4 will instead be number of courses
        for(int i=0; i<4; i++){
            if(courseName.equals(classes[i])) continue; //don't rename item if name is the current class
            //gets the id for the nav item with of number i
            int id = (getResources().getIdentifier("navItem" + menuPos, "id", this.getPackageName()));
            menuItem = navMenu.findItem(id); //gets reference to menu item of given id
            menuItem.setTitle(classes[i]); //changes title of menu item to be that of the next class
            menuPos++;
        }
    }
}
