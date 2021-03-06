package com.example.adapter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.base.C;
import com.example.mysfmusic.R;
import com.example.service.AppConstant;
import com.example.service.DownloadMusicService;
import com.example.service.PlayerService;
import com.example.utis.MusicInfo;

import android.R.menu;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyListBase1Adapter extends BaseAdapter {

	private List<MusicInfo> infos;
	private ViewHolder viewHolder = null;
	Context context;
	Pattern p = Pattern.compile("[0-9]*");

	public MyListBase1Adapter(Context context, List<MusicInfo> infos) {
		this.infos = infos;
		this.context = context;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return (infos == null) ? 0 : infos.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return infos.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	public class ViewHolder {
		ImageView imageView;
		TextView textViewItem01;
		TextView textViewItem02;
		TextView textViewItem03;

	}

	@SuppressLint("NewApi")
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final MusicInfo info = (MusicInfo) getItem(position);
		// C.SLog("到这来了");
		if (convertView == null) {
			viewHolder = new ViewHolder();
			// C.SLog("新建convertView,position="+position);
			convertView = (View) View.inflate(context, R.layout.list_tab1_item,
					null);
			viewHolder = new ViewHolder();

			viewHolder.textViewItem01 = (TextView) convertView
					.findViewById(R.id.f_01_tv_list_name);
			viewHolder.textViewItem02 = (TextView) convertView
					.findViewById(R.id.f_01_tv_list_musicname);
			viewHolder.textViewItem03 = (TextView) convertView
					.findViewById(R.id.f_01_duration);
			convertView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
			// C.SLog("旧的convertView,position="+position);
		}
		// C.logshow(info.getCover() + "");

		// viewHolder.imageView.setBackground(context.getResources().getDrawable(R.drawable.cc));//context.getResources().getDrawable(R.drawable.bb));
		// viewHolder.imageView.setBackgroundDrawable(drawable);//.setImageResource(convertView.getResources().getDrawable(R.drawable.bb));
		viewHolder.textViewItem01.setText("歌曲名:" + info.getTitle());
		viewHolder.textViewItem02.setText("作者:" + info.getAuthor());
		String length = info.getLength() + "";
		// if(!info.getLength().equals("null")){
		//
		// viewHolder.textViewItem03.setText(info.getLength());
		// }
		if (length.equals("null")) {
			// C.logshow("进来了1:"+length);
		} else {

			Matcher m = p.matcher(length);
			if (m.matches()) {
				viewHolder.textViewItem03.setText(C.getTimeFromInt(Integer
						.parseInt(length)));
			}
		}

		// viewHolder.imageView.setImageResource(R.drawable.ic_launcher);
		// 对ListView中的每一行信息配置OnClick事件

		return convertView;
	}

}
