package com.pneizhmak.footapp.service.impl;

import com.pneizhmak.footapp.db.model.Position;
import com.pneizhmak.footapp.db.repository.PositionRepository;
import com.pneizhmak.footapp.service.PositionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Pavel Neizhmak
 */
@Service
@Transactional
public class PositionServiceImpl implements PositionService {

    @Resource
    private PositionRepository positionRepository;

    @Override
    public void savePosition(Position position) {
        positionRepository.save(position);
    }

    @Override
    public Position editPosition(Position position) {
        return null;
    }

    @Override
    public Object[] findAll() {
        return positionRepository.streamAllPositions().toArray();
    }

    @Override
    public void deletePosition(Integer id) {
        positionRepository.delete(id);
    }

    @Override
    public Position getOne(Integer id) {
        return positionRepository.findOne(id);
    }
}
