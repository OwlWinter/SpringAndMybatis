package cn.mogeek.dao;

import cn.mogeek.domain.Disciple;

import java.util.List;

public interface DiscipleDao {
    List<Disciple> query(Disciple disciple);
    int insert(Disciple disciple);
    int update(Disciple disciple);
    int delete(int id);
}
