package com.kiattisak.listview_55410488;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ListAdapter adapter;
	private ListView listview1;
	private ArrayList<List_items> itemsList;
	private int[] drawable = { R.drawable.facebook, R.drawable.google_plush,
			R.drawable.twitter, R.drawable.youtube };

	private String[] title = { "Facebook", "Google+", "Twitter", "Youtube" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview1 = (ListView) findViewById(R.id.listView1);

		itemsList = new ArrayList<List_items>();

		// Add data
		for (int i = 0; i < drawable.length; i++){
			List_items list_items = new List_items();
			list_items.setTitle(title[i]);
			list_items.setDrawable(getResources().getDrawable(drawable[i]));
			itemsList.add(list_items);
			
			
		}
	
		adapter = new Myadapter();
		listview1.setAdapter(adapter);

	}// End onCreate

	private class Myadapter extends BaseAdapter {
		private Holder holder;

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return itemsList.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View view, ViewGroup parent) {
			view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.listview_item,null);
			holder = new Holder();
			holder.imageView = (ImageView) view.findViewById(R.id.item_image);
			holder.txt1 = (TextView) view.findViewById(R.id.item_txt1);
			
			if(itemsList.get(position).getDrawable() != null){
				holder.imageView.setImageDrawable(itemsList.get(position).getDrawable());
				
			}
			if(itemsList.get(position).getTitle() != null){				
				holder.txt1.setText(itemsList.get(position).getTitle());	
			}
			return view;
		}
		public class Holder {
			public TextView	 txt1;
			public ImageView imageView;
		}
	}
}// End Class
