package com.culturaandroid.personaregistro;

import com.culturaandroid.personaregistro.data.ManagerDB;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ManagerDB conn;
	private EditText txtNombre,txtCorreo,txtTelefono;
	private Button btnGrabar,btnConsulta;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		btnGrabar = (Button) findViewById(R.id.btnGrabar);
		btnConsulta = (Button)findViewById(R.id.btnConsulta);
		txtNombre = (EditText) findViewById(R.id.txtNombre);
		txtCorreo = (EditText) findViewById(R.id.txtCorreo);
		txtTelefono = (EditText) findViewById(R.id.txtTelefono);
		
		btnGrabar.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				conn = new ManagerDB(getBaseContext());
				conn.insertPersona(txtNombre.getText().toString(), txtCorreo.getText().toString(), txtTelefono.getText().toString());
				txtNombre.setText("");
				txtCorreo.setText("");
				txtTelefono.setText("");
				Toast.makeText(getBaseContext(),"Persona grabada satisfactoriamente", Toast.LENGTH_LONG).show();
			}});
		btnConsulta.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(),ListaActivity.class);
				startActivity(i);
				
			}});
	}

	

}
