package cn.mogeek.service;

import cn.mogeek.domain.Disciple;

import java.util.List;
import java.util.Map;

public interface Service {
    List<Disciple> query(Disciple disciple);
    int insert(Disciple disciple);
    boolean update(Disciple disciple);
    boolean delete(int id);
    String queryForLink(Map<String,String> name_OR_id);
}
