package com.khadijanaveed.grocerystore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

//  for carousel
    private int[] mImage = new int[]{
            R.drawable.groceryitems,R.drawable.watermelon, R.drawable.dryfruits, R.drawable.dryfruitsandveg, R.drawable.fruits, R.drawable.cokecar, R.drawable.colddrinks
    };
// for drawer navigation
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        for carousel
        setContentView(R.layout.activity_home);
        CarouselView carouselView = findViewById(R.id.carousel);
        carouselView.setPageCount(mImage.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImage[position]);

            }
        });
//        for drawer navigation
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
//        for click event of navigation items
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.fruits:
                        Toast.makeText(getApplicationContext(), "Fruits Clicked", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(home.this, fruits.class);
                        startActivity(intent);
                        break;
                    case R.id.vegetables:
                        Toast.makeText(getApplicationContext(), "Vegetables Clicked", Toast.LENGTH_LONG).show();
                        intent = new Intent(home.this, vegetables.class);
                        startActivity(intent);
                        break;
                    case R.id.seafood:
                        Toast.makeText(getApplicationContext(), "Sea food clicked", Toast.LENGTH_LONG).show();
                        intent = new Intent(home.this, seafood.class);
                        startActivity(intent);
                        break;
                    case R.id.grocery:
                        Toast.makeText(getApplicationContext(), "Grocery clicked", Toast.LENGTH_LONG).show();
                        intent = new Intent(home.this, grocery.class);
                        startActivity(intent);
                        break;
                    case R.id.beverages:
                        Toast.makeText(getApplicationContext(), "Beverages clicked", Toast.LENGTH_LONG).show();
                        intent = new Intent(home.this, beverages.class);
                        startActivity(intent);
                        break;
                    case R.id.dairy:
                        Toast.makeText(getApplicationContext(), "dairy clicked", Toast.LENGTH_LONG).show();
                        intent = new Intent(home.this, dairy.class);
                        startActivity(intent);
                        break;
                    case R.id.bakery:
                        Toast.makeText(getApplicationContext(), "bakery clicked", Toast.LENGTH_LONG).show();
                        intent = new Intent(home.this, bakery.class);
                        startActivity(intent);
                        break;
                    case R.id.mycart:
                        Toast.makeText(getApplicationContext(), "My cart clicked", Toast.LENGTH_LONG).show();
                        intent = new Intent(home.this, mycart.class);
                        startActivity(intent);
                        break;
                    case R.id.share:
                        Toast.makeText(getApplicationContext(), "Share clicked", Toast.LENGTH_LONG).show();
//                        intent = new Intent(home.this, products.class);
//                        startActivity(intent);
                        break;
                    case R.id.signin:
                        Toast.makeText(getApplicationContext(), "Signin clicked", Toast.LENGTH_LONG).show();
                        intent = new Intent(home.this, signup.class);
                        startActivity(intent);
                        break;
                    case R.id.logout:
                        Toast.makeText(getApplicationContext(), "Logout clicked", Toast.LENGTH_LONG).show();
                        intent = new Intent(home.this, login.class);
                        startActivity(intent);
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
//        switch (item.getItemId())
//        {
//            case R.id.fruits:
//                Intent intent = new Intent(this,fruits.class);
//                startActivity(intent);
//                break;
////            case R.id.vegetables:
////                intent = new Intent(this, vegetables.class);
////                startActivity(intent);
////                break;
//        }
//        drawerLayout.closeDrawer(GravityCompat.START);
//        return true;
    }
}