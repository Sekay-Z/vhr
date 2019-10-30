package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.Position;

import java.util.List;

public interface PositionService {
    public int addPos(Position pos);
    public List<Position> getAllPos();
    public boolean deletePosById(String pids);
    public int updatePosById(Position position);
}
