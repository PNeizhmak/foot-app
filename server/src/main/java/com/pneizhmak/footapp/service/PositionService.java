package com.pneizhmak.footapp.service;

import com.pneizhmak.footapp.db.model.Position;

/**
 * @author Pavel Neizhmak
 */
public interface PositionService {

    void savePosition(Position position);

    Position editPosition(Position position);

    Object[] findAll();

    void deletePosition(Integer id);

    Position getOne(Integer id);
}
