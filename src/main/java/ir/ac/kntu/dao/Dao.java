package ir.ac.kntu.dao;

import java.util.List;

interface Dao<T> {
  void updateItems(List<T> items);
  List<T> getItems();
  T getItem(String id);
  T deleteItem(String id);
}
