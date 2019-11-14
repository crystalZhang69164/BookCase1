package edu.temple.bookcase1;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerFragment extends Fragment {


    ArrayList<BookDetailsFragment> bookDetailsFragmentArrayList;
    //String[] title;
    ArrayList<Book> books;

    final static String TITLE_KEY = "title";
    final static String BOOK_KEY = "books";
    Context parent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookDetailsFragmentArrayList = new ArrayList<>();
        Bundle bundle = getArguments();

        if(bundle != null){
            //title = bundle.getStringArray(TITLE_KEY);
            books = bundle.getParcelableArrayList(BOOK_KEY);
        }

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        parent = context;
    }

    public static ViewPagerFragment newInstance (ArrayList<Book> book){
        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();

        Bundle bundle = new Bundle();


        bundle.putParcelableArrayList(BOOK_KEY,book);
        viewPagerFragment.setArguments(bundle);

        return viewPagerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_view_pager, container,false);





        //
        for(int i = 0; i<books.size(); i++){

            BookDetailsFragment bookFragment = BookDetailsFragment.newInstance(books.get(i));
            bookDetailsFragmentArrayList.add(bookFragment);
        }
        //gets the reference to the view pager
        ViewPager viewPager = view.findViewById(R.id.viewPager2);
        viewPager.setAdapter(new MyFragmentAdapter(getFragmentManager()));

        return view;

    }

    public class MyFragmentAdapter extends FragmentStatePagerAdapter {

        public MyFragmentAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            return bookDetailsFragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return bookDetailsFragmentArrayList.size();
        }
    }
}

