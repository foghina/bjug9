package com.oghina.felix.bjug9;

import android.app.ActionBar;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class MainActivity extends ListActivity implements ActionBar.OnNavigationListener {

    public static final int ITEMS = 10000;
    
    private ListAdapter bad;
    private ListAdapter good;
    private ListAdapter awesome;
    private ListAdapter twotone;
    
    /**
     * The serialization (saved instance state) Bundle key representing the
     * current dropdown position.
     */
    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the action bar to show a dropdown list.
        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        // Set up the dropdown list navigation in the action bar.
        actionBar.setListNavigationCallbacks(
        // Specify a SpinnerAdapter to populate the dropdown list.
                new ArrayAdapter<String>(actionBar.getThemedContext(), android.R.layout.simple_list_item_1,
                        android.R.id.text1, new String[] { getString(R.string.title_section1),
                                getString(R.string.title_section2), getString(R.string.title_section3),
                                getString(R.string.title_section4) }), this);
        
        bad = new BadAdapter(this);
        good = new GoodAdapter(this);
        awesome = new AwesomeAdapter(this);
        twotone = new TwoToneAdapter(this);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore the previously serialized current dropdown position.
        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
            getActionBar().setSelectedNavigationItem(savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Serialize the current dropdown position.
        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar().getSelectedNavigationIndex());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(int position, long id) {
        switch(position) {
        case 0:
            setListAdapter(bad);
            break;
        case 1:
            setListAdapter(good);
            break;
        case 2:
            setListAdapter(awesome);
            break;
        case 3:
            setListAdapter(twotone);
            break;
        }
        return true;
    }

}
