package ir.ac.kntu.controller;

import ir.ac.kntu.exceptions.CanNotInstantiateException;

public interface Controller<T> {
  T create() throws CanNotInstantiateException;
}
