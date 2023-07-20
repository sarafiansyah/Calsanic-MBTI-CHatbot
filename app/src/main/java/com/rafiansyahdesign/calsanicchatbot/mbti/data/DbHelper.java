package com.rafiansyahdesign.calsanicchatbot.mbti.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.rafiansyahdesign.calsanicchatbot.mbti.Question;

import java.util.ArrayList;
import java.util.List;

import static com.rafiansyahdesign.calsanicchatbot.mbti.data.QuizContract.MovieEntry.KEY_EID;
import static com.rafiansyahdesign.calsanicchatbot.mbti.data.QuizContract.MovieEntry.KEY_EQUES;
import static com.rafiansyahdesign.calsanicchatbot.mbti.data.QuizContract.MovieEntry.KEY_MID;
import static com.rafiansyahdesign.calsanicchatbot.mbti.data.QuizContract.MovieEntry.KEY_MQUES;
import static com.rafiansyahdesign.calsanicchatbot.mbti.data.QuizContract.MovieEntry.KEY_NID;
import static com.rafiansyahdesign.calsanicchatbot.mbti.data.QuizContract.MovieEntry.KEY_NQUES;
import static com.rafiansyahdesign.calsanicchatbot.mbti.data.QuizContract.MovieEntry.KEY_TID;
import static com.rafiansyahdesign.calsanicchatbot.mbti.data.QuizContract.MovieEntry.KEY_TQUES;
import static com.rafiansyahdesign.calsanicchatbot.mbti.data.QuizContract.MovieEntry.TABLE_ENERGY;
import static com.rafiansyahdesign.calsanicchatbot.mbti.data.QuizContract.MovieEntry.TABLE_MIND;
import static com.rafiansyahdesign.calsanicchatbot.mbti.data.QuizContract.MovieEntry.TABLE_NATURE;
import static com.rafiansyahdesign.calsanicchatbot.mbti.data.QuizContract.MovieEntry.TABLE_TACTICS;

public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "YourPersonality";
	// tasks table name

	private SQLiteDatabase dbase;
	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase=db;
		String msql = "CREATE TABLE IF NOT EXISTS " + TABLE_MIND + " ( "
				+ KEY_MID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_MQUES + " TEXT)";
		db.execSQL(msql);

		String esql = "CREATE TABLE IF NOT EXISTS " + TABLE_ENERGY + " ( "
				+ KEY_EID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_EQUES + " TEXT)";
		db.execSQL(esql);

		String nsql = "CREATE TABLE IF NOT EXISTS " + TABLE_NATURE + " ( "
				+ KEY_NID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_NQUES + " TEXT)";
		db.execSQL(nsql);

		String tsql = "CREATE TABLE IF NOT EXISTS " + TABLE_TACTICS + " ( "
				+ KEY_TID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ KEY_TQUES + " TEXT)";
		db.execSQL(tsql);

		addMindQuestions();
		addEnergyQuestions();
		addNatureQuestions();
		addTacticsQuestions();

	}
	private void addMindQuestions() {
		Question m1 = new Question("1.Anda merasa kurang berenergi setelah menghabiskan waktu bersama sekelompok orang.");
		this.addMindQuestion(m1);
		Question m2 = new Question("2.Jika seseorang tidak membalas email Anda dengan cepat, Anda mulai bertanya-tanya apakah Anda mengatakan sesuatu yang salah.");
		this.addMindQuestion(m2);
		Question m3 = new Question("3.Jika ruangan penuh, Anda tinggal lebih dekat ke dinding, menghindari bagian tengah.");
		this.addMindQuestion(m3);
		Question m4=new Question("4.Anda merasa sangat cemas dalam situasi stres.");
		this.addMindQuestion(m4);
		Question m5=new Question("5.Anda biasanya tidak memulai percakapan.");
		this.addMindQuestion(m5);

	}
	private void addEnergyQuestions() {
		Question e1 = new Question("6.Anda tetap berpegang pada cara tradisional dalam melakukan tugas umum.");
		this.addEnergyQuestion(e1);
		Question e2 = new Question("7.Anda merasa mudah untuk tetap santai bahkan ketika ada tekanan.");
		this.addEnergyQuestion(e2);
		Question e3 = new Question("8.Anda tidak peduli dengan orang yang menjadikan diri mereka pusat perhatian.");
		this.addEnergyQuestion(e3);
		Question e4=new Question("9.Secara umum, Anda lebih mengandalkan pengalaman Anda daripada imajinasi Anda.");
		this.addEnergyQuestion(e4);
		Question e5=new Question("10.Anda sering merenungkan alasan keberadaan manusia.");
		this.addEnergyQuestion(e5);

	}
	private void addNatureQuestions() {
		Question n1 = new Question("11.Seringkali sulit bagi Anda untuk berhubungan dengan perasaan orang lain.");
		this.addNatureQuestion(n1);
		Question n2 = new Question("12.Anda melihat diri Anda sangat stabil secara emosional.");
		this.addNatureQuestion(n2);
		Question n3 = new Question("13.Memenangkan debat kurang penting bagi Anda daripada memastikan tidak ada yang marah.");
		this.addNatureQuestion(n3);
		Question n4=new Question("14.Suasana hati Anda dapat berubah dengan sangat cepat.");
		this.addNatureQuestion(n4);
		Question n5=new Question("15.Anda lebih cenderung menawarkan dukungan emosional daripada menyarankan cara untuk mengatasi masalah tersebut.");
		this.addNatureQuestion(n5);

	}
	private void addTacticsQuestions() {
		Question t1 = new Question("16.Saat Anda melakukan perjalanan, Anda lebih suka pergi begitu saja tanpa membuat jadwal.");
		this.addTacticsQuestion(t1);
		Question t2 = new Question("17.nda lebih merupakan improvisasi alami daripada perencana yang cermat.");
		this.addTacticsQuestion(t2);
		Question t3 = new Question("18.Anda sering salah menempatkan barang-barang Anda.");
		this.addTacticsQuestion(t3);
		Question t4 = new Question("19.Anda lebih suka berimprovisasi daripada menghabiskan waktu membuat rencana terperinci.");
		this.addTacticsQuestion(t4);
		Question t5 = new Question("20.Gagasan membuat daftar tugas untuk akhir pekan membuat Anda stres.");
		this.addTacticsQuestion(t5);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MIND);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENERGY);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NATURE);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TACTICS);
		// Create tables again
		onCreate(db);
	}
	// Adding new question
	public void addMindQuestion(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_MQUES, quest.getQUESTION());
		// Inserting Row
		dbase.insert(TABLE_MIND, null, values);
	}

	public void addEnergyQuestion(Question questE) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_EQUES, questE.getQUESTION());
		// Inserting Row
		dbase.insert(TABLE_ENERGY, null, values);
	}

	public void addNatureQuestion(Question questN) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_NQUES, questN.getQUESTION());
		// Inserting Row
		dbase.insert(TABLE_NATURE, null, values);
	}

	public void addTacticsQuestion(Question questT) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_TQUES, questT.getQUESTION());
		// Inserting Row
		dbase.insert(TABLE_TACTICS, null, values);
	}

	public List<Question> getAllMindQuestions() {
		List<Question> mindQList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_MIND;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question mindq = new Question();
				mindq.setID(cursor.getInt(0));
				mindq.setQUESTION(cursor.getString(1));

				mindQList.add(mindq);
			} while (cursor.moveToNext());
		}
		// return quest list
		return mindQList;
	}

	public List<Question> getAllEnergyQuestions() {
		List<Question> energyQList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_ENERGY;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question energyq = new Question();
				energyq.setID(cursor.getInt(0));
				energyq.setQUESTION(cursor.getString(1));
				energyQList.add(energyq);
			} while (cursor.moveToNext());
		}
		// return quest list
		return energyQList;
	}

	public List<Question> getAllNatureQuestions() {
		List<Question> natureQList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_NATURE;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question natureq = new Question();
				natureq.setID(cursor.getInt(0));
				natureq.setQUESTION(cursor.getString(1));
				natureQList.add(natureq);
			} while (cursor.moveToNext());
		}
		// return quest list
		return natureQList;
	}

	public List<Question> getAllTacticsQuestions() {
		List<Question> tacticsQList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_TACTICS;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question tacticsq = new Question();
				tacticsq.setID(cursor.getInt(0));
				tacticsq.setQUESTION(cursor.getString(1));
				tacticsQList.add(tacticsq);
			} while (cursor.moveToNext());
		}
		// return quest list
		return tacticsQList;
	}
}
