package jovan.sf_62_2017.postsportal.services.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IGenericService<T,  ID extends Serializable>{

    List<T> get();

    T get(ID id);

    T add(T t);

    T update(T t);

    boolean delete(ID id);
}
