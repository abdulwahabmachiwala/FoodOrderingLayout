package com.wahab.machiwala.sample;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.khan.maaz.sample.R;


public class MainActivity extends AppCompatActivity {

    Spinner spn;
    Spinner spn1;
    String[] titles;
    String[] desc;
    int[] images = {R.drawable.burger,R.drawable.fries,R.drawable.pp,R.drawable.fcc};
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn=(Spinner) findViewById(R.id.spinner);
        spn1=(Spinner) findViewById(R.id.spinner2);
        ArrayAdapter adp=ArrayAdapter.createFromResource(this,R.array.data,android.R.layout.simple_spinner_item);
                spn.setAdapter(adp);
        ArrayAdapter adp1=ArrayAdapter.createFromResource(this,R.array.data1,android.R.layout.simple_spinner_item);
        spn1.setAdapter(adp1);


        Resources rs = getResources();
        titles= rs.getStringArray(R.array.titles);
        desc= rs.getStringArray(R.array.descriptions);

        lv = (ListView) findViewById(R.id.listview);
        wahab adapter=new wahab(this,titles,images,desc);
        lv.setAdapter(adapter);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom2);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    }


}
class wahab extends ArrayAdapter<String>
{
    private int[] images;
    private Context context;
    private String[] titlearray;
    private String[] descriptionarray;
    wahab(Context c, String[] titles, int imgs[], String[] desc)
    {
        super(c, R.layout.single,R.id.title,titles);
        this.context=c;
        this.images=imgs;
        this.titlearray=titles;
        this.descriptionarray=desc;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single,parent,false);

        ImageView img=(ImageView)row.findViewById(R.id.burger);
        TextView tt=(TextView)row.findViewById(R.id.title);
        TextView tt1=(TextView)row.findViewById(R.id.description);

        img.setImageResource(images[position]);
        tt.setText(titlearray[position]);
        tt1.setText(descriptionarray[position]);

        return row;

    }

}