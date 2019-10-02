package com.djohannes.ac.za.service;

import com.djohannes.ac.za.domain.parent.Parent;
import java.util.List;

public interface ParentService extends IService<Parent, String> {

    List<Parent> getAll();
}
