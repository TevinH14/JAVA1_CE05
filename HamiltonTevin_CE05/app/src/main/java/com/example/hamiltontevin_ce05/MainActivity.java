package com.example.hamiltontevin_ce05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private final ArrayList<Person> mPersonArrayList = new ArrayList<>();
    private ImageView mMainImage = null;
    private TextView mTvId = null;
    private TextView mTvName = null;
    private TextView mTvDate = null;
    private TextView mTvDescription = null;
    private ListView mMainListView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CreatePerson();

        mMainImage = findViewById(R.id.user_Image);
        mTvDate = findViewById(R.id.tv_display_date);
        mTvDescription = findViewById(R.id.tv_description);
        mTvId = findViewById(R.id.tv_display_id);
        mTvName = findViewById(R.id.tv_display_name);
       int orientation = this.getResources().getConfiguration().orientation;
       if (orientation == Configuration.ORIENTATION_PORTRAIT){
           mMainListView = findViewById(R.id.mainListView);
           mMainListView.setOnItemClickListener(UserSelection);
           SetUpArrayAdapter();
       }else {
           SetUpSpinners();

       }


    }
    private final AdapterView.OnItemClickListener UserSelection = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
            UpdateSelectedUser(pos);
        }
    };

    private void SetUpArrayAdapter(){
        String[] namesArray = new String[10];
        for (int i = 0; i <mPersonArrayList.size() ; i++) {
            namesArray[i] = mPersonArrayList.get(i).getFirstName()+" "+mPersonArrayList.get(i).getLastName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,R.layout.listview_items,R.id.name_listView_item,namesArray);

        mMainListView.setAdapter(adapter);

        UpdateSelectedUser(0);
    }

    private void SetUpSpinners(){
        Spinner mainSpinner;
        mainSpinner = findViewById(R.id.main_spinner);
        mainSpinner.setOnItemSelectedListener(this);


        String[] userString = new String[10];
        for (int i = 0; i <mPersonArrayList.size() ; i++) {
            userString[i] = mPersonArrayList.get(i).getLastName();
        }

        mainSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item,userString);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
       mainSpinner.setAdapter(adapter);

    }


    private void CreatePerson(){
        mPersonArrayList.add(new Person("Sabiha","Franco","10/10/1995",R.drawable.bumblebee, "123456",
                "This man puts you in mind of a playful kitten. He has hooded blue eyes that are like two pools of water. His thick, straight, " +
                        "beige hair is worn in a style that reminds you of a drifting cloud." +
                        " He is very tall and has a thin build. His skin is dark. He has thin lips and a strong chin. His wardrobe is impractacal."));

        mPersonArrayList.add(new Person("Piers","Thorpe","11/11/1997",R.drawable.bullet,"0943522",
                "This gentleman puts you in mind of a regal ruler. He has deep-set eyes the color of milk chocolate. His silky, straight, " +
                        "short hair is the color of obsidian, and is worn in a simple, severe style. He is short and has a lean build. His skin is black." +
                        " He has large hands. His wardrobe is unusual and elaborate, with a completely red color scheme."));

        mPersonArrayList.add(new Person("Jak","Lam","1/15/1998",R.drawable.ezio,"320380",
                "This dishonest guy has slanted brown eyes that are like two bronze coins. He is bald, but used to have silky, straight, " +
                        "midnight black hair. He is tall and has a graceful build. His skin is black. He has bushy eyebrows. His wardrobe is utilitarian" +
                        " and dignified, with a lot of red and black."));

        mPersonArrayList.add(new Person("Marcus","Bloom","12/2/2005",R.drawable.ironman,"4759320",
                "This guy reminds you of a regal dragon. He has deep-set chestnut eyes. He is bald, but used to have fine, straight, black hair." +
                        " He is short and has an elegant build. His skin is tanned. He has prominent ears. His wardrobe is attractive, and is completely red and brown."));

        mPersonArrayList.add(new Person("Humza","Stein","12/26/2007",R.drawable.killzone,"84020495",
                "This girl puts you in mind of a wise owl. She has slitted green eyes that are like two clumps of moss. Her fine, curly, " +
                        "yellow hair is worn in a style that reminds you of a tangled bush. She is very short and has a busty build. Her skin is tan." +
                        " She has full lips and long-fingered hands. Her wardrobe is strange."));

        mPersonArrayList.add(new Person("Sameera","Peck","12/10/2008",R.drawable.masterchief,"8492948",
                "This antisocial gentleman has slitted brown eyes that are like two acorns. His silky, wavy, black hair is worn in a style that reminds you of a seashell. " +
                        "He is very tall and has a graceful build. His skin is deeply-tanned. He has a domed forehead and a large mouth. His wardrobe is strange, and is mostly violet and gray."));

        mPersonArrayList.add(new Person("Aamir","Phan","9/2/2009",R.drawable.predator,"4785930",
                "This contemplative girl has droopy green eyes that are like two emeralds. Her thick, straight, medium-length hair is the color of burnished iron, " +
                        "and is worn in a weird style. She has a wide-hipped build. Her skin is tan. She has hollow cheeks and a pointed chin. Her wardrobe is tight, with a lot of blue and yellow."));

        mPersonArrayList.add(new Person("Nikodem","Kane","12/2/2015",R.drawable.stromtrooper,"58383",
                "This gentleman puts you in mind of a billowing sandstorm. He has round chestnut eyes. His luxurious, curly, " +
                        "gray hair is short and is worn in an attractive, weird style. He has an overmuscled build. His skin is light-colored. He has a hooked nose and a strong chin. " +
                        "His wardrobe is businesslike and plain, with a completely violet and green color scheme."));

        mPersonArrayList.add(new Person("Mandeep","Oconnor","12/5/2016",R.drawable.spiderman,"5820490",
                "This gentleman puts you in mind of a dangerous spider. He has round brown eyes that are like two tiger-eye gems. " +
                        "His thick, wavy, black hair is neck-length and is worn in an uncomplicated, precise style. He's got a beard and moustache. He is tall and has a lithe build. His skin is china-white." +
                        " He has high cheekbones. His wardrobe is sexy, with a lot of gray and white."));

        mPersonArrayList.add(new Person("Keiren","Broughton","9/14/2018",R.drawable.vemon,"57829",
                "This sinful lady has large coffee-colored eyes. Her fine, wavy, waist-length hair is the color of black coffee, and is worn in a severe, " +
                        "utilitarian style. She has a graceful build. Her skin is deeply-tanned. She has an upturned nose. Her wardrobe is dignified and strange, with a mostly green and blue color scheme."));

    }

    private void UpdateSelectedUser(int currentPos){
        mTvId.setText(mPersonArrayList.get(currentPos).getId());

        mTvName.setText(String.format("%s %s", mPersonArrayList.get(currentPos).getFirstName(), mPersonArrayList.get(currentPos).getLastName()));
        mTvDate.setText(mPersonArrayList.get(currentPos).getDate());
        mTvDescription.setText(mPersonArrayList.get(currentPos).getDescription());
        mMainImage.setImageResource(mPersonArrayList.get(currentPos).getUserImage());
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        UpdateSelectedUser(pos);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

