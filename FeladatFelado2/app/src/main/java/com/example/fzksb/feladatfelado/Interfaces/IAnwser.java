package com.example.fzksb.feladatfelado.Interfaces;

import com.example.fzksb.feladatfelado.Helper.DatabaseHelper;
import com.example.fzksb.feladatfelado.Model.Anwser;

public interface IAnwser {
    public long createAnwser(Anwser anwser, DatabaseHelper db);
}
