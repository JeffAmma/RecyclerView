package dongyang.jeff.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   private RecyclerView recyclerView;
   private MyAdapter myAdapter;
   private List<RecycylerItem> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        for (int i=0; i<10; i++) {
            list.add(new RecycylerItem("ITEM " + (i+1), "Welcome to Recycler View List" + (i+1)));
        }
        myAdapter = new MyAdapter(list,this);
        recyclerView.setAdapter(myAdapter);

    }
}
