package edu.temple.bookcase1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements BookListFragment.BookSelectedInterface {

    BookDetailsFragment bookDetailsFragment = new BookDetailsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewPager pager;
        Boolean singlePane = (findViewById(R.id.frame2) == null);

        //gets the array of books from the string.xml file
        String[] books = getResources().getStringArray(R.array.books);
        ViewPagerFragment viewPagerFragment = ViewPagerFragment.newInstance(books);
        BookListFragment bookListFragment = BookListFragment.newInstance(books);



        //gets reference of book list view
        ListView listView = findViewById(R.id.listViewBooks);

        //gets reference to the viewPager
        ViewPager viewPager = findViewById(R.id.viewPager2);


        //gets a reference to that fragment
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame1);

        BookListFragment bookListFragment1 = BookListFragment.newInstance(books);


        //the landscape mode fragment
        if (!singlePane) {
            if ((fragment instanceof ViewPagerFragment) || (fragment instanceof BookListFragment)){
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();

            }
            getSupportFragmentManager().beginTransaction().add(R.id.frame1, bookListFragment1).commit();

            getSupportFragmentManager().beginTransaction().add(R.id.frame2, bookDetailsFragment).commit();

        } else {
            if (fragment instanceof BookListFragment) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            }
            //the view pager in portrait mode
            getSupportFragmentManager().beginTransaction().add(R.id.frame1, viewPagerFragment).commit();
        }


    }




    //displays the book title in the details fragment in landscape mode when
    //a specific book has been clicked in the list view
    @Override
    public void bookSelected(String title) {
        bookDetailsFragment.DisplayBook(title);
    }
}

