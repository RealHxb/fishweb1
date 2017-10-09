package com.elangzhi.fish.services;

import com.elangzhi.fish.model.Game;

public abstract interface GameService
  extends BaseService<Game>
{
  public abstract Game findNew();
}


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\services\GameService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */