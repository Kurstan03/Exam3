package service;

import model.Person;
import model.User;

import java.util.List;

public interface GenericService <T> {
    String add(List<T> t);
    T getById(Long id);
    String removeByName(String name);
    List<T> getAll();
    List<T> sortByName();        //1 ди басканда ascending, 2 ни басканда descending кылып сорттосун
    List<T> filterByGender();    //1 ди басканда female, 2 ни басканда male кылып фильтрлесин
    List<T> clear();
}
