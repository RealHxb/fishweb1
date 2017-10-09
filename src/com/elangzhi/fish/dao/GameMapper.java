package com.elangzhi.fish.dao;

import com.elangzhi.fish.model.Game;
import java.util.List;

public abstract interface GameMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);
  
  public abstract Long insert(Game paramGame);
  
  public abstract Long insertSelective(Game paramGame);
  
  public abstract Game selectByPrimaryKey(Long paramLong);
  
  public abstract int updateByPrimaryKeySelective(Game paramGame);
  
  public abstract int updateByPrimaryKey(Game paramGame);
  
  public abstract List<Game> list();
}


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\dao\GameMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */