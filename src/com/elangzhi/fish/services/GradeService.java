package com.elangzhi.fish.services;

import com.elangzhi.fish.model.ChouQian;
import com.elangzhi.fish.model.Grade;
import java.util.List;

public abstract interface GradeService
  extends BaseService<Grade>
{
  public abstract List<Grade> findInfo1(Long paramLong, Integer paramInteger1, Integer paramInteger2);
  
  public abstract List<Grade> findInfo2(Long paramLong, Integer paramInteger);
  
  public abstract List<Grade> CheckInfo(Long paramLong, Integer paramInteger1, Integer paramInteger2);
  
  public abstract List<Grade> listByGame(Long paramLong);
  
  public abstract List<Grade> countQu(Long paramLong);
  
  public abstract Grade findByGameChangPerson(Long paramLong1, Integer paramInteger, Long paramLong2);
  
  public abstract List<Grade> gradeShow(Long paramLong, Integer paramInteger1, Integer paramInteger2);
  
  public abstract List<Grade> findDabianGrade(Long paramLong1, Integer paramInteger1, Long paramLong2, Integer paramInteger2);
  
  public abstract List<Grade> jifen(Long paramLong, Integer paramInteger1, Integer paramInteger2);
  
  public abstract Grade findByChangNumber(Long paramLong1, Integer paramInteger, Long paramLong2);
  
  public abstract List<Grade> groupShow(Long paramLong, Integer paramInteger1, Integer paramInteger2);
  
  public abstract List<Grade> gradeCheck(Long paramLong, Integer paramInteger1, Integer paramInteger2);
  
  public abstract List<Grade> zongfenShow(Long paramLong);
  
  public abstract int getMaxGradeByGame(Long paramLong);

  public abstract List<ChouQian> chouQianList(Long gameid, int chang);

public abstract void updateOrInsertGrade(Grade g);	
}


/* Location:              E:\1 CoddingProject\webapps\fishweb.war!\WEB-INF\classes\com\elangzhi\fish\services\GradeService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */