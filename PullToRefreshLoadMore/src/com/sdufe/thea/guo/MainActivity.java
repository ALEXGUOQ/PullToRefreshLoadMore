package com.sdufe.thea.guo;

import java.util.ArrayList;
import java.util.List;

import com.sdufe.thea.guo.view.ListViewLoadMore;
import com.sdufe.thea.guo.view.ListViewLoadMore.IsLoadingListener;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements IsLoadingListener{

	private ListViewLoadMore listView;
	private List<String> list;
	private ArrayAdapter<String> adapter;
	private Handler handler=new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListViewLoadMore) findViewById(R.id.listview);
		initData();
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list);
		listView.setAdapter(adapter);
		listView.setOnLoadingListener(this);
	}

	/**
	 * ��ʼ��listֵ
	 */
	private void initData() {
		list = new ArrayList<String>();

		list.add("123456789");
		list.add("123456789");
		list.add("123456789");
		list.add("123456789");
		list.add("123456789");
		list.add("123456789");
		list.add("123456789");
		list.add("123456789");
		list.add("123456789");
		list.add("123456789");
		list.add("123456789");
		list.add("123456789");
		list.add("123456789");
		list.add("123456789");
		list.add("123456789");
		list.add("123456789");
		list.add("123456789");
	}

	@Override
	public void onLoad() {
		
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				list.add("�ְ�");
				list.add("����");
				list.add("��");
				
				adapter.notifyDataSetChanged();
				listView.complateLoad();
			}
		}, 3000);
		
	}

}
