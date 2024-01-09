package com.a11.a11;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class SplashLoginStartActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout splash;
	private ScrollView vscroll1;
	private LinearLayout linear7;
	private ImageView imageview4;
	private LinearLayout linear1;
	private ImageView imageview2;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private Button button1;
	private Button button2;
	private TextView textview1;
	private LinearLayout linear4;
	private EditText edittext1;
	private EditText edittext2;
	private ImageView imageview1;
	private ImageView imageview3;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	
	private FirebaseAuth user;
	private OnCompleteListener<AuthResult> _user_create_user_listener;
	private OnCompleteListener<AuthResult> _user_sign_in_listener;
	private OnCompleteListener<Void> _user_reset_password_listener;
	private OnCompleteListener<Void> user_updateEmailListener;
	private OnCompleteListener<Void> user_updatePasswordListener;
	private OnCompleteListener<Void> user_emailVerificationSentListener;
	private OnCompleteListener<Void> user_deleteUserListener;
	private OnCompleteListener<Void> user_updateProfileListener;
	private OnCompleteListener<AuthResult> user_phoneAuthListener;
	private OnCompleteListener<AuthResult> user_googleSignInListener;
	
	private Intent chk = new Intent();
	private TimerTask asd;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.splash_login_start);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		splash = findViewById(R.id.splash);
		vscroll1 = findViewById(R.id.vscroll1);
		linear7 = findViewById(R.id.linear7);
		imageview4 = findViewById(R.id.imageview4);
		linear1 = findViewById(R.id.linear1);
		imageview2 = findViewById(R.id.imageview2);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		button1 = findViewById(R.id.button1);
		button2 = findViewById(R.id.button2);
		textview1 = findViewById(R.id.textview1);
		linear4 = findViewById(R.id.linear4);
		edittext1 = findViewById(R.id.edittext1);
		edittext2 = findViewById(R.id.edittext2);
		imageview1 = findViewById(R.id.imageview1);
		imageview3 = findViewById(R.id.imageview3);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		user = FirebaseAuth.getInstance();
		
		linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				button1.setVisibility(View.GONE);
				linear7.setVisibility(View.GONE);
				button2.setVisibility(View.VISIBLE);
				vbeUtil.showMessage(getApplicationContext(), "Create an Account");
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("") || edittext2.getText().toString().equals("")) {
					dseUtil.showMessage(getApplicationContext(), "Enter Valid username or password");
				}
				else {
					user.signInWithEmailAndPassword(edittext1.getText().toString().concat("@z11s.com"), edittext2.getText().toString()).addOnCompleteListener(SplashLoginStartActivity.this, _user_sign_in_listener);
					chk.setClass(getApplicationContext(), ChkActivity.class);
					startActivity(chk);
				}
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("") || edittext2.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Enter user name and password");
				}
				else {
					user.createUserWithEmailAndPassword(edittext1.getText().toString().concat("@z11s.com"), edittext2.getText().toString()).addOnCompleteListener(SplashLoginStartActivity.this, _user_create_user_listener);
					button2.setVisibility(View.GONE);
					button1.setVisibility(View.VISIBLE);
					aseUtil.showMessage(getApplicationContext(), "Done ;) Login now with created Account");
					astil.showMessage(getApplicationContext(), "Done ;) Login now with created Account");
				}
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				button1.setVisibility(View.VISIBLE);
				button2.setVisibility(View.GONE);
				linear7.setVisibility(View.VISIBLE);
			}
		});
		
		edittext2.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (edittext2.getText().toString().length() < 8) {
					((EditText)edittext2).setError("( 8 ) or more");
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		user_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		user_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		user_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		user_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		user_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		user_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		user_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_user_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_user_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_user_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			asd = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							finish();
						}
					});
				}
			};
			_timer.schedule(asd, (int)(1200));
		}
		else {
			asd = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							splash.setVisibility(View.GONE);
						}
					});
				}
			};
			_timer.schedule(asd, (int)(1200));
		}
		button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
		button2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
		edittext2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/bein.ttf"), 0);
		button2.setVisibility(View.GONE);
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
