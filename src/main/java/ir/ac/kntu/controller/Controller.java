package ir.ac.kntu.controller;

import ir.ac.kntu.exceptions.CanNotInstantiateException;

import java.io.File;

public interface Controller<T> {
  T create() throws CanNotInstantiateException;
}
