package com.despedo.rss_msrcedes;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.despedo.rss_msrcedes.adapter.TabsFragmentAdapter;
import com.despedo.rss_msrcedes.dto.NewsDTO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_main;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;

    private TabsFragmentAdapter adapter;

    private List<NewsDTO> data = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolbar();
        initNavigationView();
        initTabs();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.news);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.menu);
    }

    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new TabsFragmentAdapter(getApplicationContext(), getSupportFragmentManager(), new ArrayList<NewsDTO>());
        viewPager.setAdapter(adapter);

        new JSONParse().execute();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.actionStoriesItem:
                        showStoriesTab();
                        break;
                    case R.id.actionVideoItem:
                        showVideoTab();
                        break;
                    case R.id.actionFavouritesItem:
                        showFavouritesTab();
                        break;
                }
                return true;
            }
        });
    }

    private void showStoriesTab() {
        viewPager.setCurrentItem(Constants.TAB_ONE);
    }

    private void showVideoTab() {
        viewPager.setCurrentItem(Constants.TAB_TWO);
    }

    private void showFavouritesTab() {
        viewPager.setCurrentItem(Constants.TAB_THREE);
    }


    private class JSONParse extends AsyncTask<Void, Void, List<NewsDTO>> {
        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected List<NewsDTO> doInBackground(Void... params) {



            HttpHandler sh = new HttpHandler();

            String jsonStr = sh.makeServiceCall(Constants.URL);


            if (jsonStr != null) {
                try {
                    JSONArray news = new JSONArray(jsonStr);

                    for (int i = 0; i < news.length(); i++) {
                        JSONObject n = news.getJSONObject(i);

                        String id = n.getString("id");
                        String link = n.getString("link");
                        String name = n.getString("name");
                        String description = n.getString("description");
                        String cover = n.getString("cover");
                        String top = n.getString("top");
                        String createdAt = n.getString("createdAt");

                        NewsDTO newsDTO = new NewsDTO();
                        newsDTO.setId(id);
                        newsDTO.setLink(link);
                        newsDTO.setName(name);
                        newsDTO.setDescription(description);
                        newsDTO.setCover(cover);
                        newsDTO.setTop(top);
                        newsDTO.setCreatedAt(createdAt);

                        data.add(newsDTO);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return data;
        }

        @Override
        protected void onPostExecute(List<NewsDTO> data) {
            if (pDialog.isShowing())
                pDialog.dismiss();
            adapter.setData(data);
        }
    }
}
