package com.a11.a11;

import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private CardView cardview2;
	private CardView cardview4;
	private CardView cardview1;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private ImageView imageview6;
	private TextView textview2;
	private ImageView imageview7;
	private ImageView imageview8;
	private Button button3;
	private Button button4;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private ImageView imageview18;
	private TextView textview4;
	private ImageView imageview19;
	private ImageView imageview20;
	private ImageView imageview21;
	private ImageView imageview22;
	private ImageView imageview23;
	private ImageView imageview24;
	private Button button7;
	private Button button8;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private ImageView imageview1;
	private TextView textview1;
	private ImageView imageview2;
	private ImageView imageview3;
	private ImageView imageview4;
	private ImageView imageview5;
	private ImageView imageview9;
	private ImageView imageview10;
	private Button button1;
	private Button button2;
	
	private Intent splash = new Intent();
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private DatabaseReference secure = _firebase.getReference("secure");
	private ChildEventListener _secure_child_listener;
	private Intent color_0xml = new Intent();
	private AlertDialog.Builder d;
	private TimerTask ere;
	private AlertDialog.Builder ds;
	private Intent i = new Intent();
	private AlertDialog.Builder dv;
	private DatabaseReference requist = _firebase.getReference("requist");
	private ChildEventListener _requist_child_listener;
	private AlertDialog.Builder sd;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		cardview2 = findViewById(R.id.cardview2);
		cardview4 = findViewById(R.id.cardview4);
		cardview1 = findViewById(R.id.cardview1);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		imageview6 = findViewById(R.id.imageview6);
		textview2 = findViewById(R.id.textview2);
		imageview7 = findViewById(R.id.imageview7);
		imageview8 = findViewById(R.id.imageview8);
		button3 = findViewById(R.id.button3);
		button4 = findViewById(R.id.button4);
		linear14 = findViewById(R.id.linear14);
		linear15 = findViewById(R.id.linear15);
		linear16 = findViewById(R.id.linear16);
		linear17 = findViewById(R.id.linear17);
		imageview18 = findViewById(R.id.imageview18);
		textview4 = findViewById(R.id.textview4);
		imageview19 = findViewById(R.id.imageview19);
		imageview20 = findViewById(R.id.imageview20);
		imageview21 = findViewById(R.id.imageview21);
		imageview22 = findViewById(R.id.imageview22);
		imageview23 = findViewById(R.id.imageview23);
		imageview24 = findViewById(R.id.imageview24);
		button7 = findViewById(R.id.button7);
		button8 = findViewById(R.id.button8);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		imageview2 = findViewById(R.id.imageview2);
		imageview3 = findViewById(R.id.imageview3);
		imageview4 = findViewById(R.id.imageview4);
		imageview5 = findViewById(R.id.imageview5);
		imageview9 = findViewById(R.id.imageview9);
		imageview10 = findViewById(R.id.imageview10);
		button1 = findViewById(R.id.button1);
		button2 = findViewById(R.id.button2);
		req = new RequestNetwork(this);
		d = new AlertDialog.Builder(this);
		ds = new AlertDialog.Builder(this);
		dv = new AlertDialog.Builder(this);
		sd = new AlertDialog.Builder(this);
		
		cardview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dv.setTitle("Confirm Chosen Plan ?");
				dv.setPositiveButton("yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						map = new HashMap<>();
						map.put("plan", textview2.getText().toString());
						requist.push().updateChildren(map);
						sd.setTitle("Your Plan Confirmed !");
						sd.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						sd.create().show();
					}
				});
				dv.setNegativeButton("no", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				dv.create().show();
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ds.setTitle("Silver Pack");
				ds.setMessage("advertise info :\nDuration : 7 Days\nPlatform : Facebook - Insta");
				ds.setIcon(R.drawable.fitx);
				ds.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				ds.create().show();
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ContactActivity.class);
				startActivity(i);
			}
		});
		
		button7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ds.setTitle("Platinum Pack - week");
				ds.setMessage("advertise info :\nDuration : 7 Days\nPlatform : Facebook - Insta - In - YT - TV - Google");
				ds.setIcon(R.drawable.fitx);
				ds.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				ds.create().show();
			}
		});
		
		button8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ContactActivity.class);
				startActivity(i);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ds.setTitle("Golden Pack - week");
				ds.setMessage("advertise info :\nDuration : 14 Days\nPlatform : Facebook - Insta - In - YT - TV - Google");
				ds.setIcon(R.drawable.fitx);
				ds.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				ds.create().show();
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ContactActivity.class);
				startActivity(i);
			}
		});
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				secure.addListenerForSingleValueEvent(new ValueEventListener() {
						@Override
						public void onDataChange(DataSnapshot _dataSnapshot) {
								map1 = new ArrayList<>();
								try {
										GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
										for (DataSnapshot _data : _dataSnapshot.getChildren()) {
												HashMap<String, Object> _map = _data.getValue(_ind);
												map1.add(_map);
										}
								}
								catch (Exception _e) {
										_e.printStackTrace();
								}
								if (map1.get((int)0).get("{G}").toString().equals("ok")) {
										
								}
								else {
										color_0xml.setClass(getApplicationContext(), Color0XmlActivity.class);
										startActivity(color_0xml);
								}
						}
						@Override
						public void onCancelled(DatabaseError _databaseError) {
						}
				});
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				d.setTitle("No internet connection !");
				d.setIcon(R.drawable.fitx);
				d.setPositiveButton("Try again", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						splash.setClass(getApplicationContext(), MainActivity.class);
						startActivity(splash);
					}
				});
				d.setNegativeButton("Exit app", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						finishAffinity();
					}
				});
				d.setCancelable(false);
				d.create().show();
			}
		};
		
		_secure_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		secure.addChildEventListener(_secure_child_listener);
		
		_requist_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		requist.addChildEventListener(_requist_child_listener);
	}
	
	private void initializeLogic() {
		req.startRequestNetwork(RequestNetworkController.GET, "https://google.com", "w", _req_request_listener);
		if (SketchwareUtil.isConnected(getApplicationContext())) {
			ere = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							secure.addListenerForSingleValueEvent(new ValueEventListener() {
									@Override
									public void onDataChange(DataSnapshot _dataSnapshot) {
											map1 = new ArrayList<>();
											try {
													GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
													for (DataSnapshot _data : _dataSnapshot.getChildren()) {
															HashMap<String, Object> _map = _data.getValue(_ind);
															map1.add(_map);
													}
											}
											catch (Exception _e) {
													_e.printStackTrace();
											}
											if (map1.get((int)0).get("{G}").toString().equals("ok")) {
													
											}
											else {
													color_0xml.setClass(getApplicationContext(), Color0XmlActivity.class);
													startActivity(color_0xml);
											}
									}
									@Override
									public void onCancelled(DatabaseError _databaseError) {
									}
							});
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(ere, (int)(0), (int)(400));
			splash.setClass(getApplicationContext(), SplashLoginStartActivity.class);
			startActivity(splash);
		}
		else {
			d.setTitle("No internet connection !");
			d.setIcon(R.drawable.fitx);
			d.setPositiveButton("Try again", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					splash.setClass(getApplicationContext(), MainActivity.class);
					startActivity(splash);
				}
			});
			d.setNegativeButton("Exit app", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					finishAffinity();
				}
			});
			d.setCancelable(false);
			d.create().show();
		}
		cardview1.setCardBackgroundColor(0xFFFFAB00);
		cardview2.setCardBackgroundColor(0xFF9E9E9E);
		cardview4.setCardBackgroundColor(0xFFB0BEC5);
		button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)12, 0xFF2196F3));
		button2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)12, 0xFF2196F3));
		button7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)12, 0xFF2196F3));
		button8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)12, 0xFF2196F3));
		button3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)12, 0xFF2196F3));
		button4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)12, 0xFF2196F3));
		ds = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		ds = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		dv = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		sd = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}