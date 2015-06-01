package it.flashr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
	
	private EditText usernameTxt;
	private EditText passwordTxt;
	private Button loginBtn;
	private String generatedPassword = FlashrUtils.getSHA256(generatePasswordString());
	
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

	    usernameTxt = (EditText)findViewById(R.id.username);
	    passwordTxt = (EditText)findViewById(R.id.password);
	    loginBtn = (Button)findViewById(R.id.login_btn);
	    passwordTxt.setText(generatedPassword);
	    
	    loginBtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String username= usernameTxt.getText().toString();
				String password= passwordTxt.getText().toString();
				
				if(!username.equals("") && password.equals(generatedPassword)){
					Intent loginIntent = new Intent(getApplicationContext(),FlashrIt3Activity.class);
					startActivity(loginIntent);
				}
			}
		});
	}

	private String generatePasswordString() {
		 return FlashrUtils.RandomPasswordGenerator.generateRandomPassword(5);
	}
	
	
}
