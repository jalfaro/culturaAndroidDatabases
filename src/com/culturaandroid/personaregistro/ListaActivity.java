package com.culturaandroid.personaregistro;

import java.util.List;

import com.culturaandroid.personaregistro.data.ManagerDB;
import com.culturaandroid.personaregistro.data.Persona;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ListaActivity extends Activity {
	private List<Persona> arrayPersona;
	private ManagerDB conn;
	private ListView lista;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_layout);
		conn= new ManagerDB(this);
		arrayPersona = conn.getPersona();
		lista = (ListView) findViewById(R.id.listPersonas);
		lista.setAdapter(new PersonaAdapter(this,R.layout.row_activity,arrayPersona));
		
	}
	

}
