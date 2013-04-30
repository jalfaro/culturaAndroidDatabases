package com.culturaandroid.personaregistro.data;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ManagerDB {
	private static final String NOMBRE= "Persona";
	private static final int VERSION = 1;
	
	public static final String TBL_PERSONA = "persona";
	public static final String FLD_ID = "id";
	public static final String FLD_NOMBRE = "nombre";
	public static final String FLD_CORREO ="email";
	public static final String FLD_TELEFONO = "tel";
	
	private Context ctx;
	private PersonaManager conn;
	
	public ManagerDB(Context ctx) {
		this.ctx= ctx;
		conn = new PersonaManager(ctx);
	}
	
	public void insertPersona (String nombre,String correo,String telefono) {
		SQLiteDatabase db = conn.getWritableDatabase();
		String insertQuery = "INSERT INTO " + TBL_PERSONA + " ("+FLD_NOMBRE+"," +
				FLD_CORREO+"," + FLD_TELEFONO+") VALUES ('"+nombre+"','" + correo +"','" +
				telefono+"')";
		db.execSQL(insertQuery);
		db.close();
	}
	public List<Persona> getPersona() {
		ArrayList<Persona> array = new ArrayList<Persona>();
		Persona temp;
		SQLiteDatabase db = conn.getReadableDatabase();
		String queryString = "SELECT "+FLD_NOMBRE+"," +FLD_CORREO+"," + FLD_TELEFONO+" FROM " + TBL_PERSONA;
		Cursor c = db.rawQuery(queryString, null);
		c.moveToFirst();
		while (!c.isAfterLast()) {
			temp= new Persona();
			temp.setNombre(c.getString(c.getColumnIndex(FLD_NOMBRE)));
			temp.setCorreo(c.getString(c.getColumnIndex(FLD_CORREO)));
			temp.setTelefono(c.getString(c.getColumnIndex(FLD_TELEFONO)));
			array.add(temp);
			c.moveToNext();
		}
		c.close();
		db.close();
		return array;
	}
	
	class PersonaManager extends SQLiteOpenHelper {

		public PersonaManager(Context context) {
			super(context, NOMBRE, null, VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String createPersonaQuery = "CREATE TABLE " + TBL_PERSONA + " (" + FLD_ID +
					" INTEGER PRIMARY KEY AUTOINCREMENT," + FLD_NOMBRE + " TEXT," +
					FLD_CORREO + " TEXT," + FLD_TELEFONO + " TEXT)";
			db.execSQL(createPersonaQuery);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			String modPersonaQuery = "DROP TABLE " + TBL_PERSONA;
			db.execSQL(modPersonaQuery);
		}
		
		
	}

}
