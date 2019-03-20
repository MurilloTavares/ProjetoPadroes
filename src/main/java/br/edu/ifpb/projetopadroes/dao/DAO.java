package br.edu.ifpb.projetopadroes.dao;

import java.util.List;

public interface DAO <T> {
    
    public void salvar(T t);
    public void atualizar(T t);
    public void remover(T t);
    public T buscar(T t);
    public List<T> listar();
    
}
