package com.mehdilagdimi.chiforek.base.interfaces;

import com.mehdilagdimi.chiforek.entity.errand.CarPoolErrand;
import com.mehdilagdimi.chiforek.entity.errand.GoodsTransportErrand;
import com.mehdilagdimi.chiforek.entity.errand.RelocationErrand;
import com.mehdilagdimi.chiforek.entity.errand.PersonsTransportErrand;

public interface ServiceVisitor {
   void visit(PersonsTransportErrand personsTransportErrand);
   void visit(GoodsTransportErrand personsTransportErrand);
   void visit(RelocationErrand relocationErrand);
   void visit(CarPoolErrand carPoolErrand);
}
