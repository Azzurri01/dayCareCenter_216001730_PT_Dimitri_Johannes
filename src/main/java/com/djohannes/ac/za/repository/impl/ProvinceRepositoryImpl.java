package com.djohannes.ac.za.repository.impl;

import com.djohannes.ac.za.domain.Province;
import com.djohannes.ac.za.repository.ProvinceRepository;

import java.util.HashSet;
import java.util.Set;

public class ProvinceRepositoryImpl implements ProvinceRepository {

    private static ProvinceRepositoryImpl repository = null;
    private Set<Province> provinces;

    private ProvinceRepositoryImpl() {
        this.provinces = new HashSet<>();
    }

    private Province findProvince(String provinceId) {
        /*return this.provinces.stream()
                .filter(province -> province.getNo().trim().equals(provinceId))
                .findAny()
                .orElse(null);*/
        return null;
    }

    public static ProvinceRepositoryImpl getRepository(){
        if(repository == null) repository = new ProvinceRepositoryImpl();
        return repository;
    }

    public Province create(Province province){
        this.provinces.add(province);
        return province;
    }

    public Province read(final String provinceId){
        //find the student in the set and return it if it exist
        Province province = findProvince(provinceId);
        return province;
    }

    public Province update(Province province) {
        // find the student, update it and return the updated student
        Province toDelete = findProvince(province.getId());
        if(toDelete != null) {
            this.provinces.remove(toDelete);
            return create(province);
        }
        return null;
    }

    public void delete(String provinceId) {
        //find the student and delete it if it exists
        Province province = findProvince(provinceId);
        if (province != null) this.provinces.remove(province);
    }

    public Set<Province> getAll(){
        return this.provinces;
    }
}