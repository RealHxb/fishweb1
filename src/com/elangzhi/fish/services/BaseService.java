package com.elangzhi.fish.services;

public abstract interface BaseService<T>
{
  public abstract Long save(T paramT);
  
  public abstract Integer deleteById(Long paramLong);
  
  public abstract T findById(Long paramLong);
  
  public abstract Integer updateById(T paramT);
}


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\services\BaseService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */