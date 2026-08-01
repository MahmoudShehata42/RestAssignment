package org.example.restassignment.repositories;

import java.util.List;

public interface IRepository <t>{
    public void add(t entity);
    public void update(t entity);
    public void delete(int id);
    public t getByID(int id);
    public List<t> getAll();
}
