package com.zhuyu.downloadlibrary;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Created by zhu_yu on 2017/10/30.
 */

public class DownloadDialog extends DialogFragment {
	public static final String EXTRA_TITLE = "title";
	public static final String EXTRA_URL = "url";
	public static final String EXTRA_filepath = "filepath";
	public static final String EXTRA_ISFORCE = "isforce";

	private ProgressBar progressBar;
	private TextView progress1Tv;
	private TextView progress2Tv;

	DownloadTask downloadTask = null;

	private String filePath;

	public static DownloadDialog newInstance(String url,String filePath,boolean isforceUpdate) {
		DownloadDialog dialog = new DownloadDialog();
		Bundle bundle = new Bundle();
		bundle.putString(EXTRA_URL, url);
		bundle.putString(EXTRA_filepath, filePath);
		bundle.putBoolean(EXTRA_ISFORCE, isforceUpdate);
		dialog.setArguments(bundle);

		return dialog;
	}

	private String url = "";
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		View view = LayoutInflater.from(getActivity()).inflate(R.layout.download_dialog_layout, null);
		initView(view);

		url = getArguments().getString(EXTRA_URL);

		boolean isforce=getArguments().getBoolean(EXTRA_ISFORCE);
		filePath= getArguments().getString(EXTRA_filepath);
		
		 AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(getActivity()).setView(view)
				 .setTitle("正在下载").setCancelable(false)
				 // 对于点击返回键不消失，需要监听OnKeyListener:
					.setOnKeyListener(new DialogInterface.OnKeyListener() {
						@Override
						public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
							if (keyCode == KeyEvent.KEYCODE_BACK) {
								return true;
							}
							return false;
						}
					});
			
		
		
		if(isforce){
		
		}else{
	
			dialogBuilder.	setNegativeButton("取消下载", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					downloadTask.cancelDownload();
				}
			});
		}
//		.setNeutralButton("暂停", new DialogInterface.OnClickListener() {
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				downloadTask.pauseDownload();
//			}
//		})
		 
		 
		 
		 
		
		
		

		return dialogBuilder.create();
		

	}
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		// 点击外部不消失的方法：
		getDialog().setCanceledOnTouchOutside(false);
		startDownload(url,filePath);
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	

	private void initView(View view) {

		progressBar = (ProgressBar) view.findViewById(R.id.dialog_progressBar);
		progress1Tv = (TextView) view.findViewById(R.id.dialog_progress1Tv);
		progress2Tv = (TextView) view.findViewById(R.id.dialog_progress2Tv);


	}

	private void startDownload(String downloadUrl,String filepath) {
		if (downloadTask == null) {
			downloadTask = new DownloadTask(getActivity(), filepath,new DownloadListener() {
				@Override
				public void onSuccess() {
					progressBar.setProgress(100);
					progress1Tv.setText("100%");
					progress2Tv.setText("100/100");

					getDialog().dismiss();
					// installApk();
					if (mListener != null) {
						mListener.onSuccess();
					}
				}

				@Override
				public void onProgress(int progress) {
					progressBar.setProgress(progress);
					progress1Tv.setText(progress + "%");
					progress2Tv.setText(progress + "/100");
				}

				@Override
				public void onFailed() {
					getDialog().dismiss();
					if (mListener != null) {
						mListener.onError();
						
					}
				}

				@Override
				public void onCanceled() {
					
				}

				@Override
				public void onPaused() {

				}
			});
			// 执行task
			downloadTask.execute(downloadUrl);
		}

	}

	DownloadSimpleListener mListener;

	public interface DownloadSimpleListener {
		public void onSuccess();

		public void onError();
	}

	public void setDownloadListener(DownloadSimpleListener listener) {
		mListener = listener;
	}

//	public void startDownload(){
//		startDownload(url);
//	}
@Override
public void show(FragmentManager manager, String tag) {
	//super.show(manager, tag);

	FragmentTransaction ft = manager.beginTransaction();
	ft.add(this, tag);
	ft.commitAllowingStateLoss();
	//LogUtil.i("", "tag=" + tag);
}


	/**
	 * 与 show方法对应，避免bug
	 * zhuyu
	 * 2019年3月13日添加，如有问题，直接删除该方法
	 */
	@Override
	public void dismiss() {
		// TODO Auto-generated method stub
		if ( getActivity() != null && !getActivity().isFinishing()) {
			super.dismissAllowingStateLoss();
		}


	}


}
