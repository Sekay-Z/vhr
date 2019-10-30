package com.shukai.vhrserver.service;

import com.shukai.vhrserver.bean.Position;
import com.shukai.vhrserver.dao.PositionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionDao positionDao;
    @Override
    public int addPos(Position pos) {
        if (positionDao.getPosByName(pos.getName()) != null) {
            return -1;
        }
        return positionDao.addPos(pos);
    }

    @Override
    public List<Position> getAllPos() {
        return positionDao.getAllPos();
    }

    @Override
    public boolean deletePosById(String pids) {
        String[] split = pids.split(",");
        return positionDao.deletePosById(split) == split.length;
    }

    @Override
    public int updatePosById(Position position) {
        return positionDao.updatePosById(position);
    }
}
