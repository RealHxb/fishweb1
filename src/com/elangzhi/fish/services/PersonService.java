package com.elangzhi.fish.services;

import com.elangzhi.fish.model.Person;
import java.util.List;

public abstract interface PersonService
  extends BaseService<Person>
{
  public abstract List<Person> listByGame(Long paramLong);
  
  public abstract List<Person> listExcludePersonTypeByGame(Long paramLong, Integer paramInteger);
  
  public abstract List<Person> listByGameType(Long paramLong, int paramInt);
  
  public abstract Person findNewNumber(Long paramLong);
}


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\services\PersonService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */