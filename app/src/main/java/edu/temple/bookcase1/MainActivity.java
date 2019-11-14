package edu.temple.bookcase1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BookListFragment.BookSelectedInterface {

    BookDetailsFragment bookDetailsFragment = new BookDetailsFragment();
    String code;
    ArrayList<JSONObject> jsonObjectArrayList = new ArrayList<JSONObject>();
    JSONArray jsonArray = new JSONArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //the json parser and threads
        //-----------------------------------------
        Intent intent = getIntent();
        if(Intent.ACTION_VIEW.equals(intent.getAction())){
            code = intent.getData().getPath();
        }
        findViewById(R.id.btnSearch).setOnClickListener(V ->{
            Intent viewIntent = new Intent(Intent.ACTION_VIEW);
            viewIntent.setData(Uri.parse("https://kamorris.com/lab/audlib/booksearch.php"));
            if(viewIntent.resolveActivity(getPackageManager()) != null){
                startActivity(viewIntent);
            }
        });


        ViewPager pager;
        Boolean singlePane = (findViewById(R.id.frame2) == null);

        //gets the array of books from the string.xml file
        ArrayList<Book> books = new ArrayList<Book>();//getResources().getStringArray(R.array.books);
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

    //threads
//-------------------------------------------------------

    Thread thread = new Thread(){
        public void run(){
            for(int i = 0; i< jsonObjectArrayList.size(); i++){
                Message msg = handler.obtainMessage();

            }
            URL url = null;
            try {
                url = code == null? new URL("https://kamorris.com/lab/audlib/booksearch.php")
                        : new URL("https://kamorris.com/lab/audlib/" + code + "/booksearch.php");
                BufferedReader reader = null;

                reader = new BufferedReader(new InputStreamReader(url.openStream()));

                StringBuilder builder = new StringBuilder();
                String response;

                while((response = reader.readLine()) != null){

                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };


    //----------------------------------------------------
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {


            return false;
        }
    });





    //displays the book title in the details fragment in landscape mode when
    //a specific book has been clicked in the list view
    @Override
    public void bookSelected(Book book) {
        bookDetailsFragment.DisplayBook(book);
    }
}

