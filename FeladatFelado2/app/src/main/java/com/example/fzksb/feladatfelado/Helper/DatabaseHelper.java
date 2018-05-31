package com.example.fzksb.feladatfelado.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.lang.UScript;
import android.util.Log;

import com.example.fzksb.feladatfelado.Model.Anwser;
import com.example.fzksb.feladatfelado.Model.Exam;
import com.example.fzksb.feladatfelado.Model.Grade;
import com.example.fzksb.feladatfelado.Model.QuizTask;
import com.example.fzksb.feladatfelado.Model.Subject;
import com.example.fzksb.feladatfelado.Model.Task;
import com.example.fzksb.feladatfelado.Model.User;
import com.example.fzksb.feladatfelado.Model.WriteTask;
import com.example.fzksb.feladatfelado.R;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "FeladatFelado";

    // Table Names
    private static final String TABLE_ANWSERS = "anwsers";
    private static final String TABLE_EXAMS = "exams";
    private static final String TABLE_GRADES = "grades";
    private static final String TABLE_QUIZTASK = "quiztasks";
    private static final String TABLE_SUBJECTS = "subjects";
    private static final String TABLE_USERS = "users";
    private static final String TABLE_WRITETASK = "writetasks";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_EXAM = "exam";
    private static final String KEY_QUESTION = "question";
    private static final String KEY_NUMBER = "number";

    // ANWSERS Table - column names
    private static final String KEY_ANWSER = "anwser";
    private static final String KEY_WRITETASKID = "writetaskid";

    // EXAM Table - column names
    private static final String KEY_TEACHER = "teacher";
    private static final String KEY_SUBJECT = "subject";

    // GRADES Table - column names
    private static final String KEY_GRADE = "grade";
    private static final String KEY_STUDENT = "student";

    // QUIZTASK Table - column names
    private static final String KEY_AANWSER = "aanwser";
    private static final String KEY_BANWSER = "banwser";
    private static final String KEY_CANWSER = "canwser";
    private static final String KEY_DANWSER = "danwser";
    private static final String KEY_MOREAVAILABLE = "moreavailable";

    // SUBJECT Table - column names
    private static final String KEY_NAME = "name";

    // USERS Table - column names
    private static final String KEY_USERNAME = "users";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_STUDENTID = "studentid";

    SQLiteDatabase myDB;


    // Table Create Statements
    // Anwsers table create statement
    private static final String CREATE_TABLE_ANWSERS = "CREATE TABLE " + TABLE_ANWSERS
            + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_ANWSER
            + " TEXT NOT NULL," + KEY_WRITETASKID + " INTEGER NOT NULL" + ")";

    // Exams table create statement
    private static final String CREATE_TABLE_EXAMS = "CREATE TABLE "
            + TABLE_EXAMS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_TEACHER
            + " INTEGER NOT NULL," + KEY_SUBJECT + " INTEGER NOT NULL" + ")";

    // Grades table create statement
    private static final String CREATE_TABLE_GRADES = "CREATE TABLE "
            + TABLE_GRADES + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_GRADE
            + " INTEGER NOT NULL," + KEY_STUDENT + " INTEGER NOT NULL" + ")";

    // QuizTasks table create statement
    private static final String CREATE_TABLE_QUIZTASKS = "CREATE TABLE "
            + TABLE_QUIZTASK + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_EXAM
            + " INTEGER NOT NULL," + KEY_QUESTION + " TEXT NOT NULL," + KEY_AANWSER + "TEXT NOT NULL," + KEY_BANWSER + "TEXT NOT NULL," + KEY_CANWSER + "TEXT," + KEY_DANWSER + "TEXT,"
            + KEY_MOREAVAILABLE + "BOOLEAN NOT NULL," + KEY_NUMBER + "INT NOT NULL" +")";

    // Subjects table create statement
    private static final String CREATE_TABLE_SUBJECTS = "CREATE TABLE "
            + TABLE_SUBJECTS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME
            + " TEXT NOT NULL" + " )";

    // Users table create statement
    private static final String CREATE_TABLE_USERS = "CREATE TABLE "
            + TABLE_USERS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_USERNAME
            + " TEXT NOT NULL UNIQUE," + KEY_PASSWORD + " TEXT NOT NULL," + KEY_STUDENTID + "INTEGER NOT NULL" + ")";

    // WriteTask table create statement
    private static final String CREATE_TABLE_WRITETASK = "CREATE TABLE "
            + TABLE_WRITETASK + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_EXAM
            + " TEXT NOT NULL," + KEY_QUESTION + " TEXT NOT NULL," + KEY_NUMBER + "INTEGER NOT NULL" + ")";

    public DatabaseHelper(Context context) {
        super(context, String.valueOf(DATABASE_NAME), null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_ANWSERS);
        db.execSQL(CREATE_TABLE_EXAMS);
        db.execSQL(CREATE_TABLE_GRADES);
        db.execSQL(CREATE_TABLE_QUIZTASKS);
        db.execSQL(CREATE_TABLE_SUBJECTS);
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_WRITETASK);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANWSERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXAMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GRADES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUIZTASK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUBJECTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WRITETASK);

        // create new tables
        onCreate(db);
    }

    //CREATES

    /*
     * Creating an Anwser
     */
    public long createAnwser(Anwser anwser) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ANWSER, anwser.getAnwser());
        values.put(KEY_WRITETASKID, anwser.getWriteTaskId());

        // insert row
        long anwser_id = db.insert(TABLE_ANWSERS, null, values);

        return anwser_id;
    }

    /*
     * Creating an Exam
     */
    public long createExam(Exam exam) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TEACHER, exam.getTeacher());
        values.put(KEY_SUBJECT, exam.getSubject());

        // insert row
        long exam_id = db.insert(TABLE_EXAMS, null, values);

        return exam_id;
    }

    /*
     * Creating an Grades
     */
    public long createGrade(Grade grade) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_GRADE, grade.getGrade());
        values.put(KEY_STUDENT, grade.getStudentId());

        // insert row
        long grade_id = db.insert(TABLE_GRADES, null, values);

        return grade_id;
    }

    /*
     * Creating an QuizTask
     */
    public long createQuizTask(QuizTask quizTask) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EXAM, quizTask.getExam());
        values.put(KEY_QUESTION, quizTask.getQuestion());
        values.put(KEY_AANWSER, quizTask.getAanwser());
        values.put(KEY_BANWSER, quizTask.getBanwser());
        values.put(KEY_CANWSER, quizTask.getCanwser());
        values.put(KEY_DANWSER, quizTask.getDanwser());
        values.put(KEY_MOREAVAILABLE, quizTask.isMoreAvailable());
        values.put(KEY_NUMBER, quizTask.getNumber());

        // insert row
        long quizTask_id = db.insert(TABLE_QUIZTASK, null, values);

        return quizTask_id;
    }

    /*
     * Creating an Subject
     */
    public long createSubject(Subject subject) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, subject.getName());

        // insert row
        long subject_id = db.insert(TABLE_SUBJECTS, null, values);

        return subject_id;
    }

    /*
     * Creating an User
     */
    public long createUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, user.getUsername());
        values.put(KEY_PASSWORD, user.getPassword());
        values.put(KEY_STUDENTID, user.getStudentId());

        // insert row
        long user_id = db.insert(TABLE_USERS, null, values);

        return user_id;
    }

    /*
     * Creating an WriteTask
     */
    public long createQuizTask(WriteTask writeTask) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EXAM, writeTask.getExam());
        values.put(KEY_QUESTION, writeTask.getQuestion());
        values.put(KEY_NUMBER, writeTask.getNumber());

        // insert row
        long writeTask_id = db.insert(TABLE_WRITETASK, null, values);

        return writeTask_id;
    }

    //GETS

    /*
     * get single anwser
     */
    public Anwser getAnwser(String anwserId) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_ANWSERS + " WHERE "
                + KEY_ID + " = " + anwserId;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Anwser anwser = new Anwser();
        anwser.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        anwser.setAnwser((c.getString(c.getColumnIndex(KEY_ANWSER))));
        anwser.setWriteTaskId(c.getColumnIndex(KEY_WRITETASKID));

        return anwser;
    }

    /*
     * getting all anwsers
     * */
    public List<Anwser> getAllAnwsers() {
        List<Anwser> anwsers = new ArrayList<Anwser>();
        String selectQuery = "SELECT  * FROM " + TABLE_ANWSERS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Anwser anwser = new Anwser();
                anwser.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                anwser.setAnwser((c.getString(c.getColumnIndex(KEY_ANWSER))));
                anwser.setWriteTaskId(c.getColumnIndex(KEY_WRITETASKID));

                // adding to anwser
                anwsers.add(anwser);
            } while (c.moveToNext());
        }

        return anwsers;
    }

    /*
     * get single exam
     */
    public Exam getExam(String examId) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_EXAMS + " WHERE "
                + KEY_ID + " = " + examId;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Exam exam = new Exam();
        exam.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        exam.setTeacher(c.getColumnIndex(KEY_TEACHER));
        exam.setSubject(c.getColumnIndex(KEY_SUBJECT));

        return exam;
    }

    /*
     * getting all exams
     * */
    public List<Exam> getAllExams() {
        List<Exam> exams = new ArrayList<Exam>();
        String selectQuery = "SELECT  * FROM " + TABLE_EXAMS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Exam exam = new Exam();
                exam.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                exam.setTeacher(c.getColumnIndex(KEY_TEACHER));
                exam.setSubject(c.getColumnIndex(KEY_SUBJECT));

                // adding to anwser
                exams.add(exam);
            } while (c.moveToNext());
        }

        return exams;
    }

    /*
     * get single grade
     */
    public Grade getGrade(String gradeId) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_GRADES + " WHERE "
                + KEY_ID + " = " + gradeId;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Grade grade = new Grade();
        grade.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        grade.setGrade(c.getColumnIndex(KEY_GRADE));
        grade.setStudentId(c.getColumnIndex(KEY_STUDENTID));

        return grade;
    }

    /*
     * getting all grades
     * */
    public List<Grade> getAllGrades() {
        List<Grade> grades = new ArrayList<Grade>();
        String selectQuery = "SELECT  * FROM " + TABLE_GRADES;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Grade grade = new Grade();
                grade.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                grade.setGrade(c.getColumnIndex(KEY_GRADE));
                grade.setStudentId(c.getColumnIndex(KEY_STUDENTID));

                // adding to anwser
                grades.add(grade);
            } while (c.moveToNext());
        }

        return grades;
    }

    /*
     * get single quiztask
     */
    public QuizTask getQuizTask(String quiztaskId) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_QUIZTASK + " WHERE "
                + KEY_ID + " = " + quiztaskId;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        QuizTask quizTask = new QuizTask();
        quizTask.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        quizTask.setQuestion(c.getString(c.getColumnIndex(KEY_QUESTION)));
        quizTask.setAanwser(c.getString(c.getColumnIndex(KEY_AANWSER)));
        quizTask.setBanwser(c.getString(c.getColumnIndex(KEY_BANWSER)));
        quizTask.setCanwser(c.getString(c.getColumnIndex(KEY_CANWSER)));
        quizTask.setDanwser(c.getString(c.getColumnIndex(KEY_DANWSER)));
        quizTask.setMoreAvailable(c.getColumnIndex(KEY_MOREAVAILABLE));
        quizTask.setNumber(c.getColumnIndex(KEY_NUMBER));

        return quizTask;
    }

    /*
     * getting all quiztask
     * */
    public List<QuizTask> getAllQuizTask() {
        List<QuizTask> quiztasks = new ArrayList<QuizTask>();
        String selectQuery = "SELECT  * FROM " + TABLE_QUIZTASK;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                QuizTask quizTask = new QuizTask();
                quizTask.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                quizTask.setQuestion(c.getString(c.getColumnIndex(KEY_QUESTION)));
                quizTask.setAanwser(c.getString(c.getColumnIndex(KEY_AANWSER)));
                quizTask.setBanwser(c.getString(c.getColumnIndex(KEY_BANWSER)));
                quizTask.setCanwser(c.getString(c.getColumnIndex(KEY_CANWSER)));
                quizTask.setDanwser(c.getString(c.getColumnIndex(KEY_DANWSER)));
                quizTask.setMoreAvailable(c.getColumnIndex(KEY_MOREAVAILABLE));
                quizTask.setNumber(c.getColumnIndex(KEY_NUMBER));

                // adding to anwser
                quiztasks.add(quizTask);
            } while (c.moveToNext());
        }

        return quiztasks;
    }

    /*
     * get single subject
     */
    public Subject getSubject(String subjectId) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_SUBJECTS + " WHERE "
                + KEY_ID + " = " + subjectId;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Subject subject = new Subject();
        subject.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        subject.setName(c.getString(c.getColumnIndex(KEY_NAME)));

        return subject;
    }

    /*
     * getting all subject
     * */
    public List<Subject> getAllSubject() {
        List<Subject> subjects = new ArrayList<Subject>();
        String selectQuery = "SELECT  * FROM " + TABLE_SUBJECTS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Subject subject = new Subject();
                subject.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                subject.setName(c.getString(c.getColumnIndex(KEY_NAME)));

                // adding to anwser
                subjects.add(subject);
            } while (c.moveToNext());
        }

        return subjects;
    }

    /*
     * get single user
     */
    public User getUser(String userId) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_USERS + " WHERE "
                + KEY_ID + " = " + userId;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        User user = new User();
        user.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        user.setUsername(c.getString(c.getColumnIndex(KEY_USERNAME)));
        user.setPassword(c.getString(c.getColumnIndex(KEY_PASSWORD)));
        user.setStudentId(c.getString(c.getColumnIndex(KEY_STUDENTID)));

        return user;
    }

    /*
     * getting all user
     * */
    public List<User> getAllUser() {
        List<User> users = new ArrayList<User>();
        String selectQuery = "SELECT  * FROM " + TABLE_USERS;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                User user = new User();
                user.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                user.setUsername(c.getString(c.getColumnIndex(KEY_USERNAME)));
                user.setPassword(c.getString(c.getColumnIndex(KEY_PASSWORD)));
                user.setStudentId(c.getString(c.getColumnIndex(KEY_STUDENTID)));

                // adding to anwser
                users.add(user);
            } while (c.moveToNext());
        }

        return users;
    }

    /*
     * get single writeTask
     */
    public WriteTask getWriteTask(String writetaskId) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_WRITETASK + " WHERE "
                + KEY_ID + " = " + writetaskId;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        WriteTask writeTask = new WriteTask();
        writeTask.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        writeTask.setExam(c.getColumnIndex(KEY_EXAM));
        writeTask.setQuestion(c.getString(c.getColumnIndex(KEY_QUESTION)));
        writeTask.setNumber(c.getColumnIndex(KEY_NUMBER));

        return writeTask;
    }

    /*
     * getting all writetasks
     * */
    public List<WriteTask> getAllWriteTasks() {
        List<WriteTask> writeTasks = new ArrayList<WriteTask>();
        String selectQuery = "SELECT  * FROM " + TABLE_WRITETASK;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                WriteTask writeTask = new WriteTask();
                writeTask.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                writeTask.setExam(c.getColumnIndex(KEY_EXAM));
                writeTask.setQuestion(c.getString(c.getColumnIndex(KEY_QUESTION)));
                writeTask.setNumber(c.getColumnIndex(KEY_NUMBER));

                // adding to anwser
                writeTasks.add(writeTask);
            } while (c.moveToNext());
        }

        return writeTasks;
    }

    //UPDATES

    /*
     * Updating an anwser
     */
    public int updateAnwser(Anwser anwser) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ANWSER, anwser.getAnwser());
        values.put(KEY_WRITETASKID, anwser.getWriteTaskId());

        // updating row
        return db.update(TABLE_ANWSERS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(anwser.getId()) });
    }

    /*
     * Updating an exam
     */
    public int updateExam(Exam exam) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TEACHER, exam.getTeacher());
        values.put(KEY_SUBJECT, exam.getSubject());

        // updating row
        return db.update(TABLE_EXAMS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(exam.getId()) });
    }

    /*
     * Updating a grade
     */
    public int updateGrade(Grade grade) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_GRADE, grade.getGrade());
        values.put(KEY_STUDENTID, grade.getStudentId());

        // updating row
        return db.update(TABLE_GRADES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(grade.getId()) });
    }

    /*
     * Updating a quiztask
     */
    public int updateQuizTask(QuizTask quizTask) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EXAM, quizTask.getExam());
        values.put(KEY_QUESTION, quizTask.getQuestion());
        values.put(KEY_AANWSER, quizTask.getAanwser());
        values.put(KEY_BANWSER, quizTask.getBanwser());
        values.put(KEY_CANWSER, quizTask.getCanwser());
        values.put(KEY_DANWSER, quizTask.getDanwser());
        values.put(KEY_MOREAVAILABLE, quizTask.isMoreAvailable());
        values.put(KEY_NUMBER, quizTask.getNumber());

        // updating row
        return db.update(TABLE_QUIZTASK, values, KEY_ID + " = ?",
                new String[] { String.valueOf(quizTask.getId()) });
    }

    /*
     * Updating a subject
     */
    public int updateSubjects(Subject subject) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, subject.getName());

        // updating row
        return db.update(TABLE_SUBJECTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(subject.getId()) });
    }

    /*
     * Updating a suser
     */
    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, user.getUsername());
        values.put(KEY_PASSWORD, user.getPassword());
        values.put(KEY_STUDENT, user.getStudentId());

        // updating row
        return db.update(TABLE_USERS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(user.getId()) });
    }

    /*
     * Updating a writetask
     */
    public int updateWriteTask(WriteTask writeTask) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EXAM, writeTask.getExam());
        values.put(KEY_QUESTION, writeTask.getQuestion());
        values.put(KEY_NUMBER, writeTask.getNumber());

        // updating row
        return db.update(TABLE_WRITETASK, values, KEY_ID + " = ?",
                new String[] { String.valueOf(writeTask.getId()) });
    }

    //DELETES

    /*
     * Deleting an anwser
     */
    public void deleteAnwser(Anwser anwser) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_ANWSERS, KEY_ID + " = ?",
                new String[] { String.valueOf(anwser.getId()) });
    }

    /*
     * Deleting an exam
     */
    public void deleteExam(Exam exam) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_EXAMS, KEY_ID + " = ?",
                new String[] { String.valueOf(exam.getId()) });
    }

    /*
     * Deleting a grade
     */
    public void deleteGrade(Grade grade) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_GRADES, KEY_ID + " = ?",
                new String[] { String.valueOf(grade.getId()) });
    }

    /*
     * Deleting a quiztask
     */
    public void deleteQuizTask(QuizTask quizTask) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_QUIZTASK, KEY_ID + " = ?",
                new String[] { String.valueOf(quizTask.getId()) });
    }

    /*
     * Deleting a subject
     */
    public void deleteSubject(Subject subject) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_SUBJECTS, KEY_ID + " = ?",
                new String[] { String.valueOf(subject.getId()) });
    }

    /*
     * Deleting a user
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_USERS, KEY_ID + " = ?",
                new String[] { String.valueOf(user.getId()) });
    }

    /*
     * Deleting a writetask
     */
    public void deleteWriteTask(WriteTask writeTask) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_WRITETASK, KEY_ID + " = ?",
                new String[] { String.valueOf(writeTask.getId()) });
    }

    public void openDB(){
        myDB = getWritableDatabase();

    }

    // closing database
    public void closeDB() {
        if (myDB != null && myDB.isOpen())
            myDB.close();
    }
}
