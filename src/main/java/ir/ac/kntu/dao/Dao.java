package ir.ac.kntu.dao;

import java.util.ArrayList;

interface Dao<T> {
  void updateItems(ArrayList<T> items);
  ArrayList<T> getItems();
  T getItem(int id);
  T deleteItem(int id);
}
