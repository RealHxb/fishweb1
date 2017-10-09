package com.elangzhi.fish.dao;

import com.elangzhi.fish.model.Person;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface PersonMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract Long insert(Person paramPerson);
  
  public abstract Long insertSelective(Person paramPerson);
  
  public abstract Person selectByPrimaryKey(Long paramLong);
  
  public abstract int updateByPrimaryKeySelective(Person paramPerson);
  
  public abstract int updateByPrimaryKey(Person paramPerson);
  
  public abstract List<Person> listByGame(@Param("gameId") Long paramLong);
  
  public abstract List<Person> listExcludePersonTypeByGame(@Param("gameId") Long paramLong, @Param("type") Integer paramInteger);
  
  public abstract List<Person> listByGameType(@Param("gameId") Long paramLong, @Param("type") Integer paramInteger);
  
  public abstract Person findNewNumber(Long paramLong);
}


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\dao\PersonMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */