package com.culturaandroid.personaregistro;

import java.util.List;

import com.culturaandroid.personaregistro.data.Persona;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PersonaAdapter extends ArrayAdapter<Persona> {
	private Context ctx;
	private int layout;
	private List<Persona> datos;
	public PersonaAdapter(Context context, int textViewResourceId,
			List<Persona> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		ctx = context;
		layout =textViewResourceId;
		datos = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v=convertView;
		Persona temp;
		if (v==null) {
			LayoutInflater li = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = li.inflate(layout, null);
		}
		temp = datos.get(position);
		if (temp!=null) {
			TextView t1,t2,t3;
			t1 = (TextView)v.findViewById(R.id.txtrowNombre);
			t2 = (TextView)v.findViewById(R.id.txtrowCorre);
			t3 = (TextView)v.findViewById(R.id.txtrowTelefono);
			t1.setText(temp.getNombre());
			t2.setText(temp.getCorreo());
			t3.setText(temp.getTelefono());
			
		}
		return v;
	}
	

}
